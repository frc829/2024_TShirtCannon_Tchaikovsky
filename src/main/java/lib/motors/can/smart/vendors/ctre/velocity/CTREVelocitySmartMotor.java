package lib.motors.can.smart.vendors.ctre.velocity;

import lib.motors.can.smart.vendors.ctre.CTRESmartMotor;
import lib.motors.control.requests.MotorVelocityRequest;
import lib.motors.can.smart.usages.velocity.VelocitySmartMotor;

public class CTREVelocitySmartMotor extends CTRESmartMotor implements VelocitySmartMotor {

    // TODO: Malaika: 00: there might be red, this file depends on CTRESmartMotorConfiguration, which may not be done.
    // TODO: Malaika: 01: create a VelocityVoltage object named velocityVoltage, make it private final and initialize to new VelocityVoltage(0.0).withSlot(0).withEnableFOC(false);
    // TODO: Malaika: 02: create a MotionMagicVelocityVoltage object named motionMagicVelocityVoltage and initialize to a new MotionMagicVelocityVoltage(0.0).withSlot(0).withEnableFOC(false);
    // TODO: Malaika: 03: create a VelocityTorqueCurrentFOC object named velocityTorqueCurrentFOC and initialize to a new VelocityTorqueCurrentFOC(0.0).withSlot(1);
    // TODO: Malaika: 04: create a MotionMagicVelocityTorqueCurrentFOC object named motionMagicVelocityTorqueCurrentFOC and initialize to a new MotionMagicVelocityTorqueCurrentFOC(0.0).withSlot(1).withEnableFOC(true);

    public CTREVelocitySmartMotor(CTREVelocitySmartMotorConfiguration config) {
        // TODO: Malaika: 05: call super(config)
        super(null); // TODO: remove this placeholder.
    }

    @Override
    public void accept(MotorVelocityRequest request) {
        // TODO: Malaika: 06: write a switch statement with request.getInputType() as its parameter.
        // TODO: Malaika: 07: for the VOLTAGE case call handleVoltage(request)
        // TODO: Malaika: 08: for the CURRENT case call handleCurrent(request)
    }

    private void handleVoltage(MotorVelocityRequest request) {
        // TODO: Malaika: 09: write a switch statement with request.getProfileType() as its parameter.
        // TODO: Malaika: 10: for the NONE case call motor.setControl(velocityVoltage.withVelocity(request.getVelocity());
        // TODO: Malaika: 11: for the TRAPEZOID, EXPONENTIAL cases call call motor.setControl(motionMagicVelocityVoltage.withVelocity(request.getVelocity());
    }

    private void handleCurrent(MotorVelocityRequest request) {
        // TODO: Malaika: 12: write a switch statement with request.getProfileType() as its parameter.
        // TODO: Malaika: 13: for the NONE case call motor.setControl(velocityTorqueCurrentFOC.withVelocity(request.getVelocity());
        // TODO: Malaika: 14: for the TRAPEZOID, EXPONENTIAL cases call call motor.setControl(motionMagicVelocityTorqueCurrentFOC.withVelocity(request.getVelocity());
    }


}

