package lib.motormechanisms.controlrequests;

public class LinearVelocityRequest {

    private double velocityMetersPerSecond;

    public LinearVelocityRequest withVelocity(double velocityMetersPerSecond) {
        this.velocityMetersPerSecond = velocityMetersPerSecond;
        return this;
    }

    public double getVelocityMetersPerSecond() {
        return velocityMetersPerSecond;
    }
}
