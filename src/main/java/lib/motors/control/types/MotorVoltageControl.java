package lib.motors.control.types;

import lib.motors.control.requests.MotorVoltageRequest;

public interface MotorVoltageControl {

    public void accept(MotorVoltageRequest request);

}
