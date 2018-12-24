/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5990.robot;

import org.usfirst.frc.team5990.robot.commands.CollectorFlip;
import org.usfirst.frc.team5990.robot.commands.CollectorOut;
import org.usfirst.frc.team5990.robot.commands.CollectorStop;
import org.usfirst.frc.team5990.robot.commands.CollectByJoystick;
import org.usfirst.frc.team5990.robot.commands.CollectIn;
import org.usfirst.frc.team5990.robot.commands.CollectTube;

import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcadeWithPID;
import com.spikes2212.utils.PIDSettings;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	XboxController operatorXbox = new XboxController(2);
	Button AButton = new JoystickButton(operatorXbox, 1);
	Button XButton = new JoystickButton(operatorXbox, 3);
	Button YButton = new JoystickButton(operatorXbox, 4);
	Button BButton = new JoystickButton(operatorXbox, 2);

	Joystick joystick1 = new Joystick(0);
	Button joyTrigger = new JoystickButton(joystick1, 1);

	Joystick joystick2 = new Joystick(1);

	public OI() {

		/*
		 * AButton.whileHeld(new DriveArcadeWithPID( Robot.drivetrain, PIDSource,
		 * setpoint, movement, new PIDSettings( double kP, double kI, double kD, new
		 * DriveArcade), outputRange));
		 */

		AButton.whenPressed(new CollectTube());
		XButton.whenPressed(new CollectorFlip());
		YButton.whenPressed(new CollectorOut(-0.5));
		BButton.whenPressed(new CollectorStop());
	}

	// receives input, returns the adjusted input for better sensitivity
	/*
	 * private double adjustInput(double input){ return input * Math.abs(input); }
	 * 
	 * // returns the adjusted value of the Rotate // switch this to switch between
	 * the 2 drive arcade methods public double getDriverXboxX() { return
	 * adjustInput(driverXbox.getX(Hand.kLeft)); } public double getDriverXboxY() {
	 * return adjustInput(driverXbox.getY(Hand.kLeft)); }
	 */
	public void setRumble(GenericHID.RumbleType type, double value) {
		operatorXbox.setRumble(type, value);
	}

	public Joystick getJoystick1() {
		return joystick1;
	}

	public Joystick getJoystick2() {
		return joystick2;
	}

	public XboxController getOperatorXbox() {
		return operatorXbox;
	}
}
