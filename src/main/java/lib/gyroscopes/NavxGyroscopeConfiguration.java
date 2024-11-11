package lib.gyroscopes;

public record NavxGyroscopeConfiguration(
        double mountPosePitchDegrees,
        double mountPoseRollDegrees,
        double mountPoseYawDegrees
) {
}
