package lib.motormechanisms.controlrequests;

public class VoltageRequest {

    private double volts;

    public VoltageRequest withVoltage(double volts) {
        this.volts = volts;
        return this;
    }

    public double getVolts() {
        return volts;
    }
}
