package org.usfirst.frc.team5990.robot.subsystems;

import org.usfirst.frc.team5990.robot.RobotConstants;
import org.usfirst.frc.team5990.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 *
 */
public class DriveTrain_sensors extends Subsystem {

	private ADXRS450_Gyro gyro;
	private Accelerometer accelerometer;
	private Encoder leftEncoder, rightEncoder;
	public DriveTrain_sensors() {
		this.gyro = new ADXRS450_Gyro(RobotMap.DRIVE_GYRO);
		this.accelerometer = new BuiltInAccelerometer(Accelerometer.Range.k2G);

		this.leftEncoder = new Encoder(RobotMap.DRIVE_ENCODER_LEFT_A, RobotMap.DRIVE_ENCODER_LEFT_B);
		this.rightEncoder = new Encoder(RobotMap.DRIVE_ENCODER_RIGHT_A, RobotMap.DRIVE_ENCODER_RIGHT_B);
	}

	public double getAccelerometerY(){
		double a = this.accelerometer.getX()*9.80665;
		if (Math.abs(a) <= 0)
			return 0;
		return a;
	}	

	public double getAccelerometerX(){
		double a = this.accelerometer.getY()*9.80665;
		if (Math.abs(a) <= 0)
			return 0;
		return a;
	}

	public void calibrateGyro(){
		this.gyro.calibrate();
	}
	
	public void resetGyro(){
		this.gyro.reset();
	}
	public void resetEncoders(){
		this.leftEncoder.reset();
		this.rightEncoder.reset();
	}
	public double getDistance(Side side){
		double l = -(this.leftEncoder.getDistance() / 360) * RobotConstants.WHEEL_DIAMETER * Math.PI;
		double r = (this.rightEncoder.getDistance() / 335) * RobotConstants.WHEEL_DIAMETER * Math.PI;
		switch (side){
		case kLeft:
			return l;
		case kRight:
			return r;
		default: // return average of both encoders
			return (l + r) / 2;
		}
	}
	
	public boolean encoderStopped(Side s){
		return s == Side.kLeft ? leftEncoder.getStopped() : rightEncoder.getStopped();
	}
	
	public enum Side{
		kLeft, kRight, kAvg
	}

	public double getGyroAngle(){
		double a = this.gyro.getAngle() % 360;
		if (a>0)
			return a;
		return a + 360;
	}
	
	public double getRawGyroAngle(){
		return this.gyro.getAngle();
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new RecordSensorData());
	}
}

