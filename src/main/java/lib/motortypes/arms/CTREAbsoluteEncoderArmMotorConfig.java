package lib.motortypes.arms;

import lib.absoluteEncoders.CTREAbsoluteEncoderConfiguration;

public record CTREAbsoluteEncoderArmMotorConfig(
        CTREArmMotorConfig ctreArmMotorConfig,
        CTREAbsoluteEncoderConfiguration ctreAbsoluteEncoderConfiguration) {
}
