package lib.motortypes.shooters;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public record CTREShooterMotorConfig(
        int deviceNumber,
        String canbus,
        NeutralModeValue neutralModeValue,
        InvertedValue invertedValue,
        double rotorToSensorRatio,
        double sensorToMechanismRatio,
        double voltageKs,
        double voltageKv,
        double voltageKa,
        double voltageKp,
        double voltageKi,
        double voltageKd,
        double currentKs,
        double currentKv,
        double currentKa,
        double currentKp,
        double currentKi,
        double currentKd,
        double maxVelocityMetersPerSec,
        double maxAccelerationMetersPerSecSquared,
        double maxJerkMetersPerSecCubed) {
}
