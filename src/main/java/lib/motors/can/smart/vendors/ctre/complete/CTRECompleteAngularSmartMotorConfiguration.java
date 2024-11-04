package lib.motors.can.smart.vendors.ctre.complete;

import com.ctre.phoenix6.signals.GravityTypeValue;
import lib.absoluteEncoders.can.vendors.ctre.CTREAbsoluteEncoderConfiguration;

public class CTRECompleteAngularSmartMotorConfiguration extends CTRECompleteSmartMotorConfiguration {

    // TODO: Robbie: 00: there might be red, this file depends on CTRESmartMotorConfiguration, which may not be done.
    // TODO: Robbie: 01: create a CTREAbsoluteEncoderConfiguration named encoderConfiguration

    public CTRECompleteAngularSmartMotorConfiguration(int deviceNumber, GravityTypeValue gravityType, CTREAbsoluteEncoderConfiguration encoderConfiguration) {
        // TODO: Robbie: 02: call this(deviceNumber, "rio", gravityType, encoderConfiguration)
        this(0, null, null, null);
    }

    public CTRECompleteAngularSmartMotorConfiguration(
            int deviceNumber,
            String canbus,
            GravityTypeValue gravityType,
            CTREAbsoluteEncoderConfiguration encoderConfiguration) {
        // TODO: Robbie: 03: call super(deviceNumber, canbus, gravityType)
        super(0, null, null); // TODO: remove this placeholder.
        // TODO: Robbie: 04: set this encoderConfiguration to the one passed in.
        // TODO: Robbie: 05: call feedbackConfiguration's withFeedbackRemoteSensorId and pass in deviceNumber from encoderConfig
        // TODO: Robbie: 06: call feedbackConfiguration's withFeedbackSensorSource and pass in feedbackSensorSourceValue from encoderConfig
        // TODO: Robbie: 07: call talonFXConfiguration's withFeedback method and pass in feedbackConfiguration.
    }


    public CTREAbsoluteEncoderConfiguration getEncoderConfiguration() {
        // TODO: Robbie: 08: return encoderConfiguration
        return null; // TODO: remove this placeholder.
    }
}
