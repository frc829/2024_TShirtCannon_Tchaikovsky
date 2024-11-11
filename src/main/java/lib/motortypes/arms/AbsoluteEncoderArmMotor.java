package lib.motortypes.arms;

import lib.absoluteEncoders.AbsoluteEncoder;

public interface AbsoluteEncoderArmMotor extends ArmMotor {

    public AbsoluteEncoder getAbsoluteEncoder();
}
