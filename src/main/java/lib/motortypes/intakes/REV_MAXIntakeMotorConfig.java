package lib.motortypes.intakes;

import com.revrobotics.CANSparkBase.IdleMode;

public record REV_MAXIntakeMotorConfig(
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
        double voltagePositionKp,
        double voltagePositionKi,
        double voltagePositionKd,
        double voltageVelocityKp,
        double voltageVelocityKi,
        double voltageVelocityKd,
        double maxVelocityRadPerSec,
        double maxAccelerationRadPerSecSquared) {
}
