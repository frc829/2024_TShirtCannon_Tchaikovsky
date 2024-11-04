package lib.absoluteEncoders.can.vendors.ctre;

import lib.absoluteEncoders.AbsoluteEncoder;

public class CTREAbsoluteEncoder implements AbsoluteEncoder {

    // TODO: Braden: 63: create a CANcoder named cancoder

    public CTREAbsoluteEncoder(CTREAbsoluteEncoderConfiguration encoderConfig) {
        // TODO: Braden: 64: initialize this cancoder using new CANcoder and the values in the config for deviceNumber and canbus
        // TODO: Braden: 65: call cancoder.getConfigurator().apply() and pass in encoderConfig's getCANcoderConfiguration()
    }

    @Override
    public double getAbsoluteAngleDegrees() {
        // TODO: Braden: 66: return Units.rotationsToDegrees() passing in cancoder.getAbsolutePosition().getValueAsDouble()
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public double getAbsoluteAngularVelocityDegreesPerSecond() {
        // TODO: Braden: 67: return Units.rotationsToDegrees() passing in cancoder.getAbsoluteVelocity().getValueAsDouble()
        return 0.0; // TODO: remove this placeholder.
    }
}
