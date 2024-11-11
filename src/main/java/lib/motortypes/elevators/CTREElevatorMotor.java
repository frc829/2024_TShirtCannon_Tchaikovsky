package lib.motortypes.elevators;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.controls.*;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.LinearPositionRequest;
import lib.motormechanisms.controlrequests.LinearVelocityRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.MotorControllerType;

public class CTREElevatorMotor extends TalonFX implements ElevatorMotor {
    private final VoltageOut voltageOut = new VoltageOut(0.0).withEnableFOC(false);
    private final TorqueCurrentFOC torqueCurrentFOC = new TorqueCurrentFOC(0.0);
    private final PositionVoltage positionVoltage = new PositionVoltage(0.0).withSlot(0).withEnableFOC(false);
    private final VelocityVoltage velocityVoltage = new VelocityVoltage(0.0).withSlot(2).withEnableFOC(false);
    private final PositionTorqueCurrentFOC positionTorqueCurrentFOC = new PositionTorqueCurrentFOC(0.0).withSlot(1);
    private final VelocityTorqueCurrentFOC velocityTorqueCurrentFOC = new VelocityTorqueCurrentFOC(0.0).withSlot(2);
    private final MotionMagicVoltage motionMagicVoltage = new MotionMagicVoltage(0.0).withSlot(0).withEnableFOC(false);
    private final MotionMagicExpoVoltage motionMagicExpoVoltage = new MotionMagicExpoVoltage(0.0).withSlot(0).withEnableFOC(false);
    private final MotionMagicTorqueCurrentFOC motionMagicTorqueCurrentFOC = new MotionMagicTorqueCurrentFOC(0.0).withSlot(1);
    private final MotionMagicExpoTorqueCurrentFOC motionMagicExpoTorqueCurrentFOC = new MotionMagicExpoTorqueCurrentFOC(0.0).withSlot(1);
    private final MotionMagicVelocityVoltage motionMagicVelocityVoltage = new MotionMagicVelocityVoltage(0.0).withSlot(2).withEnableFOC(false);
    private final MotionMagicVelocityTorqueCurrentFOC motionMagicVelocityTorqueCurrentFOC = new MotionMagicVelocityTorqueCurrentFOC(0.0).withSlot(2).withEnableFOC(true);

    private final Slot2Configs voltageSlot2Configs;
    private final Slot2Configs currentSlot2Configs;
    private final MotionMagicConfigs voltageMotionMagicConfigs;
    private final MotionMagicConfigs currentMotionMagicConfigs;
    private Slot2Configs slot2ConfigsUsing;
    private MotionMagicConfigs motionMagicConfigsUsing;

    public CTREElevatorMotor(CTREElevatorMotorConfig config) {
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
                .withKG(config.voltageKg())
                .withKP(config.voltagePositionKp())
                .withKI(config.voltagePositionKi())
                .withKD(config.voltagePositionKd())
                .withGravityType(GravityTypeValue.Elevator_Static);
        Slot1Configs slot1Configs = new Slot1Configs()
                .withKS(config.currentKs())
                .withKV(config.currentKv())
                .withKA(config.currentKa())
                .withKG(config.currentKg())
                .withKP(config.currentPositionKp())
                .withKI(config.currentPositionKi())
                .withKD(config.currentPositionKd())
                .withGravityType(GravityTypeValue.Elevator_Static);
        voltageSlot2Configs = new Slot2Configs()
                .withKS(config.voltageKs())
                .withKV(config.voltageKv())
                .withKA(config.voltageKa())
                .withKG(config.voltageKg())
                .withKP(config.voltageVelocityKp())
                .withKI(config.voltageVelocityKi())
                .withKD(config.voltageVelocityKd())
                .withGravityType(GravityTypeValue.Elevator_Static);
        currentSlot2Configs = new Slot2Configs()
                .withKS(config.currentKs())
                .withKV(config.currentKv())
                .withKA(config.currentKa())
                .withKG(config.currentKg())
                .withKP(config.currentVelocityKp())
                .withKI(config.currentVelocityKi())
                .withKD(config.currentVelocityKd())
                .withGravityType(GravityTypeValue.Elevator_Static);
        voltageMotionMagicConfigs = new MotionMagicConfigs()
                .withMotionMagicCruiseVelocity(config.maxVelocityMetersPerSecond())
                .withMotionMagicAcceleration(config.maxAccelerationMetersPerSecSquared())
                .withMotionMagicJerk(config.maxJerkMetersPerSecCubed())
                .withMotionMagicExpo_kV(config.voltageKv())
                .withMotionMagicExpo_kA(config.voltageKa());
        currentMotionMagicConfigs = new MotionMagicConfigs()
                .withMotionMagicCruiseVelocity(config.maxVelocityMetersPerSecond())
                .withMotionMagicAcceleration(config.maxAccelerationMetersPerSecSquared())
                .withMotionMagicJerk(config.maxJerkMetersPerSecCubed())
                .withMotionMagicExpo_kV(config.currentKv())
                .withMotionMagicExpo_kA(config.currentKa());
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration()
                .withMotorOutput(motorOutputConfigs)
                .withFeedback(feedbackConfigs)
                .withSlot0(slot0Configs)
                .withSlot1(slot1Configs)
                .withSlot2(voltageSlot2Configs)
                .withMotionMagic(voltageMotionMagicConfigs);
        getConfigurator().apply(talonFXConfiguration);
        slot2ConfigsUsing = voltageSlot2Configs;
        motionMagicConfigsUsing = voltageMotionMagicConfigs;
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
    public double getPositionMeters() {
        return getPosition().getValueAsDouble();
    }

    @Override
    public void setLinearPosition(double positionMeters) {
        setPosition(positionMeters);
    }

    @Override
    public double getVelocityMetersPerSecond() {
        return getVelocity().getValueAsDouble();
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
    public void acceptPositionVoltage(LinearPositionRequest request) {
        positionVoltage.withPosition(request.getPositionMeters());
        setControl(positionVoltage);
    }

    @Override
    public void acceptTrapPositionVoltage(LinearPositionRequest request) {
        motionMagicVoltage.withPosition(request.getPositionMeters());
        setControl(motionMagicVoltage);
    }

    @Override
    public void acceptExpoPositionVoltage(LinearPositionRequest request) {
        if (!motionMagicConfigsUsing.equals(voltageMotionMagicConfigs)) {
            getConfigurator().apply(voltageMotionMagicConfigs);
            motionMagicConfigsUsing = voltageMotionMagicConfigs;
        }
        motionMagicExpoVoltage.withPosition(request.getPositionMeters());
        setControl(motionMagicExpoVoltage);
    }

    @Override
    public void acceptVelocityVoltage(LinearVelocityRequest request) {
        velocityVoltage.withVelocity(request.getVelocityMetersPerSecond());
        setControl(velocityVoltage);
    }


    @Override
    public void acceptTrapVelocityVoltage(LinearVelocityRequest request) {
        if (!slot2ConfigsUsing.equals(voltageSlot2Configs)) {
            getConfigurator().apply(voltageSlot2Configs);
            slot2ConfigsUsing = voltageSlot2Configs;
        }
        motionMagicVelocityVoltage.withVelocity(request.getVelocityMetersPerSecond());
        setControl(motionMagicVelocityVoltage);
    }

    @Override
    public void acceptPositionCurrent(LinearPositionRequest request) {
        positionTorqueCurrentFOC.withPosition(request.getPositionMeters());
        setControl(positionTorqueCurrentFOC);
    }

    @Override
    public void acceptTrapPositionCurrent(LinearPositionRequest request) {
        motionMagicTorqueCurrentFOC.withPosition(request.getPositionMeters());
        setControl(motionMagicTorqueCurrentFOC);
    }


    @Override
    public void acceptExpoPositionCurrent(LinearPositionRequest request) {
        if (!motionMagicConfigsUsing.equals(currentMotionMagicConfigs)) {
            getConfigurator().apply(currentMotionMagicConfigs);
            motionMagicConfigsUsing = currentMotionMagicConfigs;
        }
        motionMagicExpoTorqueCurrentFOC.withPosition(request.getPositionMeters());
        setControl(motionMagicExpoTorqueCurrentFOC);
    }

    @Override
    public void acceptVelocityCurrent(LinearVelocityRequest request) {
        velocityTorqueCurrentFOC.withVelocity(request.getVelocityMetersPerSecond());
        setControl(velocityTorqueCurrentFOC);
    }

    @Override
    public void acceptTrapVelocityCurrent(LinearVelocityRequest request) {
        if (!slot2ConfigsUsing.equals(currentSlot2Configs)) {
            getConfigurator().apply(currentSlot2Configs);
            slot2ConfigsUsing = currentSlot2Configs;
        }
        motionMagicVelocityTorqueCurrentFOC.withVelocity(request.getVelocityMetersPerSecond());
        setControl(motionMagicVelocityTorqueCurrentFOC);
    }


}
