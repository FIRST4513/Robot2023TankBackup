package frc.robot.drivetrain;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Robot;

public class drivetrainTelemetry {
    protected ShuffleboardTab tab;

    public drivetrainTelemetry(drivetrain drivetrain) {
        tab = Shuffleboard.getTab("Drivetrain");

        // Left side
        tab.addNumber("DRIVETRAIN- Left Speed",    () -> Robot.drivetrain.getLeftSpeed())    .withSize(2, 1) .withPosition(0, 0);
        tab.addNumber("DRIVETRAIN- Left Distance", () -> Robot.drivetrain.getLeftDistance()) .withSize(2, 1) .withPosition(0, 1);

        // Right side
        tab.addNumber("DRIVETRAIN- Right Speed",    () -> Robot.drivetrain.getRightSpeed())    .withSize(2, 1) .withPosition(3, 0);
        tab.addNumber("DRIVETRAIN- Right Distance", () -> Robot.drivetrain.getRightDistance()) .withSize(2, 1) .withPosition(3, 1);
    }
}
