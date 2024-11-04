package lib.motors.can.smart.vendors.ctre;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public abstract class CTRESmartMotorConfiguration {

    // TODO: Jacob: 06: create an int named deviceNumber, make it private, and make it final
    // TODO: Jacob: 07: create a String named canbus, make it private, make it final
    // TODO: Jacob: 08: create a TalonFXConfiguration named talonFXConfiguration, intialize it to a new TalonFXConfiguration()
    // make if protected and final
    // TODO: Jacob: 09: create a MotorOutConfigs named motorOutputConfigs, intialize it to a new MotorOutputConfigs().
    // make it private and final
    // TODO: Jacob: 10: create a FeedbackConfigs named feedbackConfigs, intialize it to a new FeedbackConfigs().
    // make it protected and final.


    public CTRESmartMotorConfiguration(int deviceNumber) {
        // TODO: Jacob: 11: set this deviceNumber to the deviceNumber argument
        // TODO: Jacob: 12: set this canbus to "rio"
    }

    public CTRESmartMotorConfiguration(int deviceNumber, String canbus) {
        // TODO: Jacob: 13: set this deviceNumber to the deviceNumber argument
        // TODO: Jacob: 14: set this canbus to the canbus argument
    }

    public int getDeviceNumber() {
        // TODO: Jacob: 15: simply return deviceNumber
        return 0; // TODO: remove this placeholder.
    }

    public String getCanbus() {
        // TODO: Jacob: 16: simply return canbus;
        return null; // TODO: remove this placeholder.
    }

    public final TalonFXConfiguration getTalonFXConfiguration() {
        // TODO: Jacob: 17: simply return talonFXConfiguration;
        return null; // TODO: remove this placeholder.
    }

    public final CTRESmartMotorConfiguration withNeutralModeValue(NeutralModeValue neutralModeValue) {
        // TODO: Jacob: 18: call motorOutputConfig's withNeutralMode method and pass in neutralModeValue.
        // TODO: Jacob: 19: call talonFXConfiguration's withMotorOutput method and pass in motorOutputConfigs
        // TODO: Jacob: 20: return this
        return null; // TODO: remove this placeholder.
    }

    public final CTRESmartMotorConfiguration withInvertedValue(InvertedValue invertedValue) {
        // TODO: Jacob: 21: call motorOutputConfig's withInvertedValue method and pass in invertedValue.
        // TODO: Jacob: 22: call talonFXConfiguration's withMotorOutput method and pass in motorOutputConfigs
        // TODO: Jacob: 23: return this
        return null; // TODO: remove this placeholder.
    }

    public final CTRESmartMotorConfiguration withRotorToSensorRatio(double rotorToSensorRatio) {
        // TODO: Jacob: 24: call feedbackConfigs's withRotorToSensorRatio  method and pass in rotorToSensorRatio.
        // TODO: Jacob: 25: call talonFXConfiguration's withFeedback method and pass in feedbackConfigs
        // TODO: Jacob: 26: return this
        return null; // TODO: remove this placeholder.
    }

    public final CTRESmartMotorConfiguration withSensorToMechanismRatio(double sensorToMechanismRatio) {
        // TODO: Jacob: 27: call feedbackConfigs's withSensorToMechanismRatio method and pass in sensorToMechanismRatio.
        // TODO: Jacob: 28: call talonFXConfiguration's withFeedback method and pass in feedbackConfigs
        // TODO: Jacob: 29: return this
        return null; // TODO: remove this placeholder.
    }
}
