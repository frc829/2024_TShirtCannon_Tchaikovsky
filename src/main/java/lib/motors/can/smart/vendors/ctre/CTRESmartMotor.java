package lib.motors.can.smart.vendors.ctre;

import lib.motors.control.requests.MotorCurrentRequest;
import lib.motors.control.requests.MotorVoltageRequest;
import lib.VendorType;
import lib.motors.can.smart.SmartMotor;

public abstract class CTRESmartMotor implements SmartMotor {

    // TODO: Corbin: 18: create a TalonFX named motor make it protected and final
    // TODO: Corbin: 19: create a VoltageOut object named voltageOut and intiailize to new VoltageOut(0.0).withEnableFOC(false)
    // make it private and final.
    // TODO: Corbin: 20: create a TorqueCurrentFOC object named torqueCurrentFOC and intialize to new TorqueCurrentFOC(0.0)
    // make it private and final.


    public CTRESmartMotor(CTRESmartMotorConfiguration config) {
        // TODO: Corbin: 21: set motor to new TalonFX(config.getDeviceNumber(), config.getCanbus())
        // TODO: Corbin: 22: call motor's getConfigurator().apply method and pass in config.getTalonFXConfiguration.
    }

    @Override
    public int getCanId() {
        // TODO: Corbin: 23: return motor.getDeviceID()
        return 0; // TODO: remove this placeholder.
    }

    @Override
    public String getCanNetworkName() {
        // TODO: Corbin: 24: return motor.getNetwork()
        return null; // TODO: remove this placeholder.
    }

    @Override
    public VendorType getControlVendorType() {
        // TODO: Corbin: 25: return VendorType.CTRE
        return null; // TODO: remove this placeholder.
    }

    @Override
    public final double getPosition() {
        // TODO: Corbin: 26: return motor.getPosition().getValueAsDouble()
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public final void setPosition(double position) {
        // TODO: Corbin: 27: call motor.setPosition and pass in position
    }

    @Override
    public final double getVelocity() {
        // TODO: Corbin: 28: return motor.getVelocity().getValueAsDouble()
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public double getCurrentAmps() {
        // TODO: Corbin: 29: return motor.getTorqueCurrent().getValueAsDouble()
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public double getVoltageVolts() {
        // TODO: Corbin: 30: return motor.getMotorVoltage().getValueAsDouble()
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public void accept(MotorVoltageRequest request) {
        // TODO: Corbin: 31: call motor.setControl(voltageOut.withOutput(request.getVolts())
    }

    @Override
    public void accept(MotorCurrentRequest request) {
        // TODO: Corbin: 31: call motor.setControl(torqueCurrentFOC.withOutput(request.getCurrentAmps())
    }
}
