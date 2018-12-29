package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ParalellogramByJoystick extends Command {

	public ParalellogramByJoystick() {
		requires(Robot.parallelogram);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double y = Robot.oi.getXboxY(Hand.kRight);
		if (y < 0.2 && y > -0.2) {
			Robot.parallelogram.stop();
			Robot.parallelogram.setLock(true);
		} else {
			Robot.parallelogram.setLock(false);
			Robot.parallelogram.setSpeed(0.6*y);
		}
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
