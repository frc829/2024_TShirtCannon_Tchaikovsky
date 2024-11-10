package lib.motortypes.intakes;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.controls.*;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.util.Units;
import lib.motortypes.MotorControllerType;
import lib.motormechanisms.controlrequests.angular.velocity.current.CurrentAngularVelocityRequest;
import lib.motormechanisms.controlrequests.angular.velocity.trapezoidal.CurrentTrapezoidAngularVelocityRequest;
import lib.motormechanisms.controlrequests.angular.velocity.trapezoidal.VoltageTrapezoidAngularVelocityRequest;
import lib.motormechanisms.controlrequests.angular.velocity.voltage.VoltageAngularVelocityRequest;
import lib.motormechanisms.controlrequests.motor.CurrentRequest;
import lib.motormechanisms.controlrequests.motor.VoltageRequest;

public class CTREIntakeMotor extends TalonFX implements IntakeMotor {
    private final VoltageOut voltageOut = new VoltageOut(0.0).withEnableFOC(false);
    private final TorqueCurrentFOC torqueCurrentFOC = new TorqueCurrentFOC(0.0);
    private final VelocityVoltage velocityVoltage = new VelocityVoltage(0.0).withSlot(0).withEnableFOC(false);
    private final VelocityTorqueCurrentFOC velocityTorqueCurrentFOC = new VelocityTorqueCurrentFOC(0.0).withSlot(1);
    private final MotionMagicVelocityVoltage motionMagicVelocityVoltage = new MotionMagicVelocityVoltage(0.0).withSlot(0).withEnableFOC(false);
    private final MotionMagicVelocityTorqueCurrentFOC motionMagicVelocityTorqueCurrentFOC = new MotionMagicVelocityTorqueCurrentFOC(0.0).withSlot(1).withEnableFOC(true);

    public CTREIntakeMotor(CTREIntakeMotorConfig config) {
        super(config.deviceNumber(), config.canbus());
        MotorOutputConfigs motorOutputConfigs = new MotorOutputConfigs()
                .withNeutralMode(config.neutralModeValue())
                .withInverted(config.invertedValue());
        FeedbackConfigs feedbackConfigs = new FeedbackConfigs()
                .withRotorToSensorRatio(config.rotorToSensorRatio())
                .withSensorToMechanismRatio(config.sensorToMechanismRatio());
        Slot0Configs slot0Configs = new Slot0Configs()
                .withKS(config.voltageKs())
                .withKV(config.voltageKv())
                .withKA(config.voltageKa())
                .withKP(config.voltageKp())
                .withKI(config.voltageKi())
                .withKD(config.voltageKd());
        Slot1Configs slot1Configs = new Slot1Configs()
                .withKS(config.currentKs())
                .withKV(config.currentKv())
                .withKA(config.currentKa())
                .withKP(config.currentKp())
                .withKI(config.currentKi())
                .withKD(config.currentKd());
        MotionMagicConfigs motionMagicConfigs = new MotionMagicConfigs()
                .withMotionMagicCruiseVelocity(config.maxVelocityRadPerSec())
                .withMotionMagicAcceleration(config.maxAccelerationRadPerSecSquared())
                .withMotionMagicJerk(config.maxJerkRadPerSecCubed());
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration()
                .withMotorOutput(motorOutputConfigs)
                .withFeedback(feedbackConfigs)
                .withSlot0(slot0Configs)
                .withSlot1(slot1Configs)
                .withMotionMagic(motionMagicConfigs);
        getConfigurator().apply(talonFXConfiguration);
    }

    @Override
    public int getCanId() {
        return getDeviceID();
    }

    @Override
    public String getCanNetworkName() {
        return getNetwork();
    }

    @Override
    public MotorControllerType getMotorControllerType() {
        return MotorControllerType.CTRE_TALON_FX;
    }

    @Override
    public double getCurrentAmps() {
        return getTorqueCurrent().getValueAsDouble();
    }

    @Override
    public double getVoltageVolts() {
        return getMotorVoltage().getValueAsDouble();
    }

    @Override
    public double getAngularVelocityDegreesPerSecond() {
        return Units.radiansToDegrees(getVelocity().getValueAsDouble());
    }

    @Override
    public void accept(VoltageRequest request) {
        voltageOut.withOutput(request.getVolts());
        setControl(voltageOut);
    }

    @Override
    public void accept(CurrentRequest request) {
        torqueCurrentFOC.withOutput(request.getCurrentAmps());
        setControl(torqueCurrentFOC);
    }

    @Override
    public void accept(VoltageAngularVelocityRequest request) {
        velocityVoltage.withVelocity(Units.degreesToRadians(request.getAngularVelocityDegreesPerSecond()));
        setControl(velocityVoltage);
    }


    @Override
    public void accept(VoltageTrapezoidAngularVelocityRequest request) {
        motionMagicVelocityVoltage.withVelocity(Units.degreesToRadians(request.getAngularVelocityDegreesPerSecond()));
        setControl(motionMagicVelocityVoltage);
    }

    @Override
    public void accept(CurrentAngularVelocityRequest request) {
        motionMagicVelocityTorqueCurrentFOC.withVelocity(Units.degreesToRadians(request.getAngularVelocityDegreesPerSecond()));
        setControl(motionMagicVelocityTorqueCurrentFOC);
    }

    @Override
    public void accept(CurrentTrapezoidAngularVelocityRequest request) {
        velocityTorqueCurrentFOC.withVelocity(Units.degreesToRadians(request.getAngularVelocityDegreesPerSecond()));
        setControl(velocityTorqueCurrentFOC);
    }




}