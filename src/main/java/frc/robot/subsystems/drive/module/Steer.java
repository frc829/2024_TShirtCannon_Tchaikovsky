// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive.module;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.SparkPIDController.ArbFFUnits;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.signals.AbsoluteSensorRangeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

public class Steer {
    // TODO: Placeholder values.  Replace once determined.
    private static final MotorType motortype = MotorType.kBrushless;
    private static final IdleMode mode = IdleMode.kBrake;
    private static final double maxVoltage = 12.0;
    private static final double accelerationAtMaxVelocity = 0.0;
    private static final double velocityAtMaxAcceleration = 0.0;
    private static final boolean isInverted = false;
    private static final double gearing = -150.0 / 7.0;
    private static final int depth = 2;
    private static final int period_ms = 16;
    private static final double kS = 1;
    private static final double kV = 0.427607143;
    private static final double kA = 1.0;
    private static final int pidSlot = 0;
    private static final double kP = .001; // placeholder
    private static final double kI = 0;
    private static final double kD = .001; // placeholder
    private static final double dtSeconds = .02;

    private final CANSparkMax canSparkMax;
    private final CANcoder canCoder;
    private final TrapezoidProfile trapezoidProfile;
    private final TrapezoidProfile.State goal = new TrapezoidProfile.State();
    private final SimpleMotorFeedforward simpleMotorFeedforward;
    private TrapezoidProfile.State setpoint = new TrapezoidProfile.State();

    public Steer(int moduleNumber) {
        canSparkMax = new CANSparkMax(moduleNumber + 10, motortype);
        canCoder = new CANcoder(moduleNumber + 30);

        CANcoderConfiguration cancoderConfig = new CANcoderConfiguration();
        cancoderConfig.MagnetSensor.AbsoluteSensorRange = AbsoluteSensorRangeValue.Unsigned_0To1;
        cancoderConfig.MagnetSensor.SensorDirection = SensorDirectionValue.CounterClockwise_Positive;
        canCoder.getConfigurator().apply(cancoderConfig);

        canSparkMax.setIdleMode(Steer.mode);
        canSparkMax.setInverted(Steer.isInverted);
        canSparkMax.getEncoder().setPositionConversionFactor(2 * Math.PI / gearing);
        canSparkMax.getEncoder().setVelocityConversionFactor(2 * Math.PI / gearing / 60.0);
        canSparkMax.getEncoder().setAverageDepth(depth);
        canSparkMax.getEncoder().setMeasurementPeriod(period_ms);
        canSparkMax.getPIDController().setP(kP);
        canSparkMax.getPIDController().setI(kI);
        canSparkMax.getPIDController().setD(kD);
        simpleMotorFeedforward = new SimpleMotorFeedforward(kS, kV, kA);
        double maxVelocity = simpleMotorFeedforward.maxAchievableVelocity(maxVoltage, accelerationAtMaxVelocity);
        double maxAcceleration = simpleMotorFeedforward.maxAchievableAcceleration(maxVoltage, velocityAtMaxAcceleration);
        trapezoidProfile = new TrapezoidProfile(new TrapezoidProfile.Constraints(maxVelocity, maxAcceleration));
    }

    public double getPositionDegrees() {
        double degrees = Units.radiansToDegrees(canSparkMax.getEncoder().getPosition());
        return MathUtil.inputModulus(degrees, 0, 360);
    }

    public void setPositionFromAbsolute() {
        // TODO: create an absolutePositionRadians variable set it to Units.rotationsToRadians with the cancoder's getPosition value as the argument
        // TODO: get the cansparkMax's encoder and setPosition to absolutePositionRadians
        // TODO: set setpoint.position to absolutePositionRadians
    }

    public double getVelocityDegreesPerSecond() {
        return Units.radiansToDegrees(canSparkMax.getEncoder().getVelocity());
    }

    public void accept(double setpointDegrees) {
        // Adjust goal and setpoint for angle wrapping.
        goal.position = Math.toRadians(setpointDegrees);
        double positionMeasurementRadians = Math.toRadians(getPositionDegrees());
        double velocityMeasurementRadians = Math.toRadians(getVelocityDegreesPerSecond());
        double errorBound = Math.PI;
        double goalMinDistance = MathUtil.inputModulus(goal.position - positionMeasurementRadians, -errorBound, errorBound);
        double setpointMinDistance = MathUtil.inputModulus(setpoint.position - positionMeasurementRadians, -errorBound, errorBound);
        goal.position = goalMinDistance + positionMeasurementRadians;
        setpoint.position = setpointMinDistance + positionMeasurementRadians;
        // Determined adjusted setpoint and feedforward
        setpoint = trapezoidProfile.calculate(dtSeconds, setpoint, goal);
        double feedforwardVoltage = simpleMotorFeedforward.calculate(velocityMeasurementRadians, setpoint.velocity, dtSeconds);
        // Accept adjusted setpoint with feedforward.
        canSparkMax.getPIDController().setReference(setpoint.position, ControlType.kPosition, pidSlot, feedforwardVoltage, ArbFFUnits.kVoltage);
    }

}


