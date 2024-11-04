package lib.motors.can.smart.vendors.ctre.position;

import lib.absoluteEncoders.can.vendors.ctre.CTREAbsoluteEncoderConfiguration;

public class CTREAngularPositionSmartMotorConfiguration extends CTREPositionSmartMotorConfiguration {

    // TODO: Allen: 40: create a CTREAbsoluteEncoderConfiguration called encoderConfiguration

    public CTREAngularPositionSmartMotorConfiguration(int deviceNumber, CTREAbsoluteEncoderConfiguration encoderConfiguration) {
        // TODO: Allen: 41: call this(deviceNumber, "rio", encoderConfiguration);
        this(0, null, null); // TODO: remove this placeholder.

    }

    public CTREAngularPositionSmartMotorConfiguration(int deviceNumber, String canbus, CTREAbsoluteEncoderConfiguration encoderConfiguration) {
        // TODO: Allen: 42: call super(deviceNumber, canbus)
        super(0, null); // TODO: remove this placeholder.
        // TODO: Allen: 43: set this encoderConfiguration to the pass in argument.
        // TODO: Allen: 44: call feedbackConfiguration's withFeedbackRemoteSensorID method passing in encoderConfiguration.getDeviceNumber()
        // TODO: Allen: 45: call feedbackConfiguration's witheedbackSensorSource method passing in encoderConfiguration.getFeedbackSourceValue()
        // TODO: Allen: 46: call talonFXConfiguration's withFeedback method passing in feedbackConfiguration
        // TODO: Allen: 47: call motor.getConfigurator().apply() passing in feedbackConfiguration
    }


    public CTREAbsoluteEncoderConfiguration getEncoderConfiguration() {
        // TODO: Allen: 48: simply return encoderConfiguration
        return null; // TODO: remove this placeholder.
    }
}
