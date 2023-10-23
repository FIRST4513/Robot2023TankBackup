package frc.robot.copilot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;

public class copilotCmds {
    public static void setupDefaultCommand() { }

    public static Command haltArmIntakeCmd() {
        return new ParallelCommandGroup(
            new RunCommand(() -> Robot.intake.stopMotor(), Robot.intake),
            new RunCommand(() -> Robot.arm.stopMotor(), Robot.arm)
        );
    }
}
