package lib.motormechanisms.types;

import lib.absoluteEncoders.AbsoluteEncoder;
import lib.motormechanisms.controlrequests.AngularPositionRequest;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.followers.FollowerMotor;
import lib.motortypes.swervesteers.AbsoluteEncoderSwerveSteerMotor;
import lib.motortypes.swervesteers.SwerveSteerMotor;

public class SwerveSteer {
    // TODO: Braden: 03: Continue Here: don't forget to import when needed.
    // TODO: create a SwerveSteerMotor called leader motor.  private, final
    // TODO: create a FollowerMotor[] called followerMotors. private, final
    // TODO: create a double[] called followersPositions. private, final
    // TODO: create an AbsoluteEncoder called absoluteEncoder. private, final

    public SwerveSteer(SwerveSteerMotor leaderMotor, AbsoluteEncoder absoluteEncoder, FollowerMotor... followerMotors) {
        // TODO: initialize leaderMotor to the parameter
        // TODO: initialize followerMotors to the parameter.
        // TODO: initialize followersPositions to new double[] passing in brackets followerMotors.length
        // TODO: initialize absoluteEncoder to the parameter.
    }

    public SwerveSteer(AbsoluteEncoderSwerveSteerMotor leaderMotor, FollowerMotor... followerMotors) {
        // TODO: initialize leaderMotor to the parameter
        // TODO: initialize followerMotors to the parameter.
        // TODO: initialize followersPositions to new double[] passing in brackets followerMotors.length
        // TODO: initialize absoluteEncoder to the getAbsoluteEncoder() method of leaderMotor
    }

    public double getAngleDegrees() {
        // TODO: return the getAngleDegrees() method from leaderMotor.
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

    public void acceptPositionCurrent(AngularPositionRequest request) {
        // TODO: call leaderMotor's acceptPositionCurrent method passing in request
    }

    public void acceptTrapPositionCurrent(AngularPositionRequest request) {
        // TODO: call leaderMotor's acceptTrapPositionCurrent method passing in request
    }

    public void acceptExpoPositionCurrent(AngularPositionRequest request) {
        // TODO: call leaderMotor's acceptExpoPositionCurrent method passing in request
    }
}
