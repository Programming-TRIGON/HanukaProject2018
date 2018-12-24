/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5990.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	XboxController operatorXbox = new XboxController(0);
	Button AButton, XButton, YButton, BButton;

	public OI() {
		AButton = new JoystickButton(operatorXbox, 1);
		XButton = new JoystickButton(operatorXbox, 3);
		YButton = new JoystickButton(operatorXbox, 4);
		BButton = new JoystickButton(operatorXbox, 2);
	}

	public double getXboxX(Hand hand) {
		return operatorXbox.getX(hand);
	}

	public double getXboxY(Hand hand) {
		return operatorXbox.getY(hand);
	}
}
