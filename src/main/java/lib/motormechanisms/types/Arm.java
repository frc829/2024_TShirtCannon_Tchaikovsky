package lib.motormechanisms.types;

import lib.absoluteEncoders.AbsoluteEncoder;
import lib.motormechanisms.controlrequests.AngularPositionRequest;
import lib.motormechanisms.controlrequests.AngularVelocityRequest;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.arms.AbsoluteEncoderArmMotor;
import lib.motortypes.arms.ArmMotor;
import lib.motortypes.followers.FollowerMotor;

public class Arm {

    // TODO: Angel: 01: Start Here: don't forget to import when needed.
    // TODO: create a ArmMotor called leader motor.  private, final
    // TODO: create a FollowerMotor[] called followerMotors. private, final
    // TODO: create a double called minAngleDegrees. private, final
    // TODO: create a double called maxAngleDegrees. private, final
    // TODO: create a double[] called followersPositions. private, final
    // TODO: create a double[] called followersVelocities. private, final
    // TODO: create an AbsoluteEncoder called absoluteEncoder. private final

    public Arm(ArmMotor leaderMotor, AbsoluteEncoder absoluteEncoder, double minAngleDegrees, double maxAngleDegrees, FollowerMotor... followerMotors) {
        // TODO: initialize leaderMotor to the parameter
        // TODO: initialize followerMotors to the parameter.
        // TODO: initialize minAngleDegrees to the parameter.
        // TODO: initialize maxAngleDegrees to the parameter.
        // TODO: initialize followersPositions to new double[] passing in brackets followerMotors.length
        // TODO: initialize followersVelocities to new double[] passing in brackets followerMotors.length
        // TODO: initialize absoluteEncoder to the parameter.
    }

    public Arm(AbsoluteEncoderArmMotor leaderMotor, double minAngleDegrees, double maxAngleDegrees, FollowerMotor... followerMotors) {
        // TODO: initialize leaderMotor to the parameter
        // TODO: initialize followerMotors to the parameter.
        // TODO: initialize minAngleDegrees to the parameter.
        // TODO: initialize maxAngleDegrees to the parameter.
        // TODO: initialize followersPositions to new double[] passing in brackets followerMotors.length
        // TODO: initialize followersVelocities to new double[] passing in brackets followerMotors.length
        // TODO: initialize absoluteEncoder to leaderMotor's getAbsoluteEncoder() method.
    }

    public double getAngleDegrees() {
        // TODO: return the getAngleDegrees() method from leaderMotor.
        return 0.0; // TODO: remove this placeholder.
    }

    public double getAngularVelocityDegreesPerSecond() {
        // TODO: return the getAngularVelocityDegreesPerSecond() method from leaderMotor.
        return 0.0; // TODO: remove this placeholder.
    }

    public double getMinAngleDegrees() {
        // TODO: return minAngleDegrees
        return 0.0; // TODO: remove this placeholder.
    }

    public double getMaxAngleDegrees() {
        // TODO: return maxAngleDegrees
        return 0.0; // TODO: remove this placeholder.
    }

    public double getAbsoluteAngleDegrees() {
        // TODO: return the getAbsoluteAngleDegrees() method from leaderMotor.
        return 0.0; // TODO: remove this placeholder.
    }

    public double getAbsoluteAngularVelocityDegreesPerSecond() {
        // TODO: return the getAbsoluteAngularVelocityDegreesPerSecond() method from leaderMotor.
        return 0.0; // TODO: remove this placeholder.
    }

    public void setMotorEncoderFromAbsolute() {
        // TODO: we need to set all of the followerMotors encoder as well.  Lest we get bad data.  So a for loop
        // TODO: create a local variable called absolutePositionDegrees as a double and initialize from
        // absoluteEncoder's getAbsoluteAngleDegrees() method.
        // TODO: call leaderMotor's setAngleDegrees() method passing in absolutePositionDegrees
        // TODO: for int i = 0; i < followerMotors.length; i++
        // followerMotors[i] call setMechanismPosition(). pass in absolutePositionDegrees
    }

    public double[] getFollowersAnglesDegrees() {
        // TODO: we need to update followersPositions so we'll do that with a for loop.
        // TODO: for int i = 0; i < followersPositions.length; i++
        // TODO inside the for loop followersPositions[i] = followerMotors[i].getMechanismPosition();
        return null; // TODO: remove this placeholder.
    }

    public double[] getFollowersAngularVelocitiesDPS() {
        // TODO: repeat for followersVelocities and getMechanismVelocity
        return null; // TODO: remove this placeholder.
    }

    public void accept(VoltageRequest request) {
        // TODO: call leaderMotor's accept method passing in request
    }

    public void accept(CurrentRequest request) {
        // TODO: call leaderMotor's accept method passing in request
    }

    public void acceptPositionVoltage(AngularPositionRequest request) {
        // TODO: call leaderMotor's acceptPositionVoltage method passing in request
    }

    public void acceptTrapPositionVoltage(AngularPositionRequest request) {
        // TODO: call leaderMotor's acceptTrapPositionVoltage method passing in request
    }

    public void acceptExpoPositionVoltage(AngularPositionRequest request) {
        // TODO: call leaderMotor's acceptExpoPositionVoltage method passing in request
    }

    public void acceptVelocityVoltage(AngularVelocityRequest request) {
        // TODO: call leaderMotor's acceptVelocityVoltage method passing in request
    }

    public void acceptTrapVelocityVoltage(AngularVelocityRequest request) {
        // TODO: call leaderMotor's acceptTrapVelocityVoltage method passing in request
    }

    public void acceptPositionCurrent(AngularPositionRequest request) {
        // TODO: call leaderMotor's acceptPositionCurrent method passing in request
    }

    public void acceptTrapPositionCurrent(AngularPositionRequest request) {
        // TODO: call leaderMotor's acceptTrapPositionCurrent method passing in request
    }

    public void acceptExpoPositionCurrent(AngularPositionRequest request) {
        // TODO: call leaderMotor's acceptExpoPositionCurrent method passing in request
    }

    public void acceptVelocityCurrent(AngularVelocityRequest request) {
        // TODO: call leaderMotor's acceptVelocityCurrent method passing in request
    }

    public void acceptTrapVelocityCurrent(AngularVelocityRequest request) {
        // TODO: call leaderMotor's acceptTrapVelocityCurrent method passing in request
    }


}
