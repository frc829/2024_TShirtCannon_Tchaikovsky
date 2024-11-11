package frc.robot.subsystems.drive.module;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public class SwerveModule {
    private final Steer steer;
    private final Wheel wheel;
    private final SwerveModulePosition position;
    private final SwerveModuleState state;

    public SwerveModule (int moduleNumber) {
        steer = new Steer(moduleNumber);
        wheel = new Wheel(moduleNumber);
        position = new SwerveModulePosition();
        state = new SwerveModuleState();
    }

    public SwerveModulePosition getPosition () {
        return position;
    }

    public SwerveModuleState getState () {
        return state;
    }

    public void setSteerFromAbsolute() {
        steer.setPositionFromAbsolute();
    }

    public void apply(SwerveModuleState state){
        steer.accept(state.angle.getDegrees());
        wheel.accept(state.speedMetersPerSecond);
    }

    public void update(){
        position.angle = Rotation2d.fromDegrees(steer.getPositionDegrees());
        position.distanceMeters = wheel.getDistanceMeters();
        state.angle = position.angle;
        state.speedMetersPerSecond = wheel.getVelocityMetersPerSecond();
    }
}
