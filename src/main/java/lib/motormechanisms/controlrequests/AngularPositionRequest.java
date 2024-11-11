package lib.motormechanisms.controlrequests;

public abstract class AngularPositionRequest {

    private double angleDegrees;

    public AngularPositionRequest withPosition(double angleDegrees) {
        this.angleDegrees = angleDegrees;
        return this;
    }

    public double getAngleDegrees() {
        return angleDegrees;
    }
}
