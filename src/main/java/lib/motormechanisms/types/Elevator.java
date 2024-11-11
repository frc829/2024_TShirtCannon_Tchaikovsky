package lib.motormechanisms.types;

import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.LinearPositionRequest;
import lib.motormechanisms.controlrequests.LinearVelocityRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.elevators.ElevatorMotor;
import lib.motortypes.followers.FollowerMotor;

public class Elevator {
    // TODO: Corbin: 01: Start Here: don't forget to import when needed.
    // TODO: create a ElevatorMotor called leader motor.  private, final
    // TODO: create a FollowerMotor[] called followerMotors. private, final
    // TODO: create a double called minHeightMeters. private, final
    // TODO: create a double called maxHeightMeters. private, final
    // TODO: create a double[] called followersPositions. private, final
    // TODO: create a double[] called followersVelocities. private, final

    public Elevator(ElevatorMotor leaderMotor, double minHeightMeters, double maxHeightMeters, FollowerMotor... followerMotors) {
        // TODO: initialize leaderMotor to the parameter
        // TODO: initialize followerMotors to the parameter.
        // TODO: initialize minHeightMeters to the parameter.
        // TODO: initialize maxHeightMeters to the parameter.
        // TODO: initialize followersPositions to new double[] passing in brackets followerMotors.length
        // TODO: initialize followersVelocities to new double[] passing in brackets followerMotors.length
    }

    public double getPositionMeters() {
        // TODO: return the getPositionMeters() method from leaderMotor.
        return 0.0; // TODO: remove this placeholder.
    }

    public void setPositionMeters(double positionMeters) {
        // TODO: call leaderMotor's setLinearPosition method and pass in the parameter.
        // TODO: for int i = 0; i < followerMotors.length; i++
        // TODO: call followerMotors[i]'s setMechanismPosition(positionMeters)
    }

    public double getVelocityMetersPerSecond() {
        // TODO: return the getVelocityMetersPerSecond() method from leaderMotor.
        return 0.0; // TODO: remove this placeholder.
    }

    public double getMinHeightMeters() {
        // TODO: return minHeightMeters
        return 0.0; // TODO: remove this placeholder.
    }

    public double getMaxHeightMeters() {
        // TODO: return maxHeightMeters
        return 0.0; // TODO: remove this placeholder.
    }

    public double[] getFollowersPositionsMeters() {
        // TODO: we need to update followersPositions so we'll do that with a for loop.
        // TODO: for int i = 0; i < followersPositions.length; i++
        // TODO inside the for loop followersPositions[i] = followerMotors[i].getMechanismPosition();
        return null; // TODO: remove this placeholder.
    }

    public double[] getFollowersVelocitiesMPS() {
        // TODO: repeat for followersVelocities and getMechanismVelocity
        return null; // TODO: remove this placeholder.
    }

    public void accept(VoltageRequest request) {
        // TODO: call leaderMotor's accept method passing in request
    }

    public void accept(CurrentRequest request) {
        // TODO: call leaderMotor's accept method passing in request
    }

    public void acceptPositionVoltage(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptPositionVoltage method passing in request
    }

    public void acceptTrapPositionVoltage(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptTrapPositionVoltage method passing in request
    }

    public void acceptExpoPositionVoltage(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptExpoPositionVoltage method passing in request
    }

    public void acceptVelocityVoltage(LinearVelocityRequest request) {
        // TODO: call leaderMotor's acceptVelocityVoltage method passing in request
    }

    public void acceptTrapVelocityVoltage(LinearVelocityRequest request) {
        // TODO: call leaderMotor's acceptTrapVelocityVoltage method passing in request
    }

    public void acceptPositionCurrent(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptPositionCurrent method passing in request
    }

    public void acceptTrapPositionCurrent(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptTrapPositionCurrent method passing in request
    }

    public void acceptExpoPositionCurrent(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptExpoPositionCurrent method passing in request
    }

    public void acceptVelocityCurrent(LinearVelocityRequest request) {
        // TODO: call leaderMotor's acceptVelocityCurrent method passing in request
    }

    public void acceptTrapVelocityCurrent(LinearVelocityRequest request) {
        // TODO: call leaderMotor's acceptTrapVelocityCurrent method passing in request
    }
}
