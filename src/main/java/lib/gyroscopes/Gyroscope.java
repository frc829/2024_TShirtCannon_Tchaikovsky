package lib.gyroscopes;

import edu.wpi.first.math.geometry.Rotation3d;

public interface Gyroscope {

    public GyroscopeType getGyroscopeType();

    public Rotation3d getRotation3d();

    public void reset();
}
