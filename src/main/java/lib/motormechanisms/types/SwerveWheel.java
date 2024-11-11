package lib.motormechanisms.types;

import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.LinearVelocityRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.followers.FollowerMotor;
import lib.motortypes.swervewheels.SwerveWheelMotor;

public class SwerveWheel {
    private SwerveWheelMotor leaderMotor;
    private FollowerMotor[] followerMotor;
    private double[] followersPositions;
    private double[] followersVelocities;

    public SwerveWheel(SwerveWheelMotor leaderMotor, FollowerMotor... followerMotors) {
        this.leaderMotor = leaderMotor;
        this.followerMotor = followerMotors;
        this.followersPositions = new double[followerMotors.length];
        this.followersVelocities = new double[followerMotors.length];
    }

    public double getPositionMeters() {
        return leaderMotor.getPositionMeters();
    }

    public double getVelocityMetersPerSecond() {
        return leaderMotor.getVelocityMetersPerSecond();
    }

    public double[] getFollowersPositionsMeters() {
        for(int i = 0; i < followersPositions.length; i++){
            followersPositions[i] = followerMotor[i].getMechanismPosition();
        }
        return followersPositions;
    }

    public double[] getFollowersVelocitiesMPS() {
        for(int i = 0; i < followersVelocities.length; i++){
            followersVelocities[i] = followerMotor[i].getMechanismVelocity();
        }
        return followersPositions;
    }

    public void accept(VoltageRequest request) {
        leaderMotor.accept(request);
    }

    public void accept(CurrentRequest request) {
        leaderMotor.accept(request);
    }

    public void acceptVelocityVoltage(LinearVelocityRequest request) {
        leaderMotor.acceptVelocityVoltage(request);
    }

    public void acceptTrapVelocityVoltage(LinearVelocityRequest request) {
        leaderMotor.acceptTrapVelocityVoltage(request);
    }

    public void acceptVelocityCurrent(LinearVelocityRequest request) {
        leaderMotor.acceptVelocityCurrent(request);
    }

    public void acceptTrapVelocityCurrent(LinearVelocityRequest request) {
        leaderMotor.acceptTrapVelocityCurrent(request);
    }
}
