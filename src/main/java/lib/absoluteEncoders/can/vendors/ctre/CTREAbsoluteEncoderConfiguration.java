package lib.absoluteEncoders.can.vendors.ctre;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.signals.AbsoluteSensorRangeValue;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

public class CTREAbsoluteEncoderConfiguration {

    // TODO: Braden: 47: create an int named deviceNumber
    // TODO: Braden: 48: create a String named canbus
    // TODO: Braden: 49: create a FeedbackSensorSourceValue named feedbackSensorSourceValue
    // TODO: Braden: 50: create a CANcoderConfiguration named cancoderConfiguration and initialize to a new one.

    public CTREAbsoluteEncoderConfiguration(int deviceNumber) {
        // TODO: Braden: 51: call this(deviceNumber, "rio", FeedbackSensorSourceValue.RotorSensor)
        this(0, null, null); // TODO: remove this placeholder.
    }

    public CTREAbsoluteEncoderConfiguration(int deviceNumber, FeedbackSensorSourceValue feedbackSensorSourceValue) {
        // TODO: Braden: 52: call this(deviceNumber, "rio", feedbackSensorSourceValue)
        this(0, null, null); // TODO: remove this placeholder.
    }

    public CTREAbsoluteEncoderConfiguration(int deviceNumber, String canbus) {
        // TODO: Braden: 53: call this(deviceNumber, canbus, FeedbackSensorSourceValue.RotorSensor))
        this(0, null, null); // TODO: remove this placeholder.
    }

    public CTREAbsoluteEncoderConfiguration(int deviceNumber, String canbus, FeedbackSensorSourceValue feedbackSensorSourceValue) {
        // TODO: Braden: 54: initialize the fields to the passed in arguments.
    }

    public CANcoderConfiguration getCANcoderConfiguration() {
        // TODO: Braden: 55: return cancoderConfiguration
        return null; // TODO: remove this placeholder.
    }

    public final CTREAbsoluteEncoderConfiguration withAbsoluteSensorRangeValue(AbsoluteSensorRangeValue absoluteSensorRangeValue) {
        // TODO: Braden: 56: call cancoderConfiguration.MagnetSensor's withAbsoluteSensorRange method passing in the argument
        // TODO: Braden: 57: return this
        return null; // TODO: remove this placeholder.
    }

    public final CTREAbsoluteEncoderConfiguration withSensorDirectionValue(SensorDirectionValue sensorDirectionValue) {
        // TODO: Braden: 58: call cancoderConfiguration.MagnetSensor's withSensorDirection method passing in the argument.
        // TODO: Braden: 59: return this
        return null; // TODO: remove this placeholder.
    }

    public int getDeviceNumber() {
        // TODO: Braden: 60: return deviceNumber
        return 0; // TODO: remove this placeholder.
    }

    public String getCanbus() {
        // TODO: Braden: 61: return canbus
        return null; // TODO: remove this placeholder.
    }

    public FeedbackSensorSourceValue getFeedbackSensorSourceValue() {
        // TODO: Braden: 62: return feedbackSensorSourceValue
        return null; // TODO: remove this placeholder.
    }
}
