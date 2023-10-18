package frc.robot.arm.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;

public class armCmds {
    public static void setupDefaultCommand() {
        Robot.arm.setDefaultCommand(stopArmCmd());
    }

    public static Command armByPilotCmd() {
        return new RunCommand(
            () -> Robot.arm.setSpeed(Robot.pilot.getRightStickY()), Robot.arm);
    }

    public static Command stopArmCmd() {
        return new InstantCommand(() -> Robot.arm.stopMotor(), Robot.arm);
    }
}
