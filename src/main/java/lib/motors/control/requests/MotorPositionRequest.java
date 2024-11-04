package lib.motors.control.requests;

import lib.motors.control.requests.parameters.InputType;
import lib.motors.control.requests.parameters.ProfileType;

public class MotorPositionRequest {

    // TODO: Zavian: 06: create a double called position and make it private.
    // TODO: Zavian: 07: create a ProfileType called profileType and initialize to ProfileType.NONE
    // make it private
    // TODO: Zavian: 08: create an InputType called inputType and initialize to InputType.VOLTAGE
    // make it private

    public MotorPositionRequest withPosition(double position) {
        // TODO: Zavian: 09: set this position to the position argument
        // TODO: return this
        return null; //TODO: Zavian: 10: remove this placeholder.
    }

    public MotorPositionRequest withProfileType(ProfileType profileType) {
        // TODO: Zavian: 11: set this profileType to the profileType argument
        // TODO: return this
        return null; //TODO: Zavian: 12: remove this placeholder.
    }

    public MotorPositionRequest withInputType(InputType inputType) {
        // TODO: Zavian: 13: set this inputType to the inputType argument
        // TODO: return this
        return null; //TODO: Zavian: 14: remove this placeholder.
    }

    public double getPosition() {
        // TODO: Zavian: 15: simply return the position
        return 0.0; // TODO: Zavian: 16: remove this placeholder.
    }

    public ProfileType getProfileType() {
        // TODO: Zavian: 17: simply return the profileType
        return null; // TODO: Zavian: 18: remove this placeholder.
    }

    public InputType getInputType() {
        // TODO: Zavian: 19: simply return the inputType
        return null; // TODO: Zavian: 20: remove this placeholder.
    }
}
