/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5990.robot;

import edu.wpi.first.wpilibj.SPI.Port;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int PARALLELOGRAM_MOTOR1 = 6;
	public static final int PARALLELOGRAM_MOTOR2 = 7;

	public static final int PARALLELOGRAM_SOLENOID1 = 0;
	public static final int PARALLELOGRAM_SOLENOID2 = 1;

  	// Collector ports
	public static int COLLECTOR_ROBOT_TOP = 0;
	public static int COLLECTOR_ROBOT_BOTTOM = 1;
	public static int COLLECTOR_SWITCH = 0;
	public static int COLLECTOR_ENCODER_CHANNEL_A = 1;
	public static int COLLECTOR_ENCODER_CHANNEL_B = 2;

	// Collector flip
	public static double TIMEOUT_FLIP = 0.4;
	public static double POWER_TOP_FLIP = -0.3;
	public static double POWER_BOTTOM_FLIP = -0.4;

	// collector output
	public static double TIMEOUT_OUTPUT = 0.5;
	
	// Rumble
	public static double TIMEOUT_RUMBLE = 1;
	public static double RUMBLE_VALUE = 1;
}
