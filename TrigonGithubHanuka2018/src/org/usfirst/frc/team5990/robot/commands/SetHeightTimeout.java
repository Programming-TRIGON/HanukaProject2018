package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetHeightTimeout extends Command {
	// making variables
	double power;

	public SetHeightTimeout(double power) {
		// needs paralellogram ss, defines timeout time 
		requires(Robot.parallelogram);
		setTimeout(Robot.time);
		this.power = power;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// getting unlocked
		Robot.parallelogram.setLock(false);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// the parallelogram goes up
		Robot.parallelogram.setSpeed(power);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		//program stops after parallelogram is unlocked
		Robot.parallelogram.setLock(true);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
