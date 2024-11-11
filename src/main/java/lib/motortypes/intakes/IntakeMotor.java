package lib.motortypes.intakes;

import lib.motormechanisms.controlrequests.AngularVelocityRequest;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.MotorControllerType;

public interface IntakeMotor {

    public int getCanId();

    public String getCanNetworkName();

    public MotorControllerType getMotorControllerType();

    public double getCurrentAmps();

    public double getVoltageVolts();

    public double getAngularVelocityDegreesPerSecond();

    public void accept(VoltageRequest request);

    public void accept(CurrentRequest request);

    public void acceptVelocityVoltage(AngularVelocityRequest request);

    public void acceptTrapVelocityVoltage(AngularVelocityRequest request);

    public void acceptVelocityCurrent(AngularVelocityRequest request);

    public void acceptTrapVelocityCurrent(AngularVelocityRequest request);
}
