package lib.motortypes.elevators;

import com.revrobotics.CANSparkBase.IdleMode;

public record REV_MAXElevatorMotorConfig(
        int deviceNumber,
        String canbus,
        IdleMode idleMode,
        boolean invertedValue,
        int averageDepth,
        int samplePeriodMs,
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
        double maxVelocityMetersPerSec,
        double maxAccelerationMetersPerSecSquared) {
}
