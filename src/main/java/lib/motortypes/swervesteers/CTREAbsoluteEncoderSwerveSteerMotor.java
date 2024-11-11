package lib.motortypes.swervesteers;

import com.ctre.phoenix6.configs.FeedbackConfigs;
import lib.absoluteEncoders.AbsoluteEncoder;
import lib.absoluteEncoders.CTREAbsoluteEncoder;

public class CTREAbsoluteEncoderSwerveSteerMotor extends CTRESwerveSteerMotor implements AbsoluteEncoderSwerveSteerMotor {
    private final AbsoluteEncoder ctreAbsoluteEncoder;

    public CTREAbsoluteEncoderSwerveSteerMotor(CTREAbsoluteEncoderSwerveSteerMotorConfig config) {
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
