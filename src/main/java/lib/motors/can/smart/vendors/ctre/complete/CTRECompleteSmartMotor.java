package lib.motors.can.smart.vendors.ctre.complete;

import lib.motors.can.smart.vendors.ctre.CTRESmartMotor;
import lib.motors.control.requests.MotorPositionRequest;
import lib.motors.control.requests.MotorVelocityRequest;
import lib.motors.control.requests.parameters.InputType;
import lib.motors.can.smart.usages.complete.CompleteSmartMotor;

public class CTRECompleteSmartMotor extends CTRESmartMotor implements CompleteSmartMotor {

    // TODO: Robbie: 09: create a PositionVoltage named positionVoltage and initialize with new PositionVoltage(0.0).withSlot(0).withEnableFOC(false)
    // TODO: Robbie: 10: create a MotionMagicVoltage named motionMagicVoltage and initialize with new MotionMagicVoltage(0.0).withSlot(0).withEnableFOC(false);
    // TODO: Robbie: 11: create a MotionMagicExpoVoltage named motionMagicExpoVoltage and initialize with NewMotionMagicExpo(0.0).withSlot(0).withEnableFOC(false);
    // TODO: Robbie: 12: create a PositionTorqueCurrentFOC named positionTorqueCurrentFOC and initialize with new PositionTorqueCurrentFOC(0.0).withSlot(1)
    // TODO: Robbie: 13: create a MotionMagicTorqueCurrentFOC named motionMagicTorqueCurrentFOC and initialize with new MotionMagicTorqueCurrentFOC(0.0).withSlot(1)
    // TODO: Robbie: 14: create a MotionMagicExpoTorqueCurrentFOC named motionMagicExpoTorqueCurrentFOC and initialize with new MotionMagicExpoTorqueCurrentFOC(0.0).withSlot(1)
    // TODO: Robbie: 15: create a VelocityVoltage named velocityVoltage and initialize with new VelocityVoltage(0.0).withSlot(2).withEnableFOC(false);
    // TODO: Robbie: 16: create a MotionMagicVelocityVoltage named motionMagicVelocityVoltage and initialize with new MotionMagicVelocityVoltage(0.0).withSlot(2).withEnableFOC(false);
    // TODO: Robbie: 17: create a VelocityTorqueCurrentFOC named velocityTorqueCurrentFOC and initialize with new VelocityTorqueCurrentFOC(0.0).withSlot(2);
    // TODO: Robbie: 18: create a MotionMagicVelocityTorqueCurrentFOC named motionMagicVelocityTorqueCurrentFOC and initialize with new MotionMagicVelocityTorqueCurrentFOC(0.0).withSlot(2).withEnableFOC(true);
    // TODO: Robbie: 19: create a MotionMagicConfigs named voltageMotionMagicConfigs
    // TODO: Robbie: 20: create a MotionMagicConfigs named currentMotionMagicConfigs
    // TODO: Robbie: 21: create a Slot2Configs named slot2ConfigsVoltage
    // TODO: Robbie: 22: create a Slot2Configs named slot2ConfigsCurrent
    // TODO: Robbie: 23: create an InputType named inputTypeUsing and initialize to InputType.VOLTAGE


    public CTRECompleteSmartMotor(CTRECompleteSmartMotorConfiguration config) {
        // TODO: Robbie: 24: call super(config)
        super(null);
        // TODO: Robbie: 25: initialize slot2Configs and MotionMagicConfigs from the config argument using the appropriate methods.
    }

    private void handleInputType(InputType inputType) {
        // TODO: Robbie: 24: check if inputType != inputTypeUsing and inputType is InputType.VOLTAGE
        // TODO: Robbie: 25: if true set inputTypeUsing to inputType
        // TODO: Robbie: 26: call motor.getConfigurator().apply() passing in voltageMotionMagicConfigs
        // TODO: Robbie: 27: call motor.getConfigurator().apply() passing in slot2ConfigsVoltage
        // TODO: Robbie: 28: else if inputType != inputTypeUsing && inputType is InputType.CURRENT
        // TODO: Robbie: 29: set inputTypeUsing to inputType
        // TODO: Robbie: 30: call motor.getConfigurator().apply() passing in currentMotionMagicConfigs
        // TODO: Robbie: 31: call motor.getConfigurator().apply() passing in slot2ConfigsCurrent
    }


    @Override
    public void accept(MotorPositionRequest request) {
        // TODO: Robbie: 32: call handleInputType() passing in request.getInputType()
        // TODO: Robbie: 33: write a switch statement with request.getInputType() as its parameter
        // TODO: Robbie: 34: for the VOLTAGE case call handleVoltage(request)
        // TODO: Robbie: 35: for the CURRENT case call handleCurrent(request)
    }

    @Override
    public void accept(MotorVelocityRequest request) {
        // TODO: Robbie: 36: call handleInputType() passing in request.getInputType()
        // TODO: Robbie: 37: write a switch statement with request.getInputType() as its parameter
        // TODO: Robbie: 38: for the VOLTAGE case call handleVoltage(request)
        // TODO: Robbie: 39: for the CURRENT case call handleCurrent(request)
    }

    private void handleVoltage(MotorPositionRequest request) {
        // TODO: Robbie: 40: write a switch statement with request.getProfileType() as its parameter.
        // TODO: Robbie: 41: for the NONE case call motor.setControl(positionVoltage.withPosition(request.getPosition());
        // TODO: Robbie: 42: for the TRAPEZOID cases call call motor.setControl(motionMagicVoltage.withPosition(request.getPosition());
        // TODO: Robbie: 43: for the EXPONENTIAL cases call call motor.setControl(motionMagicExpoVoltage.withPosition(request.getPosition());
    }

    private void handleVoltage(MotorVelocityRequest request) {
        // TODO: Robbie: 44: write a switch statement with request.getProfileType() as its parameter.
        // TODO: Robbie: 45: for the NONE case call motor.setControl(velocityVoltage.withVelocity(request.getVelocity());
        // TODO: Robbie: 46: for the TRAPEZOID, EXPONENTIAL cases call call motor.setControl(motionMagicVelocityVoltage.withVelocity(request.getVelocity());
    }

    private void handleCurrent(MotorPositionRequest request) {
        // TODO: Robbie: 47: write a switch statement with request.getProfileType() as its parameter.
        // TODO: Robbie: 48: for the NONE case call motor.setControl(positionTorqueCurrentFOC.withPosition(request.getPosition());
        // TODO: Robbie: 49: for the TRAPEZOID cases call call motor.setControl(motionMagicTorqueCurrentFOC.withPosition(request.getPosition());
        // TODO: Robbie: 50: for the EXPONENTIAL cases call call motor.setControl(motionMagicExpoTorqueCurrentFOC.withPosition(request.getPosition());
    }

    private void handleCurrent(MotorVelocityRequest request) {
        // TODO: Robbie: 51: write a switch statement with request.getProfileType() as its parameter.
        // TODO: Robbie: 52: for the NONE case call motor.setControl(velocityTorqueCurrentFOC.withVelocity(request.getVelocity());
        // TODO: Robbie: 53: for the TRAPEZOID, EXPONENTIAL cases call call motor.setControl(motionMagicVelocityTorqueCurrentFOC.withVelocity(request.getVelocity());
    }


}
