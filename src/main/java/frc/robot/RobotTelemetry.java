package frc.robot;

import frc.lib.telemetry.TelemetrySubsystem;
import frc.robot.arm.armTelemetry;
import frc.robot.drivetrain.drivetrainTelemetry;

public class RobotTelemetry extends TelemetrySubsystem{
    // Subsystem Telemetries
    public static drivetrainTelemetry _drivetrainTelemetry;
    public static armTelemetry        _armTelemetry;
    // public static intakeTelemetry    _intakeTelemetry;

    // Constructor
    public RobotTelemetry() {
        // Call Super's constructor
        super("Robot");  // sets tab name to "Robot"

        layoutRobotTab();  // fill "Robot" tab with data about the general robot

        // setup other Shuffleboard Tabs
        _armTelemetry = new armTelemetry(Robot.arm);
    }

    public void layoutRobotTab() {
        // setup auto selectors
        // [stuff here]

        // General Robot info
        // drivetrain
        tab.addNumber("DRIVE- Left Speed", () -> Robot.drivetrain.getLeftSpeed());
        tab.addNumber("DRIVE- Right Speed", () -> Robot.drivetrain.getRightSpeed());
        // [distance per second]
        // [rotation º per second]
        // [left driven]
        // [right drive]

        // arm
        tab.addNumber("ARM- Enc Val", () -> Robot.arm.getEncoderPosition());
        tab.addNumber("ARM- Motor Speed", () -> Robot.arm.getArmSpeed());
        // [arm angle]

        // intake
        tab.addNumber("INTAKE- Motor Speed", () -> Robot.intake.getIntakeSpeed());
        // [whether: intaking/expelling/stopped]
    }
}
