package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;
import frc.robot.pilot.commands.pilotCmds;

public class drivetrainCmds {
    // default command - runs at all times
    public static void setupDefaultCommand() {
        Robot.drivetrain.setDefaultCommand(pilotCmds.throttleDrive());
    }

    // quick test command
    public static Command testMotorCmd() {
        return new RunCommand(() -> Robot.drivetrain.move(0.5, 0.5), Robot.drivetrain)
            .withTimeout(2);
    }
}
