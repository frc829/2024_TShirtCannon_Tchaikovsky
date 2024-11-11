package lib.motortypes.swervesteers;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.controls.*;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.util.Units;
import lib.motormechanisms.controlrequests.AngularPositionRequest;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.MotorControllerType;

public class CTRESwerveSteerMotor extends TalonFX implements SwerveSteerMotor {
    private final VoltageOut voltageOut = new VoltageOut(0.0).withEnableFOC(false);
    private final TorqueCurrentFOC torqueCurrentFOC = new TorqueCurrentFOC(0.0);
    private final PositionVoltage positionVoltage = new PositionVoltage(0.0).withSlot(0).withEnableFOC(false);
    private final PositionTorqueCurrentFOC positionTorqueCurrentFOC = new PositionTorqueCurrentFOC(0.0).withSlot(1);
    private final MotionMagicVoltage motionMagicVoltage = new MotionMagicVoltage(0.0).withSlot(0).withEnableFOC(false);
    private final MotionMagicExpoVoltage motionMagicExpoVoltage = new MotionMagicExpoVoltage(0.0).withSlot(0).withEnableFOC(false);
    private final MotionMagicTorqueCurrentFOC motionMagicTorqueCurrentFOC = new MotionMagicTorqueCurrentFOC(0.0).withSlot(1);
    private final MotionMagicExpoTorqueCurrentFOC motionMagicExpoTorqueCurrentFOC = new MotionMagicExpoTorqueCurrentFOC(0.0).withSlot(1);

    private final MotionMagicConfigs voltageMotionMagicConfigs;
    private final MotionMagicConfigs currentMotionMagicConfigs;
    private MotionMagicConfigs motionMagicConfigsUsing;

    protected CTRESwerveSteerMotor(CTRESwerveSteerMotorConfig config, FeedbackConfigs feedbackConfigs) {
        super(config.deviceNumber(), config.canbus());
        MotorOutputConfigs motorOutputConfigs = new MotorOutputConfigs()
                .withNeutralMode(config.neutralModeValue())
                .withInverted(config.invertedValue());
        ClosedLoopGeneralConfigs closedLoopGeneralConfigs = new ClosedLoopGeneralConfigs();
        closedLoopGeneralConfigs.ContinuousWrap = true;
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
                .withClosedLoopGeneral(closedLoopGeneralConfigs)
                .withFeedback(feedbackConfigs)
                .withSlot0(slot0Configs)
                .withSlot1(slot1Configs)
                .withMotionMagic(voltageMotionMagicConfigs);
        getConfigurator().apply(talonFXConfiguration);
        motionMagicConfigsUsing = voltageMotionMagicConfigs;
    }

    public CTRESwerveSteerMotor(CTRESwerveSteerMotorConfig config) {
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
}
