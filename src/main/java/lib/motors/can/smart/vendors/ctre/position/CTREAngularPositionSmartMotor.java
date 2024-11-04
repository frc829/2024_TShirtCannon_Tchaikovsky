package lib.motors.can.smart.vendors.ctre.position;

import lib.motors.can.smart.usages.position.AngularPositionSmartMotor;
import lib.absoluteEncoders.AbsoluteEncoder;

public class CTREAngularPositionSmartMotor extends CTREPositionSmartMotor implements AngularPositionSmartMotor {

    // TODO: Allen: 49: create a CTREAbsoluteEncoder object named ctreAbsoluteEncoder

    public CTREAngularPositionSmartMotor(CTREAngularPositionSmartMotorConfiguration config) {
        // TODO: Allen: 50: call super(config)
        super(null); // TODO: remove this placeholder.
        // TODO: Allen: 51: set this ctreAbsoluteEncoder to new CTREAbsoluteEncoder(config.getEncoderConfiguration())
    }

    @Override
    public AbsoluteEncoder getAbsoluteEncoder() {
        // TODO: Allen: 52: return ctreAbsoluteEncoder
        return null; // TODO: remove this placeholder.
    }

    @Override
    public void setMotorEncoderFromAbsolute() {
        // TODO: Allen: 53: call motor.setPosition(ctreAbsoluteEncoder.getAbsoluteAngleDegrees())
    }
}
