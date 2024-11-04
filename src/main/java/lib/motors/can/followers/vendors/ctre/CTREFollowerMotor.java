package lib.motors.can.followers.vendors.ctre;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import lib.VendorType;
import lib.motors.can.followers.FollowerMotor;

public class CTREFollowerMotor implements FollowerMotor {


    // TODO: Braden: 25: create a TalonFX named motor
    // TODO: Braden: 26: create an int named leaderMotorCanId
    // TODO: Braden: 27: create a String named leaderMotorCanNetwork
    // TODO: Braden: 28: create a boolean named inverted.

    public CTREFollowerMotor(CTREFollowerMotorConfiguration config) {
        // TODO: Braden: 29: initialize all of the fields using config
        // TODO: Braden: 30: call motor.getConfigurator().apply() and pass in config.getTalonFXConfiguration()
        // TODO: Braden: 31: call motor.setControl(new Follower(leaderMotorCanid, inverted)
    }

    @Override
    public int getCanId() {
        // TODO: Braden: 32: return appropriate field
        return 0; // TODO: remove this placeholder.
    }

    @Override
    public String getCanNetworkName() {
        // TODO: Braden: 32: return appropriate field
        return null; // TODO: remove this placeholder.
    }

    @Override
    public double getPosition() {
        // TODO: Braden: 33: return motor.getPosition().getValueAsDouble()
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public void setPosition(double position) {
        // TODO: Braden: 34: call motor.setPosition(position);
    }

    @Override
    public double getVelocity() {
        // TODO: Braden: 35: return motor.getVelocity().getValueAsDouble()
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public boolean isInvertedFromLeader() {
        // TODO: Braden: 36: return appropriate field
        return false; // TODO: remove this placeholder.
    }

    @Override
    public double getCurrentAmps() {
        // TODO: Braden: 37: return motor.getTorqueCurrent().getValueAsDouble();
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public double getVoltageVolts() {
        // TODO: Braden: 38: return motor.getMotorVoltage().getValueAsDouble();
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public VendorType getControlVendorType() {
        // TODO: Braden: 39: return VendorType.CTRE
        return null; // TODO: remove this placeholder.
    }

    @Override
    public int getLeaderMotorId() {
        // TODO: Braden: 40: return appropriate field
        return 0; // TODO: remove this placeholder.
    }

    @Override
    public String getLeaderMotorNetworkName() {
        // TODO: Braden: 41: return appropriate field
        return null; // TODO: remove this placeholder.
    }
}
