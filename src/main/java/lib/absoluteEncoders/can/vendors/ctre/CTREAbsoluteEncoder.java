package lib.absoluteEncoders.can.vendors.ctre;

import com.ctre.phoenix6.hardware.CANcoder;

import edu.wpi.first.wpilibj.Encoder;
import lib.absoluteEncoders.AbsoluteEncoder;
import lib.motors.can.smart.vendors.ctre.complete.CTRECompleteAngularSmartMotorConfiguration;

public class CTREAbsoluteEncoder implements AbsoluteEncoder {

    private final CANcoder cancoder;

    public CTREAbsoluteEncoder(CTRECompleteAngularSmartMotorConfiguration config) {

        this.cancoder = new CANcoder(config.getDeviceNumber(), config.getCanbus());
        cancoder.getConfigurator().apply(encoderConfig.getCANcoderConfiguration());
        
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
