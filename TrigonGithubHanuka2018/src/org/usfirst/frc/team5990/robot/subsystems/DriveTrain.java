package org.usfirst.frc.team5990.robot.subsystems;

import org.usfirst.frc.team5990.robot.RobotMap;
import org.usfirst.frc.team5990.robot.commands.DriveXbox;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private VictorSP leftBack, rightBack, leftFront, rightFront;
	private SpeedControllerGroup leftMotorGroup, rightMotorGroup;
	private DifferentialDrive drive;


	public DriveTrain() {
		this.leftBack = new VictorSP (RobotMap.DRIVE_MOTOR_LEFT_BACK);
		this.rightBack = new VictorSP (RobotMap.DRIVE_MOTOR_RIGHT_BACK);
		this.leftFront = new VictorSP (RobotMap.DRIVE_MOTOR_LEFT_FRONT);
		this.rightFront = new VictorSP (RobotMap.DRIVE_MOTOR_RIGHT_FRONT);

		this.leftMotorGroup = new SpeedControllerGroup(leftFront, leftBack);
		this.rightMotorGroup = new SpeedControllerGroup(rightFront, rightBack);

		this.drive = new DifferentialDrive(this.leftMotorGroup, this.rightMotorGroup);
		
		drive.setSafetyEnabled(false);

	}



	public void tankDrive(double leftSpeed, double rightSpeed) {
		this.drive.tankDrive(leftSpeed, rightSpeed);
	}
	public void arcadeDrive(double x, double y, boolean b){
		this.drive.curvatureDrive(y, x, b);
	}


	public void initDefaultCommand() {
		setDefaultCommand(new DriveXbox());
	}
}

