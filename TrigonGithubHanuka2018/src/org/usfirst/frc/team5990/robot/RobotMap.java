
package org.usfirst.frc.team5990.robot;

import edu.wpi.first.wpilibj.SPI.Port;

public class RobotMap {
	
	//Drive Train ports
	public static int DRIVE_ENCODER_LEFT_A = 0; // Blue
	public static int DRIVE_ENCODER_LEFT_B = 1; // Yellow
	public static int DRIVE_ENCODER_RIGHT_A = 2;
	public static int DRIVE_ENCODER_RIGHT_B = 3;
	
	public static Port DRIVE_GYRO = Port.kOnboardCS0;
	
	public static int DRIVE_MOTOR_LEFT_BACK = 2;
	public static int DRIVE_MOTOR_LEFT_FRONT = 3;
	public static int DRIVE_MOTOR_RIGHT_BACK = 0;
	public static int DRIVE_MOTOR_RIGHT_FRONT = 1;
	
	
	//Cube Collector Port
	public static int CUBE_INTAKE_MOTOR_LEFT = 4;
	public static int CUBE_INTAKE_MOTOR_RIGHT = 5;
	public static int CUBE_INTAKE_SWITCH = 4; //DIO channel
	
	public static int COLLECTOR_SOL_B = 1;
	public static int COLLECTOR_SOL_A = 0;
	
	public static int LEDS_SPIKE = 0; //Relay channel
	//Lift Ports+
	
	public static int LIFT_SWITCH_BOTTOM = 6;
	public static int LIFT_SWITCH_TOP = 9;
	public static int LIFT_MOTOR = 1;	//CAN ID
	public static int LIFT_MOTOR_2 = 3;	//CAN ID
	
	//PCM ports:
	public static int LIFT_SOLENOID_F = 6;
	public static int LIFT_SOLENOID_R = 7;
	
	//Climber ports:
	
	//PWM:
	public static int CLIMB_MOTOR_1 = 6;
	public static int CLIMB_MOTOR_2 = 7;
	public static int CLIMB_MOTOR_ELEVATE = 8;
	
	//DIO:
	public static int CLIMB_SWITCH_LOW = 8;
	public static int CLIMB_SWITCH_HIGH = 7;
	
	//PCM
	public static int PCM = 0;	//CAN bus ID
	
	
	
	
	
}
