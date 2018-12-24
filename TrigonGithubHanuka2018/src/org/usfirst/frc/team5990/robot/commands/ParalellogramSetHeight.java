package org.usfirst.frc.team5990.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ParalellogramSetHeight extends CommandGroup {
	
    public ParalellogramSetHeight(Height h) {
        // Add Commands here:
    	//first unlocks the paralellogram, reaches the desired height and relocks
        addSequential(new ParalellogramLock(false));
        addSequential(new ParalellogramReachHeight(h));
    	addSequential(new ParalellogramLock(true));
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    }
    public enum Height {
		// defines three height conditions
		kDown, kUp, kMiddle
	}
}
