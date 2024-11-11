package lib.motortypes.arms;

import lib.absoluteEncoders.AbsoluteEncoder;

public class REV_MAXAbsoluteEncoderArmMotor extends REV_MAXArmMotor implements AbsoluteEncoderArmMotor {

    // TODO: Keith continue here.  this is for the absolute Encoder on an arm.  Last years it was the REV through bore.  That thing
    // that broke at worlds.

    // TODO: create an AbsoluteEncoder named revAbsoluteEncoder. private final.

    public REV_MAXAbsoluteEncoderArmMotor(REV_MAXArmMotorConfig config) {
        super(config);
        // TODO: initialize revAbsoluteEncoder to a new REVAbsoluteEncoder passing in getAbsoluteEncoder(SparkAbsoluteEncoder.Type.kDutyCycle)
    }

    public AbsoluteEncoder getInternalAbsoluteEncoder() {
        // TODO: return revAbsoluteEncoder;
        return null; // TODO: remove this placeholder.
    }

}
