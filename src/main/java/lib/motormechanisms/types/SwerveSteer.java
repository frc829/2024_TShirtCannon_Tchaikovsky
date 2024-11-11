package lib.motormechanisms.types;

import org.ejml.equation.Variable;

import lib.absoluteEncoders.AbsoluteEncoder;
import lib.motormechanisms.controlrequests.AngularPositionRequest;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.followers.FollowerMotor;
import lib.motortypes.swervesteers.AbsoluteEncoderSwerveSteerMotor;
import lib.motortypes.swervesteers.SwerveSteerMotor;

public class SwerveSteer {

    private final SwerveSteerMotor leaderMotor;
    private final FollowerMotor[] followerMotors;
    private final double[] followersPositions;
    private final AbsoluteEncoder absoluteEncoder;

    public SwerveSteer(SwerveSteerMotor leaderMotor, AbsoluteEncoder absoluteEncoder, FollowerMotor... followerMotors) {
        this.leaderMotor = leaderMotor;
        this.followerMotors = followerMotors;
        this.followersPositions = new double[followerMotors.length];
        this.absoluteEncoder = absoluteEncoder;
    }

    public SwerveSteer(AbsoluteEncoderSwerveSteerMotor leaderMotor, FollowerMotor... followerMotors) {
        this.leaderMotor = leaderMotor;
        this.followerMotors = followerMotors;
        this.followersPositions = new double[followerMotors.length];
        this.absoluteEncoder = leaderMotor.getAbsoluteEncoder();
    }

    public double getAngleDegrees() {
        return leaderMotor.getAngleDegrees();
    }

    public double getAbsoluteAngleDegrees() {
        return getAbsoluteAngleDegrees();
    }

    public double getAbsoluteAngularVelocityDegreesPerSecond() {
        return getAbsoluteAngularVelocityDegreesPerSecond();
    }

    public void setMotorEncoderFromAbsolute() {
        double absolutePositionDegrees = absoluteEncoder.getAbsoluteAngleDegrees();
        leaderMotor.setAngleDegrees(absolutePositionDegrees);
        for(int i = 0; i < followerMotors.length; i++){
            followerMotors[i].setMechanismPosition(absolutePositionDegrees);
        }
    }

    public double[] getFollowersAnglesDegrees() {
        for(int i = 0; i < followersPositions.length; i++){
            followersPositions[i] = followerMotors[i].getMechanismPosition();
        }
        return followersPositions;
    }

    public void accept(VoltageRequest request) {
        leaderMotor.accept(request);
    }

    public void accept(CurrentRequest request) {
        leaderMotor.accept(request);
    }

    public void acceptPositionVoltage(AngularPositionRequest request) {
        leaderMotor.acceptPositionVoltage(request);
    }

    public void acceptTrapPositionVoltage(AngularPositionRequest request) {
        leaderMotor.acceptTrapPositionVoltage(request);
    }

    public void acceptExpoPositionVoltage(AngularPositionRequest request) {
        leaderMotor.acceptExpoPositionVoltage(request);
    }

    public void acceptPositionCurrent(AngularPositionRequest request) {
        leaderMotor.acceptPositionCurrent(request);
    }

    public void acceptTrapPositionCurrent(AngularPositionRequest request) {
        leaderMotor.acceptTrapPositionCurrent(request);
    }

    public void acceptExpoPositionCurrent(AngularPositionRequest request) {
        leaderMotor.acceptExpoPositionCurrent(request);
    }
}
