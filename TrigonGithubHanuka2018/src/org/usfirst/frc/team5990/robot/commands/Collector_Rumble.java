package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.OI;
import org.usfirst.frc.team5990.robot.Robot;
import org.usfirst.frc.team5990.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Collector_Rumble extends Command {

    public Collector_Rumble() {
        // Use requires() here to declare subsystem dependencies
      setTimeout(RobotMap.TIMEOUT_RUMBLE);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
  
    Robot.oi.setRumble(GenericHID.RumbleType.kLeftRumble, RobotMap.RUMBLE_VALUE);
    	Robot.oi.setRumble(GenericHID.RumbleType.kRightRumble, RobotMap.RUMBLE_VALUE);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.oi.setRumble(GenericHID.RumbleType.kLeftRumble, 0);
    	Robot.oi.setRumble(GenericHID.RumbleType.kRightRumble, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
