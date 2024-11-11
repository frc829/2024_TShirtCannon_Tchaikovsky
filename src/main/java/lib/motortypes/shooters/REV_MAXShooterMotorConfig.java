package lib.motortypes.shooters;

import com.revrobotics.CANSparkBase.IdleMode;

public record REV_MAXShooterMotorConfig(
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
        double voltageVelocityKp,
        double voltageVelocityKi,
        double voltageVelocityKd,
        double maxVelocityMetersPerSec,
        double maxAccelerationMetersPerSecSquared) {
}
