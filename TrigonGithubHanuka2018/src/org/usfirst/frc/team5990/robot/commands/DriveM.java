package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;
import org.usfirst.frc.team5990.robot.RobotConstants;
import org.usfirst.frc.team5990.robot.subsystems.DriveTrain_sensors.Side;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveM extends Command {
	//DriveM is a controller for drive train
	
	double Targetdistance, power, offset, integral, previousError, derivative;
	double correction = 0;
	public DriveM (double distance, double speed) {
		requires(Robot.driveTrain);
		this.Targetdistance = distance;
		this.power  = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.offset = Robot.driveTrain_sensors.getRawGyroAngle();
		Robot.driveTrain_sensors.resetEncoders();
	}

//	protected double getAngleOfDriveTrainAdvance() {
//		return Robot.driveTrain_sensors.getGyroAngle();
//	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {	
		double error = this.offset - Robot.driveTrain_sensors.getRawGyroAngle();
		this.integral += error;
		this.derivative = error - this.previousError; 
		double kPCorrection = error * RobotConstants.DRIVE_KP;
		double kICorrection = this.integral * RobotConstants.DRIVE_KI;
		double kDCorrection = derivative * RobotConstants.DRIVE_KD;
		
		this.previousError = error;
		correction = kPCorrection + kICorrection + kDCorrection;
		
		//correction *= (power > 0 ? 1 : -1);
		Robot.driveTrain.arcadeDrive(correction, this.power, false);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Math.abs(Robot.driveTrain_sensors.getDistance(Side.kAvg)) >= this.Targetdistance) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		
	}
}
