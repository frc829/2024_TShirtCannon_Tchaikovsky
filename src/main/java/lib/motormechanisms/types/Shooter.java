package lib.motormechanisms.types;

import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.LinearVelocityRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.followers.FollowerMotor;
import lib.motortypes.shooters.ShooterMotor;

public class Shooter {
    private final ShooterMotor leaderMotor;
    private final FollowerMotor[] followerMotors;
    // TODO: create a  called . , 
    private final double[] followersVelocities;

    public Shooter(ShooterMotor leaderMotor, FollowerMotor... followerMotors) {
        this.leaderMotor = leaderMotor;
        this.followerMotors = followerMotors;
        followersVelocities = new double[followerMotors.length];
    }

    public double getVelocityMetersPerSecond() {
        return leaderMotor.getVelocityMetersPerSecond();
    }

    public double[] getFollowersVelocitiesMPS() {
        for (int i = 0; i < followersVelocities.length; i++){
            followersVelocities[i] = followerMotors[i].getMechanismVelocity();
        }
        return followersVelocities;
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
