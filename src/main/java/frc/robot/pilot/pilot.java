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

    // ---------- GAMEPAD SPECIFIC COMMANDS ----------
    // Function to setup buttons for when the robot is in Teleop mode (used often)
    public void setupTeleopButtons() {
        // Call a command to test motors when the A button is pressed
        this.gamepad.aButton.onTrue(drivetrainCmds.testMotorCmd());
    }

    // Disabled buttons (almost never used)
    public void setupDisabledButtons() {}

    // Test buttons (used when debugging sometimes)
    public void setupTestButtons() {}
    
    // ---------- CUSTOM DRIVE METHODS ----------

    // Method to get: Xbox Left Stick Y
    // Range: [-1 to 1]
    public double getLeftStickY() {
        return this.gamepad.leftStick.getY() * pilotConfig.globalScaler;
    }

    // Method to get: Xbox Right Stick Y
    // Range: [-1 to 1]
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

    // Method to get: Joystick Y
    // Range: [-1 to 1]
    public double getJoyY() {
        return this.gamepad.getY();
    }

    // Method to get: Joystick Twist
    // Range: [-1 to 1]
    public double getJoyTwist() {
        return this.gamepad.getTwist();
    }

    // Method to get: Joystick Throttle
    // Range: [0 to 1]
    public double getJoyThrottle() {
        return this.gamepad.getThrottle();
    }
}
