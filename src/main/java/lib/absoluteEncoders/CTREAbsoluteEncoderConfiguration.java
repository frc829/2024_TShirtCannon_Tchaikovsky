package lib.absoluteEncoders;

import com.ctre.phoenix6.signals.AbsoluteSensorRangeValue;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

public record CTREAbsoluteEncoderConfiguration(
        int deviceNumber,
        String canbus,
        FeedbackSensorSourceValue feedbackSensorSourceValue,
        AbsoluteSensorRangeValue absoluteSensorRangeValue,
        SensorDirectionValue sensorDirectionValue
) {
}
