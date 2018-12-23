package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;
import org.usfirst.frc.team5990.robot.RobotConstants;
import org.usfirst.frc.team5990.robot.subsystems.DriveTrain_sensors.Side;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTrainArcDrive2 extends Command {

	private double outerSpeed, innerSpeed;
	private double finalDist;
	private boolean rightArc;
	
    public DriveTrainArcDrive2(double speed, double radius,double angle, boolean rightArc) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.outerSpeed = speed;
    	this.innerSpeed = radius * speed / (radius + RobotConstants.AXLE_LENGTH);
    	this.finalDist = (angle * Math.PI /180) * (2*radius + RobotConstants.AXLE_LENGTH) / 2;
    	//               convert to radians			avg radius
    	this.rightArc = rightArc;
    }
    
    public DriveTrainArcDrive2(double speed, boolean rightArc) {
    	this(speed,RobotConstants.SHORT_RADIOS,90, rightArc);
    	this.rightArc = rightArc;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain_sensors.resetEncoders();
    	if (rightArc) {
    		double x = innerSpeed;
    		innerSpeed = outerSpeed;
    		outerSpeed = x;
    	}
    	// if true switch the innerSpeed and outerSpeed to do arc to the right side
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// drive LEFT
    	Robot.driveTrain.tankDrive(innerSpeed, outerSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       double currentDist = Robot.driveTrain_sensors.getDistance(Side.kAvg);
       if (Math.abs(currentDist - finalDist)<RobotConstants.STOPPING_ERROR)
    	   return true;
       return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
