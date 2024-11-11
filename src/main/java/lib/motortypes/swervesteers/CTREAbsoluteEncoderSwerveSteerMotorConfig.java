package lib.motortypes.swervesteers;

import lib.absoluteEncoders.CTREAbsoluteEncoderConfiguration;

public record CTREAbsoluteEncoderSwerveSteerMotorConfig(
        CTRESwerveSteerMotorConfig ctreArmMotorConfig,
        CTREAbsoluteEncoderConfiguration ctreAbsoluteEncoderConfiguration) {
}
