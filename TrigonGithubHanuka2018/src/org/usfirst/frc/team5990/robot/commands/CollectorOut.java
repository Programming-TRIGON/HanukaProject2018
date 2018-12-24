package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;
import org.usfirst.frc.team5990.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorOut extends Command {
	
	private double power;
	
    public CollectorOut(double power) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.collector);
    	this.power=power;
    	setTimeout(RobotMap.TIMEOUT_OUTPUT);
    }
    
	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.collector.setBottomMotor(power);
    	Robot.collector.setTopMotor(-power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.collector.setBottomMotor(0);
		Robot.collector.setTopMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
