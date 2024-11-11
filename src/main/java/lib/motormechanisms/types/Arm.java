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
    private final ArmMotor leaderMotor;
    private final FollowerMotor[] followerMotors;
    private final double minAngleDegrees;
    private final double maxAngleDegrees;
    private final double[] followersPositions;
    private final double[] followersVelocities;
    private final AbsoluteEncoder absoluteEncoder;

    public Arm(ArmMotor leaderMotor, AbsoluteEncoder absoluteEncoder, double minAngleDegrees, double maxAngleDegrees, FollowerMotor... followerMotors) {
        this.leaderMotor = leaderMotor;
        this.followerMotors = followerMotors;
        this.minAngleDegrees = minAngleDegrees;
        this.maxAngleDegrees = maxAngleDegrees;
        this.followersPositions = new double[followerMotors.length];
        this.followersVelocities = new double[followerMotors.length];
        this.absoluteEncoder = absoluteEncoder;
    }

    public Arm(AbsoluteEncoderArmMotor leaderMotor, double minAngleDegrees, double maxAngleDegrees, FollowerMotor... followerMotors) {
        this.leaderMotor = leaderMotor;
        this.followerMotors = followerMotors;
        this.minAngleDegrees = minAngleDegrees;
        this.maxAngleDegrees = maxAngleDegrees;
        this.followersPositions = new double[followerMotors.length];
        this.followersVelocities = new double[followerMotors.length];
        this.absoluteEncoder = leaderMotor.getAbsoluteEncoder();
    }

    public double getAngleDegrees() {
        return getAbsoluteAngleDegrees();
    }

    public double getAngularVelocityDegreesPerSecond() {
        return getAngularVelocityDegreesPerSecond();
    }

    public double getMinAngleDegrees() {
        return minAngleDegrees;
    }

    public double getMaxAngleDegrees() {
        return maxAngleDegrees;

    }

    public double getAbsoluteAngleDegrees() {
        return getAbsoluteAngleDegrees();
    }

    public double getAbsoluteAngularVelocityDegreesPerSecond() {
        return getAbsoluteAngularVelocityDegreesPerSecond();
    }

    public void setMotorEncoderFromAbsolute() {
        double absolutePositionDegrees = getAbsoluteAngleDegrees();
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

    public double[] getFollowersAngularVelocitiesDPS() {
        for(int i = 0; i < followersPositions.length; i++){
            followersPositions[i] = followerMotors[i].getMechanismPosition();
        }
        return followersPositions;
    }

    public void accept(VoltageRequest request) {
        accept(request);
    }

    public void accept(CurrentRequest request) {
        accept(request);
    }

    public void acceptPositionVoltage(AngularPositionRequest request) {
        acceptPositionVoltage(request);
    }

    public void acceptTrapPositionVoltage(AngularPositionRequest request) {
        acceptTrapPositionVoltage(request);
    }

    public void acceptExpoPositionVoltage(AngularPositionRequest request) {
        acceptExpoPositionVoltage(request);
    }

    public void acceptVelocityVoltage(AngularVelocityRequest request) {
        acceptVelocityVoltage(request);
    }

    public void acceptTrapVelocityVoltage(AngularVelocityRequest request) {
        acceptTrapVelocityVoltage(request);
    }

    public void acceptPositionCurrent(AngularPositionRequest request) {
        acceptPositionCurrent(request);
    }

    public void acceptTrapPositionCurrent(AngularPositionRequest request) {
        acceptTrapPositionCurrent(request);
    }

    public void acceptExpoPositionCurrent(AngularPositionRequest request) {
        acceptExpoPositionCurrent(request);
    }

    public void acceptVelocityCurrent(AngularVelocityRequest request) {
        acceptVelocityCurrent(request);
    }

    public void acceptTrapVelocityCurrent(AngularVelocityRequest request) {
        acceptTrapVelocityCurrent(request);
    }


}
