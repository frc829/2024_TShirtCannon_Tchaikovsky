package lib.motors.can.smart;

import lib.absoluteEncoders.AbsoluteEncoder;

public interface HasAbsolute {

    public AbsoluteEncoder getAbsoluteEncoder();

    public void setMotorEncoderFromAbsolute();


}
