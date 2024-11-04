package lib.motors.can.smart.vendors.ctre.complete;

import lib.absoluteEncoders.AbsoluteEncoder;
import lib.motors.can.smart.usages.complete.CompleteAngularSmartMotor;

public class CTRECompleteAngularSmartMotor extends CTRECompleteSmartMotor implements CompleteAngularSmartMotor {

    // TODO: Braden: 42: create a CTREAbsoluteEncoder named ctreAbsoluteEncoder

    public CTRECompleteAngularSmartMotor(CTRECompleteAngularSmartMotorConfiguration config) {
        // TODO: Braden: 43: call super(config)
        super(null); // TODO: remove this placeholder
        // TODO: Braden: 44: initialize this ctreAbsoluteEncoder to a new CTREAbsoluteEncoder passing in the config stored in config
    }

    @Override
    public AbsoluteEncoder getAbsoluteEncoder() {
        // TODO: Braden: 45: return ctreAbsoluteEncoder
        return null; // TODO: remove this placeholder.
    }

    @Override
    public void setMotorEncoderFromAbsolute() {
        // TODO: Braden: 46: call motor.setPosition() passing in ctreAbsoluteEncoder's getAbsoluteAngleDegrees method.
    }
}
