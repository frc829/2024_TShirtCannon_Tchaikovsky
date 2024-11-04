package lib.motors.can;

import lib.VendorType;

public interface CANMotor {

    public double getCurrentAmps();

    public double getVoltageVolts();

    public int getCanId();

    public String getCanNetworkName();

    public VendorType getControlVendorType();

    public double getPosition();

    public void setPosition(double position);

    public double getVelocity();


}
