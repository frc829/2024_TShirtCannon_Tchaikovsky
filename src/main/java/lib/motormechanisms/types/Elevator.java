package lib.motormechanisms.types;

import java.lang.reflect.Parameter;

import javax.crypto.Mac;

import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.LinearPositionRequest;
import lib.motormechanisms.controlrequests.LinearVelocityRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.elevators.ElevatorMotor;
import lib.motortypes.followers.FollowerMotor;

public class Elevator {
    // TODO: Corbin: 01: Start Here: don't forget to import when needed.
    private final ElevatorMotor LeaderMotor;
    // TODO: create a ElevatorMotor called leader motor.  private, final
    private final FollowerMotor[] followerMotors;
    // TODO: create a FollowerMotor[] called followerMotors. private, final
    private final double minHeightMeters;
    // TODO: create a double called minHeightMeters. private, final
    private final double maxHeightMeters;
    // TODO: create a double called maxHeightMeters. private, final
    private final double[] followersPositions;
    // TODO: create a double[] called followersPositions. private, final
    private final double[] followersVelocities; 
    // TODO: create a double[] called followersVelocities. private, final

    public Elevator(ElevatorMotor leaderMotor, double minHeightMeters, double maxHeightMeters, FollowerMotor... followerMotors) {
        // TODO: initialize leaderMotor to the parameter
        this.LeaderMotor = leaderMotor;
        // TODO: initialize followerMotors to the parameter.
        this.followerMotors = followerMotors;
        // TODO: initialize minHeightMeters to the parameter.
        this.minHeightMeters = minHeightMeters;
        // TODO: initialize maxHeightMeters to the parameter.
        this.maxHeightMeters = maxHeightMeters;
        // TODO: initialize followersPositions to new double[] passing in brackets followerMotors.length
        this.followersPositions = new double[followerMotors.length]
        // TODO: initialize followersVelocities to new double[] passing in brackets followerMotors.length
        this.followersVelocities = new double[followerMotors.length]
    }

    public double getPositionMeters() {
        // TODO: return the getPositionMeters() method from leaderMotor.
        
        return LeaderMotor.getPositionMeters(); // TODO: remove this placeholder.
    }

    public void setPositionMeters(double positionMeters) {
        // TODO: call leaderMotor's setLinearPosition method and pass in the parameter.
        LeaderMotor.setLinearPosition(positionMeters);
        // TODO: for int i = 0; i < followerMotors.length; i++
        for (int i = 0; i < followerMotors.length; i++){
            followerMotors[i].setMechanismPosition(positionMeters);
        }
        // TODO: call followerMotors[i]'s setMechanismPosition(positionMeters)
    }

    public double getVelocityMetersPerSecond() {
        // TODO: return the getVelocityMetersPerSecond() method from leaderMotor.
        return LeaderMotor.getVelocityMetersPerSecond(); // TODO: remove this placeholder.
    }

    public double getMinHeightMeters() {
        // TODO: return minHeightMeters
        return minHeightMeters; // TODO: remove this placeholder.
    }

    public double getMaxHeightMeters() {
        // TODO: return maxHeightMeters
        return maxHeightMeters; // TODO: remove this placeholder.
    }

    public double[] getFollowersPositionsMeters() {
        // TODO: we need to update followersPositions so we'll do that with a for loop. 
        // TODO: for int i = 0; i < followersPositions.length; i++
        // TODO inside the for loop followersPositions[i] = followerMotors[i].getMechanismPosition();
         for (int i = 0; i < followersPositions.length; i++){
            followersPositions[i] = followerMotors[i].getMechanismPosition();
        }
        return followersPositions; // TODO: remove this placeholder.
    }

    public double[] getFollowersVelocitiesMPS() {
        // TODO: repeat for followersVelocities and getMechanismVelocity
        for (int i = 0; i < followersVelocities.length; i++){
            followersVelocities[i] = followerMotors[i].getMechanismVelocity();}
        return followersVelocities; // TODO: remove this placeholder.
    }

    public void accept(VoltageRequest request) {
        // TODO: call leaderMotor's accept method passing in request
        LeaderMotor.accept(request);
    }

    public void accept(CurrentRequest request) {
        // TODO: call leaderMotor's accept method passing in request
        LeaderMotor.accept(request);
    }

    public void acceptPositionVoltage(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptPositionVoltage method passing in request
        LeaderMotor.acceptPositionVoltage(request);
    }

    public void acceptTrapPositionVoltage(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptTrapPositionVoltage method passing in request
        LeaderMotor.acceptTrapPositionVoltage(request);;
    }

    public void acceptExpoPositionVoltage(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptExpoPositionVoltage method passing in request
        LeaderMotor.acceptExpoPositionVoltage(request);
    }

    public void acceptVelocityVoltage(LinearVelocityRequest request) {
        // TODO: call leaderMotor's acceptVelocityVoltage method passing in request
        LeaderMotor.acceptVelocityVoltage(request);
    }

    public void acceptTrapVelocityVoltage(LinearVelocityRequest request) {
        // TODO: call leaderMotor's acceptTrapVelocityVoltage method passing in request
        LeaderMotor.acceptTrapVelocityVoltage(request);;
    }

    public void acceptPositionCurrent(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptPositionCurrent method passing in request
        LeaderMotor.acceptPositionCurrent(request);
    }

    public void acceptTrapPositionCurrent(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptTrapPositionCurrent method passing in request
        LeaderMotor.acceptTrapPositionCurrent(request);;
    }

    public void acceptExpoPositionCurrent(LinearPositionRequest request) {
        // TODO: call leaderMotor's acceptExpoPositionCurrent method passing in request
        LeaderMotor.acceptExpoPositionCurrent(request);;
    }

    public void acceptVelocityCurrent(LinearVelocityRequest request) {
        // TODO: call leaderMotor's acceptVelocityCurrent method passing in request
        LeaderMotor.acceptVelocityCurrent(request);
    }

    public void acceptTrapVelocityCurrent(LinearVelocityRequest request) {
        // TODO: call leaderMotor's acceptTrapVelocityCurrent method passing in request
        LeaderMotor.acceptTrapVelocityCurrent(request);
    }
}
