package frc.robot.drivetrain.commands;

import frc.robot.Robot;
import frc.robot.pilot.commands.PilotGamepadCmds;

public class DrivetrainCmds {
    // set default command for the drivetrain subsystem to be:
    // tankDrive by pilot gamepad
    public static void setupDefaultCommand() {
        Robot.drivetrain.setDefaultCommand(PilotGamepadCmds.tankDrive());
    }
}
