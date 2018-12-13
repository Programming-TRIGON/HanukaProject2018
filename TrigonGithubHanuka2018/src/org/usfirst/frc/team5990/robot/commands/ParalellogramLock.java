package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ParalellogramLock extends Command {

	boolean lock;
    public ParalellogramLock(boolean b) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.parallelogram);
    	lock=b;
    }

    // Called just before this Command runs the first time
    //locks/unlocks the paralellogram
    protected void initialize() {
    	Robot.parallelogram.setLock(lock);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//always finishes
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
