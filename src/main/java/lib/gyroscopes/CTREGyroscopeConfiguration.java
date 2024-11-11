package lib.gyroscopes;

public record CTREGyroscopeConfiguration(
    int deviceNumber,
    String canbus,
    double mountPosePitchDegrees,
    double mountPoseRollDegrees,
    double mountPoseYawDegrees
) {}
