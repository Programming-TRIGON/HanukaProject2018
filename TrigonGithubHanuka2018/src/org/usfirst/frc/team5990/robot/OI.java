/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5990.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	boolean driveBackwards;
	boolean childLocked = false;
	XboxController driveStick = new XboxController(0);

	public OI() {
		driveBackwards=false;
	}
	
	//child lock:
	public boolean isChildLocked() {
		return childLocked;
	}

	public void setChildLocked(boolean childLocked) {
		this.childLocked = childLocked;
	}

	public double getXboxX(Hand hand){
		return driveStick.getX(hand);
	}
	
	public double getXboxY(Hand hand){
		return driveStick.getY(hand);
	}

	public boolean isDriveBackwards() {
		return driveBackwards;
	}
	
	public void toggleBackwardsDriving() {
		driveBackwards = !driveBackwards;
	}
}
