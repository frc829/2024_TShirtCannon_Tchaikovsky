package lib.motors.can.smart.vendors.ctre.velocity;

import lib.motors.can.smart.vendors.ctre.CTRESmartMotorConfiguration;

public class CTREVelocitySmartMotorConfiguration extends CTRESmartMotorConfiguration {

    // TODO: Keith: 00: there might be red, this file depends on CTRESmartMotorConfiguration, which may not be done.
    // TODO: Keith: 01: create a Slot0Configs named slot0Configs and intialize to new Slot0Configs()
    // TODO: Keith: 02: create a Slot1Configs named slot1Configs and intialize to new Slot1Configs()
    // TODO: Keith: 03: create a MotionMagicConfigs named motionMagicConfigs and initialize to a newMotionMagicConfigs()

    public CTREVelocitySmartMotorConfiguration(int deviceNumber) {
        // TODO: Keith: 05: call this(deviceNumber, "rio")
        this(0, null);  // TODO: remove this placeholder.
    }

    public CTREVelocitySmartMotorConfiguration(int deviceNumber, String canbus) {
        // TODO: Keith: 06: call super(deviceNumber, canbus)
        super(0, null);  // TODO: remove this placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKs(double ks) {
        // TODO: Keith: 07: call slot0Configs withKS and pass in the argument.
        // TODO: Keith: 08: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKv(double kv) {
        // TODO: Keith: 09: call slot0Configs withKV and pass in the argument.
        // TODO: Keith: 10: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKa(double ka) {
        // TODO: Keith: 11: call slot0Configs withKA and pass in the argument.
        // TODO: Keith: 12: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKp(double kp) {
        // TODO: Keith: 13: call slot0Configs withKP and pass in the argument.
        // TODO: Keith: 14: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKi(double ki) {
        // TODO: Keith: 15: call slot0Configs withKI and pass in the argument.
        // TODO: Keith: 16: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withVoltageKd(double kd) {
        // TODO: Keith: 17: call slot0Configs withKD and pass in the argument.
        // TODO: Keith: 18: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKs(double ks) {
        // TODO: Keith: 19: call slot1Configs withKS and pass in the argument.
        // TODO: Keith: 20: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKv(double kv) {
        // TODO: Keith: 21: call slot1Configs withKV and pass in the argument.
        // TODO: Keith: 22: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKa(double ka) {
        // TODO: Keith: 23: call slot1Configs withKA and pass in the argument.
        // TODO: Keith: 24: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKp(double kp) {
        // TODO: Keith: 25: call slot1Configs withKP and pass in the argument.
        // TODO: Keith: 26: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKi(double ki) {
        // TODO: Keith: 27: call slot1Configs withKI and pass in the argument.
        // TODO: Keith: 28: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withCurrentKd(double kd) {
        // TODO: Keith: 29: call slot1Configs withKD and pass in the argument.
        // TODO: Keith: 30: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withMaxAcceleration(double maxAcceleration) {
        // TODO: Keith: 31: call motionMagicConfigs withMotionMagicAcceleration method and pass in the argument.
        // TODO: Keith: 32: call talonFXConfiguration's withMotionMagic method and pass in motionMagicConfigs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }

    public CTREVelocitySmartMotorConfiguration withMaxJerk(double maxJerk) {
        // TODO: Keith: 33: call motionMagicConfigs withMotionMagicJerk method and pass in the argument.
        // TODO: Keith: 34: call talonFXConfiguration's withMotionMagic method and pass in motionMagicConfigs
        // TODO: return this;
        return null; // TODO: remove the placeholder.
    }
}
