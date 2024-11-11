package lib.motortypes.followers;

import lib.motortypes.MotorControllerType;

public interface FollowerMotor {

    public int getCanId();

    public String getCanNetworkName();

    public MotorControllerType getMotorControllerType();

    public double getCurrentAmps();

    public double getVoltageVolts();

    public double getMechanismPosition();

    public void setMechanismPosition(double position);

    public double getMechanismVelocity();

    public int getLeaderMotorId();

    public String getLeaderMotorNetworkName();

    public boolean isInvertedFromLeader();


}
