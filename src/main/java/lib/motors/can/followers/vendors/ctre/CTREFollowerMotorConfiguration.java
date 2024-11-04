package lib.motors.can.followers.vendors.ctre;

import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.NeutralModeValue;

public final class CTREFollowerMotorConfiguration {

    private final int deviceNumber;
    private final String canbus;
    private final int leaderMotorCanId;
    private final String leaderMotorCanNetwork;
    private final boolean inverted;
    private final TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration();
    private final MotorOutputConfigs motorOutputConfigs = new MotorOutputConfigs();
    private final FeedbackConfigs feedbackConfiguration = new FeedbackConfigs();

    public CTREFollowerMotorConfiguration(int deviceNumber, int leaderMotorCanId, String leaderMotorCanNetwork, boolean inverted) {
        this(

                deviceNumber,
                "rio",
                leaderMotorCanId,
                leaderMotorCanNetwork,
                inverted
        );
    }

    public CTREFollowerMotorConfiguration(int deviceNumber, String canbus, int leaderMotorCanId, String leaderMotorCanNetwork, boolean inverted) {
        this.deviceNumber = deviceNumber;
        this.canbus = canbus;
        this.leaderMotorCanId = leaderMotorCanId;
        this.leaderMotorCanNetwork = leaderMotorCanNetwork;
        this.inverted = inverted;
    }

    public int getDeviceNumber() {
        return deviceNumber;
    }

    public String getCanbus() {
        return canbus;
    }

    public int getLeaderMotorCanId() {
        return leaderMotorCanId; 
    }

    public String getLeaderMotorCanNetwork() {
        return leaderMotorCanNetwork;
    }

    public boolean isInverted() {
        return inverted;
    }

    public final TalonFXConfiguration getTalonFXConfiguration() {
        talonFXConfiguration.withMotorOutput(motorOutputConfigs);
        talonFXConfiguration.withFeedback(feedbackConfiguration);
        return talonFXConfiguration;
    }

    public final CTREFollowerMotorConfiguration withNeutralModeValue(NeutralModeValue neutralModeValue) {
        motorOutputConfigs.withNeutralMode(neutralModeValue);
        return this;
    }

    public final CTREFollowerMotorConfiguration withRotorToSensorRatio(double rotorToSensorRatio) {
        feedbackConfiguration.withRotorToSensorRatio(rotorToSensorRatio);
        return this;
    }

    public final CTREFollowerMotorConfiguration withSensorToMechanismRatio(double sensorToMechanismRatio) {
        feedbackConfiguration.withSensorToMechanismRatio(sensorToMechanismRatio);
        return this;
    }


}
