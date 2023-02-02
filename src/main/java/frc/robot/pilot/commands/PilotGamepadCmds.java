package frc.robot.pilot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;
import frc.robot.drivetrain.commands.DrivetrainTankDriveCmd;
import frc.robot.drivetrain.commands.DrivetrainArcadeDriveCmd;

public class PilotGamepadCmds {
    /** Set default command to turn off the rumble */
    public static void setupDefaultCommand() {
        Robot.pilotGamepad.setDefaultCommand(rumblePilotCmd(0));
    }

    // command to drive by left and right stick y values
    public static Command tankDrive() {        
        DoubleSupplier leftPower = () -> Robot.pilotGamepad.getLeftStickY();
        DoubleSupplier rightPower = () -> Robot.pilotGamepad.getRightStickY();
        return new DrivetrainTankDriveCmd(leftPower, rightPower);
    }

    public static Command triggerDriveStickTurn() {
        DoubleSupplier forwardPower = () -> Robot.pilotGamepad.getTriggerDrifference();
        DoubleSupplier turnAmount = () -> Robot.pilotGamepad.getLeftStickX();
        return new DrivetrainArcadeDriveCmd(forwardPower, turnAmount);
    }

    public static Command stickDriveTriggerTurn() {
        DoubleSupplier forwardPower = () -> Robot.pilotGamepad.getLeftStickY();
        DoubleSupplier turnAmount = () -> Robot.pilotGamepad.getTriggerDrifference() * -1;
        return new DrivetrainArcadeDriveCmd(forwardPower, turnAmount);
    }

    /** Command that can be used to rumble the pilot controller */
    public static Command rumblePilotCmd(double intensity) {
        return new RunCommand(() -> Robot.pilotGamepad.rumble(intensity), Robot.pilotGamepad);
    }
}
