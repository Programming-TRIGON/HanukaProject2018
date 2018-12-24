package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;
import org.usfirst.frc.team5990.robot.RobotConstants;
import org.usfirst.frc.team5990.robot.subsystems.DriveTrain_sensors.Side;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveArc extends Command {
	double radius, degrees, power, longPower, targetArcDistance;
    public DriveArc(double radius, double degrees, double power) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.radius = radius;
        this.degrees = degrees;
        this.power = power;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double longArc = (radius + RobotConstants.AXLE_LENGTH)* (Math.abs(degrees)*Math.PI/180); 
    	double shortArc = radius*(Math.abs(degrees)*Math.PI/180);
    	double longPower = power * (radius*RobotConstants.AXLE_LENGTH) / radius;
    	targetArcDistance = (longArc + shortArc) / 2;
    	if (degrees < 0) {
    		double x = power;
    		power = longPower;
    		longPower = x;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.driveTrain.tankDrive(longPower, power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.driveTrain_sensors.getDistance(Side.kAvg) >= this.targetArcDistance) {
			return true;
		} 
    	return false;
	}
    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.tankDrive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
