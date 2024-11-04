package lib.motors.can.smart.vendors.ctre.position;

import lib.motors.can.smart.usages.position.PositionSmartMotor;
import lib.motors.can.smart.vendors.ctre.CTRESmartMotor;
import lib.motors.control.requests.MotorPositionRequest;
import lib.motors.control.requests.parameters.InputType;

public class CTREPositionSmartMotor extends CTRESmartMotor implements PositionSmartMotor {

    // TODO: Malaika: 15: create a PositionVoltage object named positionVoltage and initialize with new PositionVoltage(0.0).withSlot(0).withEnableFOC(false);
    // TODO: Malaika: 16: create a MotionMagicVoltage object named motionMagicVoltage and initialize with new MotionMagicVoltage(0.0).withSlot(0).withEnableFOC(false);
    // TODO: Malaika: 17: create a MotionMagicExpoVoltage object named motionMagicExpoVoltage and initialize with new MotionMagicExpoVoltage(0.0).withSlot(0).withEnableFOC(false);
    // TODO: Malaika: 18: create a PositionTorqueCurrentFOC object named positionVoltage and initialize with new PositionVoltage(0.0).withSlot(1);
    // TODO: Malaika: 19: create a MotionMagicTorqueCurrentFOC object named motionMagicVoltage and initialize with new MotionMagicVoltage(0.0).withSlot(1);
    // TODO: Malaika: 20: create a MotionMagicExpoTorqueCurrentFOC object named motionMagicExpoVoltage and initialize with new MotionMagicExpoVoltage(0.0).withSlot(1);
    // TODO: Malaika: 30: create a MotionMagicConfigs object named voltageMotionMagicConfigs;
    // TODO: Malaika: 31: create a MotionMagicConfigs object named currentMotionMagicConfigs;
    // TODO: Malaika: 32: create an inputTypeUsing and initialize to InputType.VOLTAGE;

    public CTREPositionSmartMotor(CTREPositionSmartMotorConfiguration config) {
        // TODO: Malaika: 33: call super(config)
        super(null); // TODO: remove this placeholder
        // TODO: Malaika: 34: set voltageMotionMagicConfigs to config's getMotionMagicVoltageConfigs() method
        // TODO: Malaika: 35: set currentMotionMagicConfigs to config's getMotionMagicCurrentConfigs() method
    }

    private void handleInputType(InputType inputType) {
        // TODO: Malaika: 36: check if inputType != inputTypeUsing and inputType is InputType.VOLTAGE
        // TODO: Malaika: 37: if true set inputTypeUsing to inputType
        // TODO: Malaika: 38: call motor.getConfigurator().apply() passing in voltageMotionMagicConfigs
        // TODO: Malaika: 39: else if inputType != inputTypeUsing && inputType is InputType.CURRENT
        // TODO: Malaika: 40: set inputTypeUsing to inputType
        // TODO: Malaika: 41: call motor.getConfigurator().apply() passing in currentMotionMagicConfigs
    }

    @Override
    public void accept(MotorPositionRequest request) {
        // TODO: Malaika: 42: call handleInputType() passing in request.getInputType()
        // TODO: Malaika: 43: write a switch statement with request.getInputType() as its parameter
        // TODO: Malaika: 44: for the VOLTAGE case call handleVoltage(request)
        // TODO: Malaika: 45: for the CURRENT case call handleCurrent(request)
    }

    private void handleVoltage(MotorPositionRequest request) {
        // TODO: Malaika: 46: write a switch statement with request.getProfileType() as its parameter.
        // TODO: Malaika: 47: for the NONE case call motor.setControl(positionVoltage.withPosition(request.getPosition());
        // TODO: Malaika: 48: for the TRAPEZOID cases call call motor.setControl(motionMagicVoltage.withPosition(request.getPosition());
        // TODO: Malaika: 49: for the EXPONENTIAL cases call call motor.setControl(motionMagicExpoVoltage.withPosition(request.getPosition());
    }

    private void handleCurrent(MotorPositionRequest request) {
        // TODO: Malaika: 50: write a switch statement with request.getProfileType() as its parameter.
        // TODO: Malaika: 51: for the NONE case call motor.setControl(positionTorqueCurrentFOC.withPosition(request.getPosition());
        // TODO: Malaika: 52: for the TRAPEZOID cases call call motor.setControl(motionMagicTorqueCurrentFOC.withPosition(request.getPosition());
        // TODO: Malaika: 53: for the EXPONENTIAL cases call call motor.setControl(motionMagicExpoTorqueCurrentFOC.withPosition(request.getPosition());
    }
}
