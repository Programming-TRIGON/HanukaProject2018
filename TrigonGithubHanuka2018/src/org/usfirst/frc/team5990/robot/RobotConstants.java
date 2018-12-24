package org.usfirst.frc.team5990.robot;

public class RobotConstants {
	


	public static double ROBOT_LENGTH = 87;
	
	//Cube Collector Constants:
	public static double CUBE_INTAKE_POWER = 0.5;
	public static double CUBE_EJECT_POWER = -1;
	
	//Drive PID constants:
	public static double DRIVE_KP = 0.08;
	public static double DRIVE_KI = 0.0;
	public static double DRIVE_KD = 1.0;
	 
	//TurnHome PID constans:
	public static double TURN_HOME_KP = 0.08;
	public static double TURN_HOME_KI = 0.0;
	public static double TURN_HOME_KD = 1.0;
	
	//Chassis constants:
	public static double AXLE_LENGTH = 70.5;
	public static double WHEEL_DIAMETER = 6 * 2.54;
	
	//lift
	public static double TIMING_DIAMETER = 2.6 * 2.54;
	public static double COLLECTOR_HEIGHT = 22;
	
	public static double LIFT_LEVEL_1 = 22;
	public static double LIFT_LEVEL_2 = 22;
	public static double LIFT_LEVEL_3 = 70;
	public static double LIFT_LEVEL_4 = 170;
	
	public static int LIFT_INCREMENT = 200; // amount of tick to increase lift position with POV switch
	
	
	//radios 
	public static double LONG_RADIOS = 142;
	public static double SHORT_RADIOS = 71.5;
	
	// allowed errors
	public static final double STOPPING_ERROR = 2;
	
	public static String dataStr = "";

	public static boolean switchAtRight;
	
	public static double childLockMax = 0.4;
	
	
}
