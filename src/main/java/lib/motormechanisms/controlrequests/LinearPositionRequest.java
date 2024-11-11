package lib.motormechanisms.controlrequests;

public class LinearPositionRequest {

    private double positionMeters;

    public LinearPositionRequest withPosition(double positionMeters) {
        this.positionMeters = positionMeters;
        return this;
    }

    public double getPositionMeters() {
        return positionMeters;
    }
}
