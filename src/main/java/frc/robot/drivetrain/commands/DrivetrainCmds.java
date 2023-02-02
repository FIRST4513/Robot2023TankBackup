package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;
import frc.robot.pilot.commands.PilotGamepadCmds;

public class DrivetrainCmds {
    // set default command for the drivetrain subsystem to be:
    // tankDrive by pilot gamepad
    public static void setupDefaultCommand() {
        Robot.drivetrain.setDefaultCommand(PilotGamepadCmds.stickDriveTriggerTurn());
    }

    public static Command testMotorCmd() {
        return new RunCommand(() -> Robot.drivetrain.testMotor(), Robot.drivetrain);
    }
}
