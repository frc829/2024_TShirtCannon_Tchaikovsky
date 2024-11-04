package lib.motors.control.types;

import lib.motors.control.requests.MotorPositionRequest;

public interface MotorPositionControl {

    public void accept(MotorPositionRequest request);

}
