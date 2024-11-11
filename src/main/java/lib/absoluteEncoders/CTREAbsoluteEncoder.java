package lib.absoluteEncoders;

import com.ctre.phoenix6.hardware.CANcoder;

public class CTREAbsoluteEncoder extends CANcoder implements AbsoluteEncoder {

    public CTREAbsoluteEncoder(CTREAbsoluteEncoderConfiguration config) {
        super(config.deviceNumber(), config.canbus());
        // TODO: Braden: 01: Start Here: don't forget to import when needed.
        // TODO: create a MagnetSensorConfigs object named magnetSensorConfigs and initialize to its no argument constructor.
        // TODO: call magnetSensorConfigs withAbsoluteSensorRange method and pass in the value from config at line 11.
        // What this is doing is taking the magnetSensorConfigs modifying it with the value you put in and returning it to you.
        // Which means you can use chaining but dont' have to.
        // TODO: call magnetSensorConfigs withSensorDirection method and pass in the value from config.
        // any method using the word with at the beginning behaves this way.  This is called the builder pattern.  You're building up the configs
        // TODO: create a CANcoderConfiguration object named cancoderConfigurations and intialize to the no argument constructor.
        // TODO: call its withMagnetSensor and pass in magnetSensorConfigs.
        // TODO: CTREAbsoluteEncoder (this class) extends CANcoder.  So it has access to its getConfigurator().apply() method.
        //  Call it passing in cancoderConfiguration
    }

    @Override
    public AbsoluteEncoderType getAbsoluteEncoderType() {
        // TODO: return AbsoluteEncodertype.CTRE_CANCODER
        return null;  // TODO: remove this placeholder.
    }

    @Override
    public double getAbsoluteAngleDegrees() {
        // TODO: the cancoder has a getAbsolutePosition which reports the answer in rotations.
        // We have to convert it to degrees.  return Units.rotationsToDegrees and pass in getAbsolutePosition().getValueAsDouble()
        // All CTRE stuff wraps their getters in a type.  We have to extract stuff from that type.
        return 0.0;  // TODO: remove this placeholder.
    }

    @Override
    public double getAbsoluteAngularVelocityDegreesPerSecond() {
        // TODO: same ideas as previous method but for velocity
        return 0.0;  // TODO: remove this placeholder.
    }
}
