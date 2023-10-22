package frc.robot.pilot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;

public class pilotCmds {
    public static Command pilotHaltDrivetrainCmd() {
        return new RunCommand(
            () -> Robot.drivetrain.stop(),
            Robot.drivetrain);
    }
}
