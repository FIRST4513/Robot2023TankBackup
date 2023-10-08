package frc.robot.pilot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;

public class pilotCmds {
    public static Command LeftRightStickDrive() {
        return new RunCommand(                    // command
            () -> Robot.drivetrain.move(          // function (in this case, move in drivetrain)
                Robot.pilot.getLeftStickY(),    // leftSpeed
                Robot.pilot.getRightStickY()),  // rightSpeed
            Robot.drivetrain);                         // subsystem doing things, can't have interference
    }

    public static Command SpeedRotateTriggerDrive() {
        return new RunCommand(
            () -> Robot.drivetrain.arcadeDrive(
                Robot.pilot.getLeftStickY(),
                Robot.pilot.getTriggerDifference()
            ),
            Robot.drivetrain);
    }
}
