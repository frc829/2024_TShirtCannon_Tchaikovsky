package lib.motormechanisms.types;

import lib.motormechanisms.controlrequests.AngularVelocityRequest;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.followers.FollowerMotor;
import lib.motortypes.intakes.IntakeMotor;

public class Intake {

    // TODO: Jacob: 01: Start Here: don't forget to import when needed.
    // TODO: create a IntakeMotor called leader motor.  private, final
    // TODO: create a FollowerMotor[] called followerMotors. private, final
    // TODO: create a double[] called followersVelocities. private, final

    public Intake(IntakeMotor leaderMotor, FollowerMotor... followerMotors) {
        // TODO: initialize leaderMotor to the parameter
        // TODO: initialize followerMotors to the parameter.
        // TODO: initialize followersVelocities to new double[] passing in brackets followerMotors.length
    }

    public double getAngularVelocityDegreesPerSecond() {
        // TODO: return the getAngularVelocityDegreesPerSecond() method from leaderMotor.
        return 0.0; // TODO: remove this placeholder.
    }

    public double[] getFollowersAngularVelocitiesDPS() {
        // TODO: we need to update followersVelocities so we'll do that with a for loop.
        // TODO: for int i = 0; i < followersVelocities.length; i++
        // TODO inside the for loop followersVelocities[i] = followerMotors[i].getMechanismVelocity();
        return null; // TODO: remove this placeholder.
    }

    public void accept(VoltageRequest request) {
        // TODO: call leaderMotor's accept method passing in request
    }

    public void accept(CurrentRequest request) {
        // TODO: call leaderMotor's accept method passing in request
    }

    public void acceptVelocityVoltage(AngularVelocityRequest request) {
        // TODO: call leaderMotor's acceptVelocityVoltage method passing in request
    }

    public void acceptTrapVelocityVoltage(AngularVelocityRequest request) {
        // TODO: call leaderMotor's acceptTrapVelocityVoltage method passing in request
    }

    public void acceptVelocityCurrent(AngularVelocityRequest request) {
        // TODO: call leaderMotor's acceptVelocityCurrent method passing in request
    }

    public void acceptTrapVelocityCurrent(AngularVelocityRequest request) {
        // TODO: call leaderMotor's acceptTrapVelocityCurrent method passing in request
    }


}
