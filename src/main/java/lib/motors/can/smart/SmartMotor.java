package lib.motors.can.smart;

import lib.motors.control.types.MotorCurrentControl;
import lib.motors.control.types.MotorVoltageControl;
import lib.motors.can.CANMotor;

public interface SmartMotor extends CANMotor, MotorVoltageControl, MotorCurrentControl {


}
