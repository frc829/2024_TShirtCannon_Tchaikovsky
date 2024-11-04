package lib.motors.control.types;

import lib.motors.control.requests.MotorVelocityRequest;

public interface MotorVelocityControl {

    public void accept(MotorVelocityRequest request);

}
