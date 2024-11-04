package lib.motors.can.followers.vendors.ctre;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import lib.VendorType;
import lib.motors.can.followers.FollowerMotor;

public class CTREFollowerMotor implements FollowerMotor {

    private final TalonFX motor;
    private final int leaderMotorCanId;
    private final String LeaderMotorCanNetwork; 
    private final boolean inverted;

    public CTREFollowerMotor(CTREFollowerMotorConfiguration config) {

        motor = new TalonFX(config.getDeviceNumber(), config.getCanbus());
        leaderMotorCanId = config.getLeaderMotorCanId();
        LeaderMotorCanNetwork = config.getLeaderMotorCanNetwork();
        inverted = config.isInverted();

        motor.getConfigurator().apply(config.getTalonFXConfiguration());
        motor.setControl(new Follower(leaderMotorCanId, inverted));
    }

    @Override
    public int getCanId() {
        return motor.getDeviceID(); 
    }

    @Override
    public String getCanNetworkName() {
        return motor.getNetwork();
    }

    @Override
    public double getPosition() {
        return motor.getPosition().getValueAsDouble();
    }

    @Override
    public void setPosition(double position) {
        motor.setPosition(position);
    }

    @Override
    public double getVelocity() {
        return motor.getVelocity().getValueAsDouble();
    }

    @Override
    public boolean isInvertedFromLeader() {
        return inverted;
    }

    @Override
    public double getCurrentAmps() {
        return motor.getTorqueCurrent().getValueAsDouble();
    }

    @Override
    public double getVoltageVolts() {
        return motor.getMotorVoltage().getValueAsDouble();
    }

    @Override
    public VendorType getControlVendorType() {
        return VendorType.CTRE;
    }

    @Override
    public int getLeaderMotorId() {
        return leaderMotorCanId;
    }

    @Override
    public String getLeaderMotorNetworkName() {
        return LeaderMotorCanNetwork;
    }
}
