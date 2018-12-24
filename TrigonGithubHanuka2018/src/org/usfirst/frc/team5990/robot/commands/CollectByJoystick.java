package org.usfirst.frc.team5990.robot.commands;

import java.text.Collator;

import org.usfirst.frc.team5990.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectByJoystick extends Command {

	private Joystick Joystick, Joystick2;
	private XboxController operatorXbox;
    private boolean isXbox;
    double epsilon = 0.01;
	
	public CollectByJoystick(Joystick Joystick, Joystick Joystick2) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.collector);
    	this.Joystick2=Joystick;
    	this.Joystick=Joystick2;
    }

	public CollectByJoystick(XboxController xboxController) {
		 // Use requires() here to declare subsystem dependencies
    	requires(Robot.collector);
    	this.operatorXbox=xboxController;
	}
	
    // Called just before this Command runs the first time
    protected void initialize() {
    	this.isXbox = this.operatorXbox!=null ? true : false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isXbox) {
    		
    		double topPower = operatorXbox.getY(Hand.kRight);
    		double bottomPower = operatorXbox.getY(Hand.kLeft);
    		Robot.collector.setTopMotor(Math.abs(topPower)>epsilon? topPower:0);
    		Robot.collector.setBottomMotor(Math.abs(bottomPower)>epsilon? bottomPower:0);
    	} else {
    		Robot.collector.setTopMotor(Joystick.getY());
    		Robot.collector.setBottomMotor(Joystick.getY());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
