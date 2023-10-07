package frc.robot.pilot;

import frc.lib.gamepads.Gamepad;
import frc.robot.RobotConfig;
import frc.robot.drivetrain.commands.drivetrainCmds;

public class pilot extends Gamepad {
    // Constructor: Sets up gamepad to be used
    public pilot() {
        // Since we are extending (taking code from Gamepad) (also called Inheritance)
        // We need to call the pilot() function in the Gamepad libraries with super.
        // Further sets up the pilot gamepad
        super("Pilot Gamepad", RobotConfig.Gamepads.PilotGamepadPort);
    }

    // ----- GAMEPAD SPECIFIC COMMANDS -----
    // Function to setup buttons for when the robot is in Teleop mode (used often)
    public void setupTeleopButtons() {
        this.gamepad.aButton.onTrue(drivetrainCmds.testMotorCmd());
    }

    // Disabled buttons (almost never used)
    public void setupDisabledButtons() {}

    // Test buttons (used when debugging sometimes)
    public void setupTestButtons() {}
    
    // ----- CUSTOM DRIVE METHODS -----
    public double getLeftStickY() {
        return this.gamepad.leftStick.getY();
    }

    public double getRightStickY() {
        return this.gamepad.rightStick.getY();
    }
}
