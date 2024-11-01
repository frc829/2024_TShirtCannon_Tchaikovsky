package com.mechanisms.arms;

import com.control.ClosedLoopParameters;
import com.control.OpenLoopParameters;
import com.control.position.ExponentialProfileParameters;
import com.control.position.TrapezoidProfileParameters;
import com.control.velocity.VelocityProfileParameters;

public class ArmConfiguration {

    /** The gear ratio (reduction) as a ratio of output rotations to input rotations. */
    public double Reduction;

    /** The minimum angle of the arm in radians. */
    // TODO: Corbin - Initialize a double.  It should be public and should be named MinAngle.
    public double MinAngle;
    /** The maximum angle of the arm in radians. */
    // TODO: Corbin - Initialize a double.  It should be public and should be named MaxAngle.
    public double MaxAngle;
    /** The ClosedLoopParameters for position control via voltage. */
    public ClosedLoopParameters PositionClosedLoopVoltageParams = new ClosedLoopParameters();

    /** The ClosedLoopParameters for position control via current. */
    // TODO: Corbin - Initialize a ClosedLoopParameters object.  It should be public and should be named PositionClosedLoopCurrentParams.
    public ClosedLoopParameters PositionClosedLoopCurrentParams = new ClosedLoopParameters();
    /** The ClosedLoopParameters for velocity control via voltage. */
    // TODO: Corbin - Initialize a ClosedLoopParameters object.  It should be public and should be named VelocityClosedLoopVoltageParams.
    public ClosedLoopParameters VelocityClosedLoopVoltageParams = new ClosedLoopParameters();
    /** The OpenLoopParameters for this mechanism via voltage. */
    // TODO: Corbin - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopVoltageParams.
    public OpenLoopParameters OpenLoopVoltageParams = new OpenLoopParameters();
    /** The OpenLoopParameters for this mechanism via current. */
    // TODO: Corbin - Initialize a OpenLoopParameters object.  It should be public and should be named OpenLoopCurrentParams.
    public OpenLoopParameters OpenLoopCurrentParams = new OpenLoopParameters();
    /** The trapezoid profile parameters. */
    // TODO: Corbin - Initialize a TrapezoidProfileParameters object.  It should be public and named TrapProfileParams.
    public TrapezoidProfileParameters TrapProfileParams = new TrapezoidProfileParameters();
    /** The velocity profile parameters.*/
    // TODO: Corbin - Initialize a VelocityProfileParameters object.  It should be public and named VelocityProfileParams.
    public VelocityProfileParameters VelocityProfileParams = new VelocityProfileParameters ();
    /** The exponential profile parameters via voltage. */
    // TODO: Corbin - Initialize an ExponentialProfileParameters object. It should be public and named ExpoProfileVoltageParams.
    public ExponentialProfileParameters ExpoProfileParams = new ExponentialProfileParameters ();
    /** The exponential profile parameters via current. */
    // TODO: Corbin - Initialize an ExponentialProfileParameters object. It should be public and named ExpoProfileCurrentParams.
    public ExponentialProfileParameters ExpoProfileCurrentParams = new ExponentialProfileParameters ();
}
