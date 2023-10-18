package frc.robot.pilot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;

public class pilotCmds {
    // // Command to drive the robot by left-right stick drive
    // // Controller: Xbox
    // // Left stick: Controls left motors speed
    // // Right stick: Controls right motors speed
    // public static Command LeftRightStickDrive() {
    //     return new RunCommand(                   // Command (runs forever)
    //         () -> Robot.drivetrain.move(         // Function (in this case, move in drivetrain)
    //             Robot.pilot.getLeftStickY(),     // leftSpeed
    //             Robot.pilot.getRightStickY()),   // rightSpeed
    //         Robot.drivetrain);                   // Subsystem doing things, so commands don't clash
    // }

    // // Command to drive thr robot by Stick & Trigger
    // // Controller: Xbox
    // // Left Stick Y: Controls forward/backward speed
    // // Triggers: Controls Rotation amount [Difference]
    // public static Command SpeedRotateTriggerDrive() {
    //     return new RunCommand(                        // Command (runs forever)
    //         () -> Robot.drivetrain.arcadeDrive(       // Function (in this case, arcadeDrive in drivetrain)
    //             Robot.pilot.getLeftStickY(),          // forwardSpeed
    //             Robot.pilot.getTriggerDifference()),  // turnAmount
    //         Robot.drivetrain);                        // Subsystem required
    // }
}
