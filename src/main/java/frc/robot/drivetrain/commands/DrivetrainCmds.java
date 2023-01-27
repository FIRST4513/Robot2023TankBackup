package frc.robot.drivetrain.commands;

import frc.robot.Robot;
import frc.robot.pilot.commands.PilotGamepadCmds;

public class DrivetrainCmds {
    public static void setupDefaultCommand() {
        Robot.drivetrain.setDefaultCommand(PilotGamepadCmds.tankDrive());
    }
}
