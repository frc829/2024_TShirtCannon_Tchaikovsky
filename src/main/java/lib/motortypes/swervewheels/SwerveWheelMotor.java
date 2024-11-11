package lib.motortypes.swervewheels;

import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.LinearVelocityRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.MotorControllerType;

public interface SwerveWheelMotor {

    public int getCanId();

    public String getCanNetworkName();

    public MotorControllerType getMotorControllerType();

    public double getCurrentAmps();

    public double getVoltageVolts();

    public double getPositionMeters();

    public double getVelocityMetersPerSecond();

    public void accept(VoltageRequest request);

    public void accept(CurrentRequest request);

    public void acceptVelocityVoltage(LinearVelocityRequest request);

    public void acceptTrapVelocityVoltage(LinearVelocityRequest request);

    public void acceptVelocityCurrent(LinearVelocityRequest request);

    public void acceptTrapVelocityCurrent(LinearVelocityRequest request);
}
