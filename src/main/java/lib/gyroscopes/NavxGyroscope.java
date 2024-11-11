package lib.gyroscopes;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.SPI;

public class NavxGyroscope extends AHRS implements Gyroscope {

    private final Rotation3d orientation;

    public NavxGyroscope(NavxGyroscopeConfiguration config) {
        super(SPI.Port.kMXP);
        orientation = new Rotation3d(
                Units.degreesToRadians(config.mountPoseRollDegrees()),
                Units.degreesToRadians(config.mountPosePitchDegrees()),
                Units.degreesToRadians(config.mountPoseYawDegrees()));
    }

    @Override
    public GyroscopeType getGyroscopeType() {
        return GyroscopeType.NAVX_MXP;
    }

    @Override
    public Rotation3d getRotation3d() {
        return super.getRotation3d().minus(orientation);
    }

}
