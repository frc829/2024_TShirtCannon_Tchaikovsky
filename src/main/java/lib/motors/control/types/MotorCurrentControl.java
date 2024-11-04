package lib.motors.control.types;

import lib.motors.control.requests.MotorCurrentRequest;

public interface MotorCurrentControl {

    public void accept(MotorCurrentRequest request);

}
