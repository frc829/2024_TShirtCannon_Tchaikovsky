package lib.motortypes.arms;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.controls.*;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;
import edu.wpi.first.math.util.Units;
import lib.motormechanisms.controlrequests.AngularPositionRequest;
import lib.motormechanisms.controlrequests.AngularVelocityRequest;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.MotorControllerType;

public class CTREArmMotor extends TalonFX implements ArmMotor {
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

    protected CTREArmMotor(CTREArmMotorConfig config, FeedbackConfigs feedbackConfigs) {
        super(config.deviceNumber(), config.canbus());
        MotorOutputConfigs motorOutputConfigs = new MotorOutputConfigs()
                .withNeutralMode(config.neutralModeValue())
                .withInverted(config.invertedValue());
        Slot0Configs slot0Configs = new Slot0Configs()
                .withKS(config.voltageKs())
                .withKV(config.voltageKv())
                .withKA(config.voltageKa())
                .withKG(config.voltageKg())
                .withKP(config.voltagePositionKp())
                .withKI(config.voltagePositionKi())
                .withKD(config.voltagePositionKd())
                .withGravityType(GravityTypeValue.Arm_Cosine);
        Slot1Configs slot1Configs = new Slot1Configs()
                .withKS(config.currentKs())
                .withKV(config.currentKv())
                .withKA(config.currentKa())
                .withKG(config.currentKg())
                .withKP(config.currentPositionKp())
                .withKI(config.currentPositionKi())
                .withKD(config.currentPositionKd())
                .withGravityType(GravityTypeValue.Arm_Cosine);
        voltageSlot2Configs = new Slot2Configs()
                .withKS(config.voltageKs())
                .withKV(config.voltageKv())
                .withKA(config.voltageKa())
                .withKG(config.voltageKg())
                .withKP(config.voltageVelocityKp())
                .withKI(config.voltageVelocityKi())
                .withKD(config.voltageVelocityKd())
                .withGravityType(GravityTypeValue.Arm_Cosine);
        currentSlot2Configs = new Slot2Configs()
                .withKS(config.currentKs())
                .withKV(config.currentKv())
                .withKA(config.currentKa())
                .withKG(config.currentKg())
                .withKP(config.currentVelocityKp())
                .withKI(config.currentVelocityKi())
                .withKD(config.currentVelocityKd())
                .withGravityType(GravityTypeValue.Arm_Cosine);
        voltageMotionMagicConfigs = new MotionMagicConfigs()
                .withMotionMagicCruiseVelocity(config.maxVelocityRadPerSec())
                .withMotionMagicAcceleration(config.maxAccelerationRadPerSecSquared())
                .withMotionMagicJerk(config.maxJerkRadPerSecCubed())
                .withMotionMagicExpo_kV(config.voltageKv())
                .withMotionMagicExpo_kA(config.voltageKa());
        currentMotionMagicConfigs = new MotionMagicConfigs()
                .withMotionMagicCruiseVelocity(config.maxVelocityRadPerSec())
                .withMotionMagicAcceleration(config.maxAccelerationRadPerSecSquared())
                .withMotionMagicJerk(config.maxJerkRadPerSecCubed())
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

    public CTREArmMotor(CTREArmMotorConfig config) {
        this(
                config,
                new FeedbackConfigs()
                        .withRotorToSensorRatio(config.rotorToSensorRatio())
                        .withSensorToMechanismRatio(config.sensorToMechanismRatio()));
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
    public double getAngleDegrees() {
        return Units.radiansToDegrees(getPosition().getValueAsDouble());
    }

    @Override
    public void setAngleDegrees(double angleDegrees) {
        setPosition(Units.radiansToDegrees(angleDegrees));
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
    public void acceptPositionVoltage(AngularPositionRequest request) {
        positionVoltage.withPosition(Units.degreesToRadians(request.getAngleDegrees()));
        setControl(positionVoltage);
    }

    @Override
    public void acceptTrapPositionVoltage(AngularPositionRequest request) {
        motionMagicVoltage.withPosition(Units.degreesToRadians(request.getAngleDegrees()));
        setControl(motionMagicVoltage);
    }

    @Override
    public void acceptExpoPositionVoltage(AngularPositionRequest request) {
        if (!motionMagicConfigsUsing.equals(voltageMotionMagicConfigs)) {
            getConfigurator().apply(voltageMotionMagicConfigs);
            motionMagicConfigsUsing = voltageMotionMagicConfigs;
        }
        motionMagicExpoVoltage.withPosition(Units.degreesToRadians(request.getAngleDegrees()));
        setControl(motionMagicExpoVoltage);
    }

    @Override
    public void acceptVelocityVoltage(AngularVelocityRequest request) {
        velocityVoltage.withVelocity(Units.degreesToRadians(request.getAngularVelocityDegreesPerSecond()));
        setControl(velocityVoltage);
    }


    @Override
    public void acceptTrapVelocityVoltage(AngularVelocityRequest request) {
        if (!slot2ConfigsUsing.equals(voltageSlot2Configs)) {
            getConfigurator().apply(voltageSlot2Configs);
            slot2ConfigsUsing = voltageSlot2Configs;
        }
        motionMagicVelocityVoltage.withVelocity(Units.degreesToRadians(request.getAngularVelocityDegreesPerSecond()));
        setControl(motionMagicVelocityVoltage);
    }

    @Override
    public void acceptPositionCurrent(AngularPositionRequest request) {
        positionTorqueCurrentFOC.withPosition(Units.degreesToRadians(request.getAngleDegrees()));
        setControl(positionTorqueCurrentFOC);
    }

    @Override
    public void acceptTrapPositionCurrent(AngularPositionRequest request) {
        motionMagicTorqueCurrentFOC.withPosition(Units.degreesToRadians(request.getAngleDegrees()));
        setControl(motionMagicTorqueCurrentFOC);
    }


    @Override
    public void acceptExpoPositionCurrent(AngularPositionRequest request) {
        if (!motionMagicConfigsUsing.equals(currentMotionMagicConfigs)) {
            getConfigurator().apply(currentMotionMagicConfigs);
            motionMagicConfigsUsing = currentMotionMagicConfigs;
        }
        motionMagicExpoTorqueCurrentFOC.withPosition(Units.degreesToRadians(request.getAngleDegrees()));
        setControl(motionMagicExpoTorqueCurrentFOC);
    }

    @Override
    public void acceptVelocityCurrent(AngularVelocityRequest request) {
        if (!slot2ConfigsUsing.equals(currentSlot2Configs)) {
            getConfigurator().apply(currentSlot2Configs);
            slot2ConfigsUsing = currentSlot2Configs;
        }
        motionMagicVelocityTorqueCurrentFOC.withVelocity(Units.degreesToRadians(request.getAngularVelocityDegreesPerSecond()));
        setControl(motionMagicVelocityTorqueCurrentFOC);
    }

    @Override
    public void acceptTrapVelocityCurrent(AngularVelocityRequest request) {
        velocityTorqueCurrentFOC.withVelocity(Units.degreesToRadians(request.getAngularVelocityDegreesPerSecond()));
        setControl(velocityTorqueCurrentFOC);
    }
}
