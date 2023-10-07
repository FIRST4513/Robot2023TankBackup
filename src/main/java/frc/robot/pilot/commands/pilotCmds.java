package frc.robot.pilot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;

public class pilotCmds {
    public static Command throttleDrive() {
        return new RunCommand(                    // command
            () -> Robot.drivetrain.move(          // function (in this case, move in drivetrain)
                Robot.pilot.getLeftStickY(),    // leftSpeed
                Robot.pilot.getRightStickY()),  // rightSpeed
            Robot.pilot);                         // subsystem doing things, can't have interference
    }
}
