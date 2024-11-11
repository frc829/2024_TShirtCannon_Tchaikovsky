package lib.motortypes.swervesteers;

import lib.absoluteEncoders.AbsoluteEncoder;

public interface AbsoluteEncoderSwerveSteerMotor extends SwerveSteerMotor {

    public AbsoluteEncoder getAbsoluteEncoder();
}
