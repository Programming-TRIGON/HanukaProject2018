package org.usfirst.frc.team5990.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * gidon waz hear
 */
public class DriveForward extends CommandGroup {

    public DriveForward(double distance, double power, double t) {
    	setTimeout(t);
        addSequential(new DriveM(distance * 0.9, power));
        addSequential(new SlowDownDrive(distance * 0.1, power));
    }
}
