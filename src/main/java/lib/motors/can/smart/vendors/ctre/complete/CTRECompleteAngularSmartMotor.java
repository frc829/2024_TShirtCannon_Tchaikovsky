package lib.motors.can.smart.vendors.ctre.complete;

import lib.absoluteEncoders.AbsoluteEncoder;
import lib.absoluteEncoders.can.vendors.ctre.CTREAbsoluteEncoder;
import lib.motors.can.smart.usages.complete.CompleteAngularSmartMotor;

public class CTRECompleteAngularSmartMotor extends CTRECompleteSmartMotor implements CompleteAngularSmartMotor {
    private final CTREAbsoluteEncoder ctreAbsoluteEncoder;

    public CTRECompleteAngularSmartMotor(CTRECompleteAngularSmartMotorConfiguration config) {
        super(config);

        this.ctreAbsoluteEncoder = new CTREAbsoluteEncoder(config);
    }

    @Override
    public AbsoluteEncoder getAbsoluteEncoder(){
        return ctreAbsoluteEncoder;
    }

    @Override
    public void setMotorEncoderFromAbsolute() {
        motor.setPosition(ctreAbsoluteEncoder.getAbsoluteAngleDegrees());
    }
}
