package frc.robot.subsystems.drive.module;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.util.Units;

public class Wheel {
    // TODO: Placeholder values.  Replace once determined.
    private static final double gearRatio = 5.902777777777778;
    private static final double wheelRadiusMeters = Units.inchesToMeters(2.0);
    private static final InvertedValue invertedValue = InvertedValue.Clockwise_Positive;
    private static final NeutralModeValue neutralModeValue = NeutralModeValue.Brake;
    private static final int pidSlot = 1;
    private static final double kS = 1;
    private static final double kV = 2.6158;
    private static final double kA = 0.054006;
    private static final double kP = .001;
    private static final double kI = 0.0;
    private static final double kD = 0.0;

    private final TalonFX motor;
    private final VelocityVoltage controlRequest;

    public Wheel(int moduleNumber) {
        motor = new TalonFX(moduleNumber + 20);
        SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(kS, kV, kA);
        double maxAcceleration = feedforward.maxAchievableAcceleration(12.0, 0.0);
        TalonFXConfiguration talonConfigs = new TalonFXConfiguration();
        talonConfigs.Feedback.SensorToMechanismRatio = 2 * Math.PI * wheelRadiusMeters / gearRatio;
        talonConfigs.MotionMagic.MotionMagicAcceleration = maxAcceleration;
        talonConfigs.MotorOutput.Inverted = invertedValue;
        talonConfigs.MotorOutput.NeutralMode = neutralModeValue;
        talonConfigs.Slot1.kS = kS;
        talonConfigs.Slot1.kV = kV;
        talonConfigs.Slot1.kA = kA;
        talonConfigs.Slot1.kP = kP;
        talonConfigs.Slot1.kI = kI;
        talonConfigs.Slot1.kD = kD;
        motor.getConfigurator().apply(talonConfigs);
        controlRequest = new VelocityVoltage(0.0).withSlot(pidSlot);
    }

    public double getDistanceMeters() {
        return motor.getPosition().getValueAsDouble();
    }

    public double getVelocityMetersPerSecond() {
        return motor.getVelocity().getValueAsDouble();
    }

    public void accept(double velocityMetersPerSecond) {
        motor.setControl(controlRequest.withVelocity(velocityMetersPerSecond));
    }
}
