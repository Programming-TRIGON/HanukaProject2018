package org.usfirst.frc.team5990.robot.subsystems;
import org.usfirst.frc.team5990.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Parallelogram extends Subsystem {

	Talon controller1;
	Talon controller2;
	DigitalInput lowerSwitch;
	DigitalInput upperSwitch;
	//Encoder encoder;
	DoubleSolenoid solenoid; 
	
	public Parallelogram() {
		controller1 = new Talon (RobotMap.PARALLELOGRAM_MOTOR1);
		controller2 = new Talon(RobotMap.PARALLELOGRAM_MOTOR2);
		//lowerSwitch = new DigitalInput(RobotMap.PARALELLOGRAM_SWITCH);
		solenoid = new DoubleSolenoid(RobotMap.PARALLELOGRAM_SOLENOID1, RobotMap.PARALLELOGRAM_SOLENOID2);
		//encoder = new Encoder(RobotMap.PARALELLOGRAM_ENCODER1,RobotMap.PARALELLOGRAM_ENCODER2);
		
	}
	public void setLock(boolean b) {
		if (b)
		solenoid.set(DoubleSolenoid.Value.kForward);
		else
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}
	public void setSpeed(double speed) {
		//this makes the parallelogram move up or down
			controller1.set(speed);
			controller2.set(speed);
		
	}
	public void stop() {
		//this makes the motors stop
		controller1.set(0);
		controller2.set(0);
	}

//	public boolean isDown() {
//		//if the parallelogram is at the ground it returns true
//		return lowerSwitch.get();
//	}
//	public boolean isUp() {
//		//if the parallelogram is up it returns true
//		return upperSwitch.get();
//	}
	
	/*public int getHeight() {
		return encoder.get()/RobotMap.TICKS;
	}*/
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
