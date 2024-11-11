package lib.absoluteEncoders;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.MagnetSensorConfigs;
import com.ctre.phoenix6.hardware.CANcoder;

import edu.wpi.first.math.util.Units;

public class CTREAbsoluteEncoder extends CANcoder implements AbsoluteEncoder {

    public CTREAbsoluteEncoder(CTREAbsoluteEncoderConfiguration config) {
        super(config.deviceNumber(), config.canbus());
        final MagnetSensorConfigs magnetSensorConfigs = new MagnetSensorConfigs();

        magnetSensorConfigs.withAbsoluteSensorRange(config.absoluteSensorRangeValue());
        magnetSensorConfigs.withSensorDirection(config.sensorDirectionValue());

        CANcoderConfiguration canCoderConfiguration = new CANcoderConfiguration();
        canCoderConfiguration.withMagnetSensor(magnetSensorConfigs);
    }

    @Override
    public AbsoluteEncoderType getAbsoluteEncoderType() {
        return AbsoluteEncoderType.CTRE_CANCODER;
    }

    @Override
    public double getAbsoluteAngleDegrees() {
        return Units.rotationsToDegrees(getAbsolutePosition().getValueAsDouble());
    }

    @Override
    public double getAbsoluteAngularVelocityDegreesPerSecond() {
        return Units.rotationsToDegrees(getVelocity().getValueAsDouble());
    }
}
