package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;
import frc.robot.pilot.commands.pilotCmds;

public class drivetrainCmds {
    // default command - runs at all times
    public static void setupDefaultCommand() {
        Robot.drivetrain.setDefaultCommand(new drivetrainByPilotCmd());
    }

    // quick test command
    public static Command testMotorCmd() {
        return new RunCommand(                      // Command (runs forever) ...
            () -> Robot.drivetrain.move(0.5, 0.5),  // Function (moves motors at 0.5 speed)
            Robot.drivetrain)                       // Subsytem required
        .withTimeout(2);                            // ... until 2 seconds runs out
    }
}
