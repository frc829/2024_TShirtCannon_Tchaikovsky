package lib.motors.can.followers;

import lib.motors.can.CANMotor;

public interface FollowerMotor extends CANMotor {

    public int getLeaderMotorId();

    public String getLeaderMotorNetworkName();

    public boolean isInvertedFromLeader();

}
