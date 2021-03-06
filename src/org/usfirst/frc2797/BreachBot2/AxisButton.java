package org.usfirst.frc2797.BreachBot2;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

//All credit goes to FRC1515 and /u/voidpigeon for helping me out with this and writing the code.

public class AxisButton extends Button {

	Joystick joystick;
	int axis;
	double pressThreshold;
	double releaseThreshold;
	int reverseFactor;
	boolean wasPressed;

	public AxisButton(Joystick joystick, int axis, double pressThreshold, double releaseThreshold, boolean reverse) {
		this.joystick = joystick;
		this.axis = axis;
		this.reverseFactor = reverse ? -1 : 1;
		this.pressThreshold = pressThreshold * reverseFactor;
		this.releaseThreshold = releaseThreshold * reverseFactor;
		this.wasPressed = false;
	}

	public AxisButton(Joystick joystick, int axis, double pressThreshold, double releaseThreshold) {
		this(joystick, axis, pressThreshold, releaseThreshold, false);
	}

	@Override
	public boolean get() {
		double threshold = wasPressed ? releaseThreshold : pressThreshold;
		wasPressed = reverseFactor * joystick.getRawAxis(axis) > threshold;
		return wasPressed;
	}

}
