package frc.robot.arm.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;
import frc.robot.arm.armConfig;

public class armCmds {
    public static void setupDefaultCommand() {
        // Robot.arm.setDefaultCommand(stopArmCmd());
    }

    public static Command armByPilotCmd() {
        return new RunCommand(
            () -> Robot.arm.setSpeed(Robot.pilot.getRightStickY()), Robot.arm)
        .withName("Arm By Pilot Cmd");
    }

    public static Command stopArmCmd() {
        return new InstantCommand(() -> Robot.arm.stopMotor(), Robot.arm)
        .withName("Stop Arm Cmd");
    }

    // positions

    public static Command armToAngleCmd(double angle) {
        return new InstantCommand(() -> Robot.arm.setMMAngle(angle), Robot.arm);
    }

    public static Command armToStowCmd() {
        return new InstantCommand(() -> Robot.arm.setMMAngle(armConfig.armStowAngle), Robot.arm);
    }

    public static Command armToStationCmd() {
        return new InstantCommand(() -> Robot.arm.setMMAngle(armConfig.armStationAngle), Robot.arm);
    }

    public static Command armToGroundCmd() {
        return new InstantCommand(() -> Robot.arm.setMMAngle(armConfig.armGroundAngle), Robot.arm);
    }
}
