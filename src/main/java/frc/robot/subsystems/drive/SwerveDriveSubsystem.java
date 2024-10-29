// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drive.module.SwerveModule;

public class SwerveDriveSubsystem extends SubsystemBase {

  private final SwerveDriveKinematics kinematics;
  private final SwerveModule module0;
  private final SwerveModule module1;
  private final SwerveModule module2;
  private final SwerveModule module3;
  private final AHRS gyro;

  /** Creates a new SwerveDriveSubsystem. */
  public SwerveDriveSubsystem() {
    module0 = new SwerveModule(0);
    module1 = new SwerveModule(1);
    module2 = new SwerveModule(3);
    module3 = new SwerveModule(3);

    gyro = new AHRS(SPI.Port.kMXP);
    gyro.reset();
    
    Translation2d frontLeftPosition = new Translation2d(3, 4);
    Translation2d frontRightPosition = new Translation2d(-3, 4);
    Translation2d backLeftPosition = new Translation2d(3, -4);
    Translation2d backRightPosition = new Translation2d(-3, -4);
    kinematics = new SwerveDriveKinematics(frontLeftPosition, frontRightPosition, backLeftPosition, backRightPosition);
  }

  private void apply(SwerveModuleState[] states){
    module0.apply(states[0]);
    module1.apply(states[1]);
    module2.apply(states[2]);
    module3.apply(states[3]);
  }

  private void applyRobotRelative(ChassisSpeeds speeds){
    SwerveModuleState[] states = kinematics.toSwerveModuleStates(speeds);
    apply(states);
  }

  private void applyFieldRelative(ChassisSpeeds speeds){
    // TODO: Once we have a gyro we can implement this.
  }

  @Override
  public void periodic() {
    // TODO: call the update method of each module.
  }
}
