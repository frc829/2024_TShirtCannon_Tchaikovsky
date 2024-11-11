package lib.motortypes.arms;

import com.ctre.phoenix6.configs.FeedbackConfigs;
import lib.absoluteEncoders.AbsoluteEncoder;
import lib.absoluteEncoders.CTREAbsoluteEncoder;

public class CTREAbsoluteEncoderArmMotor extends CTREArmMotor implements AbsoluteEncoderArmMotor {
    private final AbsoluteEncoder ctreAbsoluteEncoder;

    public CTREAbsoluteEncoderArmMotor(CTREAbsoluteEncoderArmMotorConfig config) {
        super(config.ctreArmMotorConfig(),
                new FeedbackConfigs().withRotorToSensorRatio(config.ctreArmMotorConfig().rotorToSensorRatio())
                        .withSensorToMechanismRatio(config.ctreArmMotorConfig().sensorToMechanismRatio())
                        .withFeedbackRemoteSensorID(config.ctreAbsoluteEncoderConfiguration().deviceNumber())
                        .withFeedbackSensorSource(config.ctreAbsoluteEncoderConfiguration().feedbackSensorSourceValue()));
        ctreAbsoluteEncoder = new CTREAbsoluteEncoder(config.ctreAbsoluteEncoderConfiguration());
    }

    @Override
    public AbsoluteEncoder getAbsoluteEncoder() {
        return ctreAbsoluteEncoder;
    }
}
