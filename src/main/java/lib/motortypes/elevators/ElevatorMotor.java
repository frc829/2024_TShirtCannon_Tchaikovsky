package lib.motortypes.elevators;

import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.LinearPositionRequest;
import lib.motormechanisms.controlrequests.LinearVelocityRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.MotorControllerType;

public interface ElevatorMotor {

    public int getCanId();

    public String getCanNetworkName();

    public MotorControllerType getMotorControllerType();

    public double getCurrentAmps();

    public double getVoltageVolts();

    public double getPositionMeters();

    public void setLinearPosition(double positionMeters);

    public double getVelocityMetersPerSecond();

    public void accept(VoltageRequest request);

    public void accept(CurrentRequest request);

    public void acceptPositionVoltage(LinearPositionRequest request);

    public void acceptTrapPositionVoltage(LinearPositionRequest request);

    public void acceptExpoPositionVoltage(LinearPositionRequest request);

    public void acceptVelocityVoltage(LinearVelocityRequest request);

    public void acceptTrapVelocityVoltage(LinearVelocityRequest request);

    public void acceptPositionCurrent(LinearPositionRequest request);

    public void acceptTrapPositionCurrent(LinearPositionRequest request);

    public void acceptExpoPositionCurrent(LinearPositionRequest request);

    public void acceptVelocityCurrent(LinearVelocityRequest request);

    public void acceptTrapVelocityCurrent(LinearVelocityRequest request);
}
