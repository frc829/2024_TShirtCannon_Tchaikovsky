package lib.motortypes.arms;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController.ArbFFUnits;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.trajectory.ExponentialProfile;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.units.Unit;
import edu.wpi.first.units.Velocity;
import lib.motormechanisms.controlrequests.AngularPositionRequest;
import lib.motormechanisms.controlrequests.AngularVelocityRequest;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.MotorControllerType;

public class REV_MAXArmMotor extends CANSparkMax implements ArmMotor {
    private final ArmFeedforward feedforward;
    private final TrapezoidProfile trapezoid;
    private final ExponentialProfile exponentialProfile;
    private final SlewRateLimiter slewRateLimiter;
    private final TrapezoidProfile.State trapGoalState = new TrapezoidProfile.State();
    private final ExponentialProfile.State expoGoalState = new ExponentialProfile.State();
    private TrapezoidProfile.State lastTrapState = new TrapezoidProfile.State();
    private final ExponentialProfile.State lastExpoState = new ExponentialProfile.State();

    public REV_MAXArmMotor(REV_MAXArmMotorConfig config) {
        super(config.deviceNumber(), MotorType.kBrushless);
        setInverted(config.invertedValue());
        setIdleMode(config.idleMode());
        getEncoder().setAverageDepth(config.averageDepth());
        getEncoder().setMeasurementPeriod(config.samplePeriodMs());
        getEncoder().setPositionConversionFactor(2 * Math.PI / config.sensorToMechanismRatio());
        getEncoder().setVelocityConversionFactor(2 * Math.PI / config.sensorToMechanismRatio() / 60.0);
        getPIDController().setP(config.voltagePositionKp(), 0);
        getPIDController().setI(config.voltagePositionKi(), 0);
        getPIDController().setD(config.voltagePositionKd(), 0);
        getPIDController().setP(config.voltageVelocityKp(), 1);
        getPIDController().setI(config.voltageVelocityKi(), 1);
        getPIDController().setD(config.voltageVelocityKd(), 1);
        feedforward = new ArmFeedforward(config.voltageKs(), config.voltageKg(), config.voltageKv(), config.voltageKa());
        trapezoid = new TrapezoidProfile(new TrapezoidProfile.Constraints(config.maxVelocityRadPerSec(), config.maxAccelerationRadPerSecSquared()));
        exponentialProfile = new ExponentialProfile(ExponentialProfile.Constraints.fromCharacteristics(12.0, config.voltageKv(), config.voltageKa()));
        slewRateLimiter = new SlewRateLimiter(config.maxAccelerationRadPerSecSquared());
        
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
     
        return MotorControllerType.REV_SPARK_FLEX;
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
    public double getAngleDegrees() {
       
        return Units.radiansToDegrees(getEncoder().getPosition());

    }

    @Override
    public void setAngleDegrees(double angleDegrees) {
       
        getEncoder().setPosition(Units.degreesToRadians(angleDegrees));
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
    public void acceptPositionVoltage(AngularPositionRequest request) {
        double feedForwardVoltage = feedforward.calculate(Units.degreesToRadians(getAngleDegrees()), 0.0);
        getPIDController().setReference(request.getAngleDegrees(), ControlType.kPosition, 0, feedForwardVoltage, ArbFFUnits.kVoltage);
        lastTrapState.position = Units.degreesToRadians(getAngleDegrees());
        lastTrapState.velocity = Units.degreesToRadians(getAngularVelocityDegreesPerSecond());
        trackExpoFromTrap();
    }


    @Override
    public void acceptTrapPositionVoltage(AngularPositionRequest request) {
        // TODO: set trapGoalState.position to Units.degreesToRadians() passing in angle from request
        // TODO: set trapGoalState.velocity to 0.0;
        // TODO: set lastTrapState to trapezoidProfile.calculate(0.020, lastTrapState, trapGoalState)
        // TODO: create a double called feedForwardVoltage and get from feedfoward.calculate(Units.degreesToRadians(request.getAngleDegrees()), lastTrapState.velocity)
        // TODO: call getPIDController().setReference passing in lastTrapState.position, Controltype.kPosition, 0, feedforwardVoltags, ArbFFUnits.kVoltage
        // TODO: call trackExpoFromTrap()
        trapGoalState.position = Units.degreesToRadians(request.getAngleDegrees());
        trapGoalState.velocity = 0.0;
        lastTrapState = trapezoid.calculate(0.020, lastTrapState, trapGoalState);
    }

    @Override
    public void acceptExpoPositionVoltage(AngularPositionRequest request) {
        // TODO: set expoGoalState.position to Units.degreesToRadians() passing in angle from request
        // TODO: set expoGoalState.velocity to 0.0;
        // TODO: set lastExpoState to exponentialProfile.calculate(0.020, lastExpoState, expoGoalState)
        // TODO: create a double called feedForwardVoltage and get from feedfoward.calculate(Units.degreesToRadians(request.getAngleDegrees()), lastExpoState.velocity)
        // TODO: call getPIDController().setReference passing in lastExpoState.position, Controltype.kPosition, 0, feedforwardVoltags, ArbFFUnits.kVoltage
        // TODO: call trackTrapFromExpo()
    }


    @Override
    public void acceptVelocityVoltage(AngularVelocityRequest request) {
        // TODO: create a double called feedforwardVoltage and get from feedforward.calculate(Units.degreesToRadians(getAngles(), Units.degreesToRadians(request.getAngularVelocityDegreesPerSecond)));
        // TODO: call getPIDController().setReference passing in Units.degreestoRadians(request.getAngularVelocityDegreesPerSecond(), ControlType.kVelocity, 1, feedfowardVoltage, ArbFFUnits.kVoltage
        // TODO: set lastTrapState.position to Units.degreesToRadians(getAngleDegrees)
        // TODO: repeat for lastTrapState.velocity using velocity
        // TODO: set lastExpoState.position to lastTrapState.position
        // TODO: repeat for lastExpoState's velocity
        // TODO: call slewRateLimiter's reset method passing in lastTrapState.velocity
    }

    @Override
    public void acceptTrapVelocityVoltage(AngularVelocityRequest request) {
        // TODO: set lastTrapState.velocity to slewRateLimiter.calculate(Units.degreesToRadians() passing in velocity from request.
        // TODO: create a double called feedforwardVoltage and get from feedforward.calculate() passing in Units.degreesToRadians(getAngle()), lastTrapState.velocity.
        // TODO: call getPIDController().setReference passing in lastTrapState.velocity, ControlType.kVelocity, 1, feedforwardVoltage, ArbFFUnits.kVoltage
        // TODO: set lastTrapState.position to Units.degreesToRadians(getAngleDegrees)
        // TODO: set lastExpoState.position to lastTrapState.position
        // TODO: repeat for lastExpoState's velocity.
    }

    @Override
    public void acceptPositionCurrent(AngularPositionRequest request) {
        // TODO: call acceptTrapPositionVoltage(request);
    }

    @Override
    public void acceptTrapPositionCurrent(AngularPositionRequest request) {
        // TODO: call acceptTrapPositionVoltage(request);
    }


    @Override
    public void acceptExpoPositionCurrent(AngularPositionRequest request) {
        // TODO: call acceptExpoPositionCurrent(request);
    }

    @Override
    public void acceptVelocityCurrent(AngularVelocityRequest request) {
        // TODO: call acceptVelocityVoltage(request);
    }

    @Override
    public void acceptTrapVelocityCurrent(AngularVelocityRequest request) {
        // TODO: call acceptTrapVelocityVoltage(request);
    }

    private void trackExpoFromTrap() {
        // TODO: set lastExpoState.position to lastTrapState.position
        // TODO: repeat for lastExpoState.velocity for velocity.
        // TODO: call slewRateLimiter's reset method passing in lastTrapState.velocity.
    }

    private void trackTrapFromExpo() {
        // TODO: set lastTrapState.position to lastExpoState.position
        // TODO: repeat for lastTrapState.velocity for velocity.
        // TODO: call slewRateLimiter's reset method passing in lastExpoState.velocity.
    }
}
