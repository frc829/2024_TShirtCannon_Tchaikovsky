package lib.motormechanisms.types;

import lib.motormechanisms.controlrequests.AngularVelocityRequest;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.followers.FollowerMotor;
import lib.motortypes.intakes.IntakeMotor;

public class Intake {

    private final IntakeMotor leaderMotor;
    private final FollowerMotor[] followerMotors;
    private final double[] followersVelocities;

    public Intake(IntakeMotor leaderMotor, FollowerMotor... followerMotors) {
        this.leaderMotor = leaderMotor;
        this.followerMotors = followerMotors;
        followersVelocities = new double[followerMotors.length];
    }

    public double getAngularVelocityDegreesPerSecond() {
        // TODO:  the  method from .
        return leaderMotor.getAngularVelocityDegreesPerSecond();
    }

    public double[] getFollowersAngularVelocitiesDPS() {
        for(int i = 0; i < followersVelocities.length; i++){
            followersVelocities[i] = followerMotors[i].getMechanismVelocity();
        }
        return followersVelocities;
    }

    public void accept(VoltageRequest request) {
        // TODO: call 's  method passing in 
        leaderMotor.accept(request);
    }

    public void accept(CurrentRequest request) {
        leaderMotor.accept(request);
    }

    public void acceptVelocityVoltage(AngularVelocityRequest request) {
        leaderMotor.acceptVelocityVoltage(request);
    }

    public void acceptTrapVelocityVoltage(AngularVelocityRequest request) {
        leaderMotor.acceptTrapVelocityVoltage(request);
    }

    public void acceptVelocityCurrent(AngularVelocityRequest request) {
        leaderMotor.acceptVelocityCurrent(request);
    }

    public void acceptTrapVelocityCurrent(AngularVelocityRequest request) {
        // TODO: call 's  method passing in 
        leaderMotor.acceptTrapVelocityCurrent(request);
    }


}
