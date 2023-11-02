package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.drivetrain.commands.drivetrainCmds;
import frc.robot.intake.commands.intakeCmds;

public class AutoCmds {
    public static Command EjectOnlyCmd() {
        return new RunCommand(
            () -> Robot.intake.setSpeedEject(),
            Robot.intake)
        .withTimeout(0.5);
    }

    public static Command CrossOnlyCmd() {
        return new RunCommand(
            () -> Robot.drivetrain.move(0.5, 0.5),
            Robot.drivetrain)
        .withTimeout(2.0);
    }

    public static Command EjectAndCrossCmd() {
        return new SequentialCommandGroup(
            EjectOnlyCmd(),
            intakeCmds.stopIntakeCmd(),
            CrossOnlyCmd(),
            drivetrainCmds.stopDrivetrainCmd()
        );
    }
}