package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveArc2 extends CommandGroup {

	/**
	 * Auto command group made to have the robot drive in an arc of the
	 * given radius and angle, at the given speed
	 * @param speed the speed to drive at
	 * @param radius the inner radius
	 * @param angle the angle
	 */
	public DriveArc2(double speed, double radius, double angle, boolean rightArc) {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
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
		if (radius == -1)
			radius = RobotConstants.SHORT_RADIOS;
		if (angle == -1)
			angle = 90;

		addSequential(new DriveTrainArcDrive2(speed, radius, angle, rightArc));
	}
}
