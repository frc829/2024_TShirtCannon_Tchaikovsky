package lib.absoluteEncoders.can.vendors.ctre;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.signals.AbsoluteSensorRangeValue;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

public class CTREAbsoluteEncoderConfiguration {

    private final int deviceNumber;
    private final String canbus;
    private final FeedbackSensorSourceValue feedbackSensorSourceValue;
    private final CANcoderConfiguration cancoderConfiguration = new CANcoderConfiguration();

    public CTREAbsoluteEncoderConfiguration(int deviceNumber) {
        this(deviceNumber, "rio", FeedbackSensorSourceValue.RotorSensor);
    }

    public CTREAbsoluteEncoderConfiguration(int deviceNumber, FeedbackSensorSourceValue feedbackSensorSourceValue) {
        this(deviceNumber,"rio", feedbackSensorSourceValue);
    }

    public CTREAbsoluteEncoderConfiguration(int deviceNumber, String canbus) {
        this(deviceNumber,canbus,FeedbackSensorSourceValue.RotorSensor);
    }

    public CTREAbsoluteEncoderConfiguration(int deviceNumber, String canbus, FeedbackSensorSourceValue feedbackSensorSourceValue) {
        this.deviceNumber = deviceNumber;
        this.canbus = canbus;
        this.feedbackSensorSourceValue = feedbackSensorSourceValue;
    }

    public CANcoderConfiguration getCANcoderConfiguration() {
        return cancoderConfiguration;
    }

    public final CTREAbsoluteEncoderConfiguration withAbsoluteSensorRangeValue(AbsoluteSensorRangeValue absoluteSensorRangeValue) {
        cancoderConfiguration.MagnetSensor.withAbsoluteSensorRange(absoluteSensorRangeValue);
        return this;
    }

    public final CTREAbsoluteEncoderConfiguration withSensorDirectionValue(SensorDirectionValue sensorDirectionValue) {
        cancoderConfiguration.MagnetSensor.withSensorDirection(sensorDirectionValue);
        return this;
    }

    public int getDeviceNumber() {
        return deviceNumber;
    }

    public String getCanbus() {
        return canbus;
    }

    public FeedbackSensorSourceValue getFeedbackSensorSourceValue() {
        return feedbackSensorSourceValue;
    }
}
