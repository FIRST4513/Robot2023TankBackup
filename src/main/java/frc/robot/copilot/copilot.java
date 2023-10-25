package frc.robot.copilot;

import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.lib.gamepads.Gamepad;
import frc.robot.Robot;
import frc.robot.RobotConfig;
import frc.robot.arm.commands.armCmds;
import frc.robot.copilot.commands.copilotCmds;
import frc.robot.drivetrain.commands.drivetrainCmds;
import frc.robot.intake.commands.intakeCmds;

public class copilot extends Gamepad {
    
    // ---------- CONSTRUCTOR ----------

    public copilot() {
        super("Co-Pilot Gamepad", RobotConfig.Gamepads.CopilotGamepadPort);
    }

    // ---------- GAMEPAD SPECIFIC COMMANDS ----------

    // Function to setup buttons for when the robot is in Teleop mode (used often)
    public void setupTeleopButtons() {
        // buttons to manually halt arm & intake
        this.gamepad.rightBumper.whileTrue(copilotCmds.haltArmIntakeCmd());
        
        // preset position buttons - determined by Isaac
        this.gamepad.xButton.onTrue(armCmds.armToStowCmd());
        this.gamepad.yButton.onTrue(armCmds.armToStowCmd());
        this.gamepad.bButton.onTrue(armCmds.armToStationCmd());
        this.gamepad.aButton.onTrue(armCmds.armToGroundCmd());
    }

    // Disabled buttons (almost never used)
    public void setupDisabledButtons() {}

    // Test buttons (used when debugging sometimes)
    public void setupTestButtons() {}
    
    // ---------- GETTER METHODS FOR INPUTS ----------

    // Method to get: Xbox Left Stick Y
    // Range: [-1 to 1]
    public double getLeftStickY() {
        return this.gamepad.leftStick.getY();
    }

    // Method to get: Xbox Right Stick Y
    // Range: [-1 to 1]
    public double getRightStickY() {
        return this.gamepad.rightStick.getY();
    }

    // Method to get: Difference between Trigger Values
    // Range: [-1 to 1]
    public double getTriggerDifference() {
        double left = this.gamepad.leftTriggerButton.getAxis();
        double right = this.gamepad.rightTriggerButton.getAxis();
        double difference = right-left;
        return difference;
    }

    public void setRumble(double dum) {
        this.gamepad.setRumble(dum, dum);
    }
}
