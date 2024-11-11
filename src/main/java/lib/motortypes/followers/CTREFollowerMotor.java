package lib.motortypes.followers;

import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import lib.motortypes.MotorControllerType;

public class CTREFollowerMotor extends TalonFX implements FollowerMotor {

    private final int leaderMotorDeviceNumber;
    private final String leaderMotorCanbus;
    private final boolean isInvertedFromLeader;

    public CTREFollowerMotor(CTREFollowerMotorConfiguration config) {
        super(config.deviceNumber(), config.canbus());
        this.leaderMotorDeviceNumber = config.leaderMotorDeviceNumber();
        this.leaderMotorCanbus = config.leaderMotorCanbus();
        this.isInvertedFromLeader = config.isInvertedFromLeader();
        MotorOutputConfigs motorOutputConfigs = new MotorOutputConfigs()
                .withNeutralMode(config.neutralModeValue());
        FeedbackConfigs feedbackConfigs = new FeedbackConfigs()
                .withRotorToSensorRatio(config.rotorToSensorRatio())
                .withSensorToMechanismRatio(config.sensorToMechanismRatio());
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration()
                .withMotorOutput(motorOutputConfigs)
                .withFeedback(feedbackConfigs);
        getConfigurator().apply(talonFXConfiguration);
        setControl(new Follower(leaderMotorDeviceNumber, isInvertedFromLeader));
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
    public double getMechanismPosition() {
        return super.getPosition().getValueAsDouble();
    }

    @Override
    public void setMechanismPosition(double position) {
        setPosition(position);
    }

    @Override
    public double getMechanismVelocity() {
        return getVelocity().getValueAsDouble();
    }

    @Override
    public boolean isInvertedFromLeader() {
        return isInvertedFromLeader;
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
    public MotorControllerType getMotorControllerType() {
        return MotorControllerType.CTRE_TALON_FX;
    }

    @Override
    public int getLeaderMotorId() {
        return leaderMotorDeviceNumber;
    }

    @Override
    public String getLeaderMotorNetworkName() {
        return leaderMotorCanbus;
    }
}
