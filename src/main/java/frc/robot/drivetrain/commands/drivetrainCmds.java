package frc.robot.drivetrain.commands;

import javax.swing.text.DefaultFormatterFactory;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;
import frc.robot.drivetrain.drivetrain;
import frc.robot.pilot.commands.pilotCmds;
public class drivetrainCmds {
    // default command - runs at all times
    public static void setupDefaultCommand() {
        Robot.drivetrain.setDefaultCommand(new drivetrainByPilotCmd());
    }

    public static Command stopDrivetrainCmd() {
        return new InstantCommand(() -> Robot.drivetrain.stop(), Robot.drivetrain);
    }
}
