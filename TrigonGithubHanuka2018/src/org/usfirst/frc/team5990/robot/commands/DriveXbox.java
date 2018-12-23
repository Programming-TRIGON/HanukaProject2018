
package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;
import org.usfirst.frc.team5990.robot.RobotConstants;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveXbox extends Command {

	
	public DriveXbox() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		double x = Robot.oi.getXboxX(Hand.kLeft);
		double y = Robot.oi.getXboxY(Hand.kLeft);
		//double smallAngleFactor = (Math.abs(y) <= 0.50)?0.67:1;
		
		//child lock
		x = Robot.oi.isChildLocked() ? constrain(x) : x;
		y = Robot.oi.isChildLocked() ? constrain(y) : y;
		
		Robot.driveTrain.arcadeDrive(x, -y * (Robot.oi.isDriveBackwards()?-1:1), Math.abs(y) <= 0.50);
		
	}
	
	public double constrain(double num){
		if(num > RobotConstants.childLockMax) return RobotConstants.childLockMax;
		if(num < -RobotConstants.childLockMax) return -RobotConstants.childLockMax;
		return num;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
