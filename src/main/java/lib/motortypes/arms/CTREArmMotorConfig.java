package lib.motortypes.arms;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public record CTREArmMotorConfig(
        int deviceNumber,
        String canbus,
        NeutralModeValue neutralModeValue,
        InvertedValue invertedValue,
        double rotorToSensorRatio,
        double sensorToMechanismRatio,
        double voltageKs,
        double voltageKv,
        double voltageKa,
        double voltageKg,
        double voltagePositionKp,
        double voltagePositionKi,
        double voltagePositionKd,
        double voltageVelocityKp,
        double voltageVelocityKi,
        double voltageVelocityKd,
        double currentKs,
        double currentKv,
        double currentKa,
        double currentKg,
        double currentPositionKp,
        double currentPositionKi,
        double currentPositionKd,
        double currentVelocityKp,
        double currentVelocityKi,
        double currentVelocityKd,
        double maxVelocityRadPerSec,
        double maxAccelerationRadPerSecSquared,
        double maxJerkRadPerSecCubed) {
}
