package org.usfirst.frc.team5990.robot.subsystems;

import org.usfirst.frc.team5990.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DoubleStraps extends Subsystem {

	private Spark collectorMotorTop, collectorMotorBottom;
	private DigitalInput tubeSwitch;
	private Encoder encoder;

	public DoubleStraps() {
		this.collectorMotorTop = new Spark(RobotMap.COLLECTOR_ROBOT_TOP);
		this.collectorMotorBottom = new Spark(RobotMap.COLLECTOR_ROBOT_BOTTOM);
		this.tubeSwitch = new DigitalInput(RobotMap.COLLECTOR_SWITCH);
		this.encoder = new Encoder(RobotMap.COLLECTOR_ENCODER_CHANNEL_A, RobotMap.COLLECTOR_ENCODER_CHANNEL_B);
		collectorMotorTop.setInverted(true);
	}


	public void setTopMotor(double power) {
		collectorMotorTop.set(power);
	}

	public void setBottomMotor(double power) {
		collectorMotorBottom.set(power);
	}

	public boolean getSwitch() {
		return tubeSwitch.get();
	}

	public double getEncoder() {
		return encoder.get();
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	}
}
