package lib.motortypes.followers;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public record CTREFollowerMotorConfiguration(
        int deviceNumber,
        String canbus,
        NeutralModeValue neutralModeValue,
        double rotorToSensorRatio,
        double sensorToMechanismRatio,
        int leaderMotorDeviceNumber,
        String leaderMotorCanbus,
        boolean isInvertedFromLeader) {
}
