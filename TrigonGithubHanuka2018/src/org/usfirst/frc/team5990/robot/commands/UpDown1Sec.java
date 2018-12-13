package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;
import org.usfirst.frc.team5990.robot.subsystems.Parallelogram;
import org.usfirst.frc.team5990.robot.commands.ParalellogramReachHeight;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class UpDown1Sec extends CommandGroup {

	public UpDown1Sec() {
		requires(Robot.parallelogram);

		// Add Commands here:
		//executes 3 commands one after the other
		addSequential(new ParalellogramReachHeight(ParalellogramSetHeight.Height.kUp));
		addSequential(new WaitCommand(1));
		addSequential(new ParalellogramReachHeight(ParalellogramSetHeight.Height.kDown));
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}
}
