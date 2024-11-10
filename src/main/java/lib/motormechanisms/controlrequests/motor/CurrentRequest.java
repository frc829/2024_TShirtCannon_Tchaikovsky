package lib.motormechanisms.controlrequests.motor;

public class CurrentRequest {

    private double currentAmps;

    public double getCurrentAmps() {
        return currentAmps;
    }

    public CurrentRequest withCurrentAmps(double currentAmps) {
        this.currentAmps = currentAmps;
        return this;
    }
}