package lib.motors.can.smart.vendors.ctre.complete;

import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot2Configs;
import com.ctre.phoenix6.signals.GravityTypeValue;
import lib.motors.can.smart.vendors.ctre.CTRESmartMotorConfiguration;

public class CTRECompleteSmartMotorConfiguration extends CTRESmartMotorConfiguration {

    // TODO: Angel: 00: there might be red, this file depends on CTRESmartMotorConfiguration, which may not be done.
    // TODO: Angel: 01: create a Slot0Configs named slot0Configs and intialize to new Slot0Configs()
    // TODO: Angel: 02: create a Slot1Configs named slot1Configs and intialize to new Slot1Configs()
    // TODO: Angel: 03: create a Slot2Configs named slot2ConfigsVoltage and intialize to new Slot2Configs()
    // TODO: Angel: 04: create a Slot2Configs named slot2ConfigsCurrent and intialize to new Slot2Configs()
    // TODO: Angel: 05: create a MotionMagicConfigs named motionMagicVoltageConfigs and intialize to new MotionMagicConfigs()
    // TODO: Angel: 06: create a MotionMagicConfigs named motionMagicCurrentConfigs and intialize to new MotionMagicConfigs()


    public CTRECompleteSmartMotorConfiguration(int deviceNumber, GravityTypeValue gravityTypeValue) {
        // TODO: Angel: 07: call this(deviceNumber, "rio", gravityTypeValue)
        this(0, null, null);  // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration(int deviceNumber, String canbus, GravityTypeValue gravityTypeValue) {
        // TODO: Angel: 08: call super(deviceNumber, canbus)
        super(0, null);  // TODO: remove this placeholder.
        // TODO: Angel: 09: call slot0Configs withGravityType and pass in gravityTypeValue
        // TODO: Angel: 10: call slot1Configs withGravityType and pass in gravityTypeValue
        // TODO: Angel: 11: call slot2ConfigsVoltage withGravityType and pass in gravityTypeValue
        // TODO: Angel: 12: call slot2ConfigsCurrent withGravityType and pass in gravityTypeValue
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKs(double ks) {
        // TODO: Angel: 13: call slot0Configs withKS method and pass in the argument
        // TODO: Angel: 14: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKv(double kv) {
        // TODO: Angel: 15: call slot0Configs withKV method and pass in the argument
        // TODO: Angel: 16: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKa(double ka) {
        // TODO: Angel: 17: call slot0Configs withKA method and pass in the argument
        // TODO: Angel: 18: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKp(double kp) {
        // TODO: Angel: 19: call slot0Configs withKP method and pass in the argument
        // TODO: Angel: 20: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKi(double ki) {
        // TODO: Angel: 21: call slot0Configs withKI method and pass in the argument
        // TODO: Angel: 22: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withPositionVoltageKd(double kd) {
        // TODO: Angel: 23: call slot0Configs withKD method and pass in the argument
        // TODO: Angel: 24: call talonFXConfiguration's withSlot0 and pass in slot0Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKs(double ks) {
        // TODO: Angel: 25: call slot1Configs withKP method and pass in the argument
        // TODO: Angel: 26: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKv(double kv) {
        // TODO: Angel: 27: call slot1Configs withKV method and pass in the argument
        // TODO: Angel: 28: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKa(double ka) {
        // TODO: Angel: 29: call slot1Configs withKA method and pass in the argument
        // TODO: Angel: 30: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKp(double kp) {
        // TODO: Angel: 31: call slot1Configs withKP method and pass in the argument
        // TODO: Angel: 32: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKi(double ki) {
        // TODO: Angel: 33: call slot1Configs withKI method and pass in the argument
        // TODO: Angel: 34: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withPositionCurrentKd(double kd) {
        // TODO: Angel: 35: call slot1Configs withKD method and pass in the argument
        // TODO: Angel: 36: call talonFXConfiguration's withSlot1 and pass in slot1Configs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKs(double ks) {
        // TODO: Angel: 37: call slot2ConfigsVoltage withKS method and pass in the argument
        // TODO: Angel: 38: call talonFXConfiguration's withSlot2 and pass in slot2ConfigsVoltage
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKv(double kv) {
        // TODO: Angel: 39: call slot2ConfigsVoltage withKV method and pass in the argument
        // TODO: Angel: 40: call talonFXConfiguration's withSlot2 and pass in slot2ConfigsVoltage
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKa(double ka) {
        // TODO: Angel: 41: call slot2ConfigsVoltage withKA method and pass in the argument
        // TODO: Angel: 42: call talonFXConfiguration's withSlot2 and pass in slot2ConfigsVoltage
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKp(double kp) {
        // TODO: Angel: 43: call slot2ConfigsVoltage withKP method and pass in the argument
        // TODO: Angel: 44: call talonFXConfiguration's withSlot2 and pass in slot2ConfigsVoltage
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKi(double ki) {
        // TODO: Angel: 45: call slot2ConfigsVoltage withKI method and pass in the argument
        // TODO: Angel: 46: call talonFXConfiguration's withSlot2 and pass in slot2ConfigsVoltage
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityVoltageKd(double kd) {
        // TODO: Angel: 47: call slot2ConfigsVoltage withKD method and pass in the argument
        // TODO: Angel: 48: call talonFXConfiguration's withSlot2 and pass in slot2ConfigsVoltage
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKs(double ks) {
        // TODO: Angel: 49: call slot2ConfigsCurrent withKS method and pass in the argument
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKv(double kv) {
        // TODO: Angel: 50: call slot2ConfigsCurrent withKV method and pass in the argument
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKa(double ka) {
        // TODO: Angel: 51: call slot2ConfigsCurrent withKA method and pass in the argument
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKp(double kp) {
        // TODO: Angel: 52: call slot2ConfigsCurrent withKP method and pass in the argument
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKi(double ki) {
        // TODO: Angel: 53: call slot2ConfigsCurrent withKI method and pass in the argument
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withVelocityCurrentKd(double kd) {
        // TODO: Angel: 54: call slot2ConfigsCurrent withKD method and pass in the argument
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withMaxVelocity(double maxVelocity) {
        // TODO: Angel: 55: call motionMagicVoltageConfigs's withMotionMagicCruiseVelocity method and pass in maxVelocity
        // TODO: Angel: 56: repeat motionMagicCurrentConfigs
        // TODO: Angel: 57: call talonFXConfiguration's withMotionMagic method and pass in motionMagicVoltageConfigs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withMaxAcceleration(double maxAcceleration) {
        // TODO: Angel: 58: call motionMagicVoltageConfigs's withMotionMagicAcceleration method and pass in maxAcceleration
        // TODO: Angel: 59: repeat motionMagicCurrentConfigs
        // TODO: Angel: 60: call talonFXConfiguration's withMotionMagic method and pass in motionMagicVoltageConfigs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withMaxJerk(double maxJerk) {
        // TODO: Angel: 61: call motionMagicVoltageConfigs's withMotionMagicJerk method and pass in maxJerk
        // TODO: Angel: 62: repeat motionMagicCurrentConfigs
        // TODO: Angel: 63: call talonFXConfiguration's withMotionMagic method and pass in motionMagicVoltageConfigs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withExpoKvVoltage(double kv) {
        // TODO: Angel: 64: call motionMagicVoltageConfigs's withMotionMagicExpo_kV method and pass in kv
        // TODO: Angel: 65: call talonFXConfiguration's withMotionMagic method and pass in motionMagicVoltageConfigs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withExpoKaVoltage(double ka) {
        // TODO: Angel: 66: call motionMagicVoltageConfigs's withMotionMagicExpo_kA method and pass in ka
        // TODO: Angel: 67: call talonFXConfiguration's withMotionMagic method and pass in motionMagicVoltageConfigs
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withExpoKvCurrent(double kv) {
        // TODO: Angel: 68: call motionMagicCurrentConfigs's withMotionMagicExpo_kV method and pass in kv
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public CTRECompleteSmartMotorConfiguration withExpoKaCurrent(double ka) {
        // TODO: Angel: 69: call motionMagicCurrentConfigs's withMotionMagicExpo_kA method and pass in ka
        // TODO: return this
        return null; // TODO: remove this placeholder.
    }

    public Slot2Configs getSlot2ConfigsVoltage(){
        // TODO: Angel: 70: return slot2ConfigsVoltage
        return null; // TODO: remove this placeholder.
    }

    public Slot2Configs getSlot2ConfigsCurrent(){
        // TODO: Angel: 71: return slot2ConfigsCurrent
        return null; // TODO: remove this placeholder.
    }

    public MotionMagicConfigs getMotionMagicVoltageConfigs() {
        // TODO: Angel: 72: return motionMagicVoltageConfigs
        return null; // TODO: remove this placeholder.
    }

    public MotionMagicConfigs getMotionMagicCurrentConfigs() {
        // TODO: Angel: 73: return motionMagicCurrentConfigs
        return null; // TODO: remove this placeholder.
    }
}
