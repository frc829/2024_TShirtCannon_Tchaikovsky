package lib.motors.can.smart.vendors.ctre.position;

import com.ctre.phoenix6.configs.MotionMagicConfigs;
import lib.motors.can.smart.vendors.ctre.CTRESmartMotorConfiguration;

public class CTREPositionSmartMotorConfiguration extends CTRESmartMotorConfiguration {

    // TODO: Allen: 00: there might be red, this file depends on CTRESmartMotorConfiguration, which may not be done.
    // TODO: Allen: 01: create a Slot0Configs object named slot0Configs and initialize to new Slot0Configs()
    // TODO: Allen: 02: create a Slot1Configs object named slot1Configs and initialize to new Slot1Configs()
    // TODO: Allen: 03: create a MotionMagicConfigs object named motionMagicVoltageConfigs and initialize to new MotionMagicConfigs()
    // TODO: Allen: 04: create a MotionMagicConfigs object named motionMagicCurrentConfigs and intialize to new MotionMagicConfigs()

    public CTREPositionSmartMotorConfiguration(int deviceNumber) {
        // TODO: Allen: 05: call this(deviceNumber, "rio");
        this(0, null); // TODO: remove this placeholder
    }

    public CTREPositionSmartMotorConfiguration(int deviceNumber, String canbus) {
        // TODO: Allen: 06: call super(deviceNumber, canbus)
        super(deviceNumber, canbus);  // TODO: remove this placeholder.
        // TODO: Allen: 07: create a ClosedLoopGeneralConfigs called closedLoopGeneralConfigs and initialize to a new ClosedLoopGeneralConfigs();
        // TODO: Allen: 08: call closedLoopGeneralConfigs ContinuousWrap field and set equal to true;
        // TODO: Allen: 09: call talonFXConfiguration's withClosedLoopGeneral method and pass in closedLoopGeneralConfigs
        // TODO: Allen: 10: call motor.getConfigurator().apply() and pass in talonFXConfiguration.
    }

    public CTREPositionSmartMotorConfiguration withMaxVelocity(double maxVelocity) {
        // TODO: Allen: 11: call motionMagicVoltageConfig's withMotionMagicCruiseVelocity method and pass in maxVelocity
        // TODO: Allen: 12: do the same with motionMagicCurrentConfigs
        // TODO: Allen: 13: call talonFXConfiguration's withMotionMagic method and just pass in the motionMagicVoltageConfigs
        // TODO: Allen: 14: call motor.getConfigurator().apply() and pass in talonFXConfiguration
        // TODO: Allen: 15: return this
        return null; // TODO: remove this placeholder.
    }

    public CTREPositionSmartMotorConfiguration withMaxAcceleration(double maxAcceleration) {
        // TODO: Allen: 16: call motionMagicVoltageConfig's withMotionMagicMaxAcceleration method and pass in maxAcceleration
        // TODO: Allen: 17: do the same with motionMagicCurrentConfigs
        // TODO: Allen: 18: call talonFXConfiguration's withMotionMagic method and just pass in the motionMagicVoltageConfigs
        // TODO: Allen: 19: call motor.getConfigurator().apply() and pass in talonFXConfiguration
        // TODO: Allen: 20: return this
        return null; // TODO: remove this placeholder.
    }

    public CTREPositionSmartMotorConfiguration withMaxJerk(double maxJerk) {
        // TODO: Allen: 21: call motionMagicVoltageConfig's withMotionMagicMaxJerk method and pass in maxJerk
        // TODO: Allen: 22: do the same with motionMagicCurrentConfigs
        // TODO: Allen: 23: call talonFXConfiguration's withMotionMagic method and just pass in the motionMagicVoltageConfigs
        // TODO: Allen: 24: call motor.getConfigurator().apply() and pass in talonFXConfiguration
        // TODO: Allen: 25: return this
        return null; // TODO: remove this placeholder.
    }

    public CTREPositionSmartMotorConfiguration withExpoKvVoltage(double kv) {
        // TODO: Allen: 26: call motionMagicVoltageConfig's withMotionMagicExpo_kV method and pass in kv
        // TODO: Allen: 27: call talonFXConfiguration's withMotionMagic method and just pass in the motionMagicVoltageConfigs
        // TODO: Allen: 28: call motor.getConfigurator().apply() and pass in talonFXConfiguration
        // TODO: Allen: 29: return this
        return null; // TODO: remove this placeholder.
    }

    public CTREPositionSmartMotorConfiguration withExpoKaVoltage(double ka) {
        // TODO: Allen: 30: call motionMagicVoltageConfig's withMotionMagicExpo_kA method and pass in ka
        // TODO: Allen: 31: call talonFXConfiguration's withMotionMagic method and just pass in the motionMagicVoltageConfigs
        // TODO: Allen: 32: call motor.getConfigurator().apply() and pass in talonFXConfiguration
        // TODO: Allen: 33: return this
        return null; // TODO: remove this placeholder.
    }

    public CTREPositionSmartMotorConfiguration withExpoKvCurrent(double kv) {
        // TODO: Allen: 34: call motionMagicCurrentConfigs's withMotionMagicExpo_kV method and pass in kv
        // TODO: Allen: 35: return this
        return null; // TODO: remove this placeholder.
    }

    public CTREPositionSmartMotorConfiguration withExpoKaCurrent(double ka) {
        // TODO: Allen: 36: call motionMagicCurrentConfigs's withMotionMagicExpo_kA method and pass in ka
        // TODO: Allen: 37: return this
        return null; // TODO: remove this placeholder.
    }

    public MotionMagicConfigs getMotionMagicVoltageConfigs() {
        // TODO: Allen: 38: return motionMagicVoltageConfigs
        return null; // TODO: remove this placeholder.
    }

    public MotionMagicConfigs getMotionMagicCurrentConfigs() {
        // TODO: Allen: 39: return motionMagicCurrentConfigs
        return null; // TODO: remove this placeholder.
    }
}
