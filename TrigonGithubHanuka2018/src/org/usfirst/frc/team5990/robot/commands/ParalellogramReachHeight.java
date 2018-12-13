package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5990.robot.commands.ParalellogramSetHeight;;

/**
 *
 */
public class ParalellogramReachHeight extends Command {
	// defines variables, height = desired height, power = motor speed,
	// startinghHeight = height at start of command
	ParalellogramSetHeight.Height height;
	double power;
	ParalellogramSetHeight.Height startingHeight;
	/*
	 * int middleHeightDown; int middleHeightUp;
	 */

	public ParalellogramReachHeight(ParalellogramSetHeight.Height h) {
		// uses paralellogram ss
		requires(Robot.parallelogram);
		// gets desired height
		height = h;
//		 Use requires() here to declare subsystem dependencies
//		 eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		/*
		 * middleHeightDown = 35; middleHeightUp = 37;
		 */
		// finds height
		/*
		 * if (Robot.paralellogram.isDown()) startingHeight =
		 * ParalellogramSetHeight.Height.kDown; else if (Robot.paralellogram.isUp())
		 * startingHeight = ParalellogramSetHeight.Height.kUp; else startingHeight =
		 * ParalellogramSetHeight.Height.kMiddle; power = 0.2; // initialize power // if
		 * height is down then power is negative if (height ==
		 * ParalellogramSetHeight.Height.kDown) power *= -1;
		 */
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// the command starts running
		Robot.parallelogram.setSpeed(power);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
		// options for end conditions for the command
		// return startingHeight == height
		// || (Robot.paralellogram.isDown() && height ==
		// ParalellogramSetHeight.Height.kDown)
		// || (Robot.paralellogram.isUp() && height ==
		// ParalellogramSetHeight.Height.kUp);
		/*
		 * || height == ParalellogramSetHeight.Height.kMiddle && startingHeight ==
		 * ParalellogramSetHeight.Height.kDown && (Robot.paralellogram.getHeight() >
		 * middleHeightDown - 5 && Robot.paralellogram.getHeight() < middleHeightDown +
		 * 5) || height == ParalellogramSetHeight.Height.kMiddle && startingHeight ==
		 * ParalellogramSetHeight.Height.kUp && (Robot.paralellogram.getHeight() >
		 * middleHeightUp - 5 && Robot.paralellogram.getHeight() < middleHeightUp + 5);
		 */
	}

	// Called once after isFinished returns true
	protected void end() {
		// stops the motors from continuing to move
		Robot.parallelogram.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {

	}

}
