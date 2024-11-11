package lib.gyroscopes;

import com.ctre.phoenix6.configs.MountPoseConfigs;
import com.ctre.phoenix6.configs.Pigeon2Configuration;
import com.ctre.phoenix6.hardware.Pigeon2;

public class CTREGyroscope extends Pigeon2 implements Gyroscope {

    public CTREGyroscope(CTREGyroscopeConfiguration config) {
        super(config.deviceNumber(), config.canbus());
        MountPoseConfigs mountPoseConfigs = new MountPoseConfigs()
                .withMountPosePitch(config.mountPosePitchDegrees())
                .withMountPoseRoll(config.mountPoseRollDegrees())
                .withMountPoseYaw(getDeviceHash());
        Pigeon2Configuration pigeon2Configuration = new Pigeon2Configuration()
                .withMountPose(mountPoseConfigs);
        getConfigurator().apply(pigeon2Configuration);
    }

    @Override
    public GyroscopeType getGyroscopeType() {
        return GyroscopeType.CTRE_PIGEON2;
    }

}
