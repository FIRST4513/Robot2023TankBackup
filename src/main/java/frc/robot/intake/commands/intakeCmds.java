package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;

public class intakeCmds {
    public static void setupDefaultCommand() {
        Robot.intake.setDefaultCommand(intakeByCoPilotCmd());
    }

    public static Command stopIntakeCmd() {
        return new InstantCommand(() -> Robot.intake.stopMotor(), Robot.intake);
    }

    public static Command intakeRetractCmd() {
        return new RunCommand(() -> Robot.intake.setSpeedRetract(), Robot.intake);
    }

    public static Command intakeEjectCmd() {
        return new RunCommand(() -> Robot.intake.setSpeedEject(), Robot.intake);
    }

    public static Command intakeHoldCmd() {
        return new RunCommand(() -> Robot.intake.setSpeedHold(), Robot.intake);
    }

    public static Command intakeByCoPilotCmd() {
        return new RunCommand(() -> Robot.intake.setSpeed(Robot.copilot.getTriggerDifferenceInvert()), Robot.intake);
    }
}
