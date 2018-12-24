package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnAbsDegrees extends Command {

	double heading, power;
	boolean turnLeft;

	public TurnAbsDegrees(double heading, double power, boolean turnLeft) {
		requires(Robot.driveTrain);
		this.heading = heading;
		this.power = power;
		this.turnLeft = turnLeft;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		double angle = Robot.driveTrain_sensors.getGyroAngle();
		/*boolean direction = this.heading - angle > 0;
		System.out.println(direction);
		if (Math.abs(this.heading - angle) < 360 - Math.abs(this.heading - angle)) {
			System.out.println("if");
			power *= direction ? 1 : -1;
		} else {
			System.out.println("else");
			power *= !direction ? 1 : -1;
		} */
		if (turnLeft) 
			power *= -1;
	}

	protected void execute() {
		Robot.driveTrain.tankDrive(power, -power); // might need to be reversed
	}

	protected boolean isFinished() {
		double angle = Robot.driveTrain_sensors.getGyroAngle();
		if (this.heading - 1.5 < angle && angle < this.heading + 1.5)
			return true;
		return false;
	}

	protected void end() {
		Robot.driveTrain.tankDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
