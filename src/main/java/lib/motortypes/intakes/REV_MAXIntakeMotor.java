package lib.motortypes.intakes;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController.ArbFFUnits;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.util.Units;
import lib.motormechanisms.controlrequests.AngularVelocityRequest;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.MotorControllerType;

public class REV_MAXIntakeMotor extends CANSparkMax implements IntakeMotor {
    private final SimpleMotorFeedforward feedforward;
    private final SlewRateLimiter slewRateLimiter;

    public REV_MAXIntakeMotor(REV_MAXIntakeMotorConfig config) {
        super(config.deviceNumber(), MotorType.kBrushless);
        setInverted(config.invertedValue());
        setIdleMode(getIdleMode());
        getEncoder().setAverageDepth(config.averageDepth());
        getEncoder().setMeasurementPeriod(config.samplePeriodMs());
        getEncoder().setPositionConversionFactor(2 * Math.PI/config.sensorToMechanismRatio());
        getEncoder().setVelocityConversionFactor(2 * Math.PI / config.sensorToMechanismRatio() / 60.0);
        getPIDController().setP(config.voltagePositionKp(), 0);
        getPIDController().setI(config.voltagePositionKi(), 0);
        getPIDController().setD(config.voltagePositionKd(), 0);
        getPIDController().setP(config.voltageVelocityKp(), 1);
        getPIDController().setI(config.voltageVelocityKi(), 1);
        getPIDController().setD(config.voltageVelocityKd(), 1);
        new SimpleMotorFeedforward (config.voltageKs(), config.voltageKv(), config.voltageKa());
        new SlewRateLimiter(config.maxAccelerationRadPerSecSquared());
    }

    @Override
    public int getCanId() {
        return getDeviceId();
    }

    @Override
    public String getCanNetworkName() {
        return "rio";
    }

    @Override
    public MotorControllerType getMotorControllerType() {
        return MotorControllerType.REV_SPARK_MAX;
    }

    @Override
    public double getCurrentAmps() {
        return getOutputCurrent();

    }

    @Override
    public double getVoltageVolts() {
        return getAppliedOutput() * getBusVoltage();
    }

    @Override
    public double getAngularVelocityDegreesPerSecond() {
        return Units.radiansToDegrees(getEncoder().getVelocity());
    }

    @Override
    public void accept(VoltageRequest request) {
        getPIDController().setReference(request.getVolts(), ControlType.kVoltage);
    }

    @Override
    public void accept(CurrentRequest request) {
        getPIDController().setReference(request.getCurrentAmps(), ControlType.kCurrent);
    }

    @Override
    public void acceptVelocityVoltage(AngularVelocityRequest request) {
        double feedforwardVoltage = feedforward.calculate(getAngularVelocityDegreesPerSecond(), request.getAngularVelocityDegreesPerSecond(), 0.020);
        getPIDController().setReference(request.getAngularVelocityDegreesPerSecond(), ControlType.kVelocity, 1, feedforwardVoltage, ArbFFUnits.kVoltage);
        slewRateLimiter.reset(feedforwardVoltage);
    }

    @Override
    public void acceptTrapVelocityVoltage(AngularVelocityRequest request) {
        double velocity = slewRateLimiter.calculate(request.getAngularVelocityDegreesPerSecond());
        double feedforwardVoltage = feedforward.calculate(getAngularVelocityDegreesPerSecond(), request.getAngularVelocityDegreesPerSecond(), 0.20);
        getPIDController().setReference(request.getAngularVelocityDegreesPerSecond(), ControlType.kVelocity, 1, feedforwardVoltage, ArbFFUnits.kVoltage)
    }

    @Override
    public void acceptVelocityCurrent(AngularVelocityRequest request) {
        acceptVelocityVoltage(request);
    }

    @Override
    public void acceptTrapVelocityCurrent(AngularVelocityRequest request) {
        acceptTrapVelocityVoltage(request);
    }
}
