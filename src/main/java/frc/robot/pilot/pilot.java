package frc.robot.pilot;

import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.lib.gamepads.Gamepad;
import frc.robot.Robot;
import frc.robot.RobotConfig;
import frc.robot.arm.commands.armCmds;
import frc.robot.drivetrain.commands.drivetrainCmds;
import frc.robot.intake.commands.intakeCmds;

public class pilot extends Gamepad {
    // Constructor: Sets up gamepad to be used
    public pilot() {
        // Since we are extending (taking code from Gamepad) (also called Inheritance)
        // We need to call the pilot() function in the Gamepad libraries with super.
        // Further sets up the pilot gamepad
        super("Pilot Gamepad", RobotConfig.Gamepads.PilotGamepadPort);
    }

    // ---------- GAMEPAD SPECIFIC COMMANDS ----------
    // Function to setup buttons for when the robot is in Teleop mode (used often)
    public void setupTeleopButtons() {
        // intake stuff
        gamepad.leftBumper.whileTrue(intakeCmds.intakeEjectCmd());
        gamepad.rightBumper.whileTrue(intakeCmds.intakeRetractCmd());
        gamepad.yButton.whileTrue(intakeCmds.intakeHoldCmd());
        // gamepad.xButton.onTrue(intakeCmds.stopIntakeCmd());

        // arm stuff
        gamepad.aButton.whileTrue(armCmds.armByPilotCmd());
    }

    // Disabled buttons (almost never used)
    public void setupDisabledButtons() {}

    // Test buttons (used when debugging sometimes)
    public void setupTestButtons() {}
    
    // ---------- CUSTOM DRIVE METHODS ----------

    // Method to get: Xbox Left Stick Y
    // Range: [(-1 to 1) * scaler]
    public double getLeftStickY() {
        return this.gamepad.leftStick.getY() * pilotConfig.globalScaler;
    }

    // Method to get: Xbox Right Stick Y
    // Range: [(-1 to 1) * scaler]
    public double getRightStickY() {
        return this.gamepad.rightStick.getY() * pilotConfig.globalScaler;
    }

    // Method to get: Difference between Trigger Values
    // Range: [-1 to 1]
    public double getTriggerDifference() {
        double left = this.gamepad.leftTriggerButton.getAxis();
        double right = this.gamepad.rightTriggerButton.getAxis();
        double difference = right-left;
        return difference;
    }

    public double getTriggerDifferenceScaled() {
        return getTriggerDifference() * pilotConfig.globalScaler;
    }
}
