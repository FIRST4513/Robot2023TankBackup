package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;

public class tankdriveCmd extends CommandBase {
    // quick test command
    public static Command testMotorCmd() {
        return new RunCommand(() -> Robot.drivetrain), null);
    }
}
