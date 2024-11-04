package lib.motors.can.followers.vendors.ctre;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.NeutralModeValue;

public final class CTREFollowerMotorConfiguration {

    // TODO: Braden: 00: there might be red, this file depends on CTRESmartMotorConfiguration, which may not be done.
    // TODO: Braden: 01: create a int named deviceNumber
    // TODO: Braden: 02: create a String named canbus
    // TODO: Braden: 03: create an int named leaderMotorCanId
    // TODO: Braden: 04: create a String named leaderMotorCanNetwork
    // TODO: Braden: 05: create a boolean named inverted.
    // TODO: Braden: 06: create a TalonFXConfiguration named talonFXConfiguration and initialize to new TalonFXConfiguration()
    // TODO: Braden: 07: create a MotorOutputConfigs named motorOutputConfigs and initialize to new MotorOutputConfigs()
    // TODO: Braden: 08: create a FeedbackConfigs named feedbackConfiguration and initialize to new FeedbackConfigs()

    public CTREFollowerMotorConfiguration(int deviceNumber, int leaderMotorCanId, String leaderMotorCanNetwork, boolean inverted) {
        // TODO: Braden: 09: call this() passing in all of the parameters and "rio" for the canbus
        this(
                0,
                null,
                0,
                null,
                false
        ); // TODO: remove this placeholder.
    }

    public CTREFollowerMotorConfiguration(int deviceNumber, String canbus, int leaderMotorCanId, String leaderMotorCanNetwork, boolean inverted) {
        // TODO: Braden: 10: initialize the fields to the arguments.
    }

    public int getDeviceNumber() {
        // TODO: Braden: 11: return deviceNumber
        return 0; // TODO: remove this placeholder.
    }

    public String getCanbus() {
        // TODO: Braden: 12: return canbus
        return null; // TODO: remove this placeholder.
    }

    public int getLeaderMotorCanId() {
        // TODO: Braden: 13: return leaderMotorCanId
        return 0; // TODO: remove this placeholder.
    }

    public String getLeaderMotorCanNetwork() {
        // TODO: Braden: 14: return leaderMotorCanNetwork
        return null; // TODO: remove this placeholder.
    }

    public boolean isInverted() {
        // TODO: Braden: 15: return isInverted
        return false; // TODO: remove this placeholder.
    }

    public final TalonFXConfiguration getTalonFXConfiguration() {
        // TODO: Braden: 16: call talonFXConfiguration's withMotorOutput method and pass in motorOutputConfiguration
        // TODO: Braden: 17: call talonFXConfiguration's withFeedback method and pass in feedbackConfiguration.
        // TODO: Braden: 18: return talonFXConfiguration
        return null; // TODO: remove this placeholder.
    }

    public final CTREFollowerMotorConfiguration withNeutralModeValue(NeutralModeValue neutralModeValue) {
        // TODO: Braden: 19: call motorOutputConfiguration's withNeutralMode and pass in the argument
        // TODO: Braden: 20: return this;
        return null; // TODO: remove this placeholder.
    }

    public final CTREFollowerMotorConfiguration withRotorToSensorRatio(double rotorToSensorRatio) {
        // TODO: Braden: 21: call feedbackConfiguration's withRotorToSensorRatio and pass in the argument
        // TODO: Braden: 22: return this;
        return null; // TODO: remove this placeholder.

    }

    public final CTREFollowerMotorConfiguration withSensorToMechanismRatio(double sensorToMechanismRatio) {
        // TODO: Braden: 23: call feedbackConfiguration's withSensorToMechanismRatio method and pass in the argument.
        // TODO: Braden: 24: return this;
        return null; // TODO: remove this placeholder.
    }


}
