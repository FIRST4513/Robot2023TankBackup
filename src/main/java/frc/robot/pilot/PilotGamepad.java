package frc.robot.pilot;

import frc.lib.gamepads.Gamepad;
import frc.robot.Robot;
import frc.robot.pilot.commands.PilotGamepadCmds;

public class PilotGamepad extends Gamepad {
    private PilotGamepadTelemtry telemetry;

    public PilotGamepad() {
        super("Pilot", PilotGamepadConfig.port);
        //telemetry = new PilotGamepadTelemetry(this);
        setupTeleopButtons();
        setupDisabledButtons();
        setupTestButtons();

        telemetry = new PilotGamepadTelemtry(this);  // or this

        System.out.println("Pilot Gamepad created");
    }

    public void setupTeleopButtons() {
        gamepad.yButton.onTrue(PilotGamepadCmds.resetGyroCmd());
    }

    public void setupDisabledButtons() {
    }

    public void setupTestButtons() {
    }

    private double applyDeadzone(double input) {
        double output;
        if (Math.abs(input) > PilotGamepadConfig.joyDeadzone) {
            output = input;
        } else {
            output = 0.0f;
        }
        return output;
    }

    private double applyDeadzone(double input, double deadzone) {
        double output;
        if (Math.abs(input) > deadzone) {
            output = input;
        } else {
            output = 0.0f;
        }
        return output;
    }

    public double getLeftStickY() {
        return applyDeadzone(this.gamepad.leftStick.getY());
    }

    public double getLeftStickX() {
        return applyDeadzone(this.gamepad.leftStick.getX());
    }

    public double getRightStickY() {
        return applyDeadzone(this.gamepad.rightStick.getY());
    }

    public double getRightStickX() {
        return applyDeadzone(this.gamepad.rightStick.getX());
    }

    public double getLeftTrigger() {
        double leftTrigger = this.gamepad.leftTriggerButton.getAxis();
        leftTrigger = applyDeadzone(leftTrigger, 0.1);
        return leftTrigger;
    }

    public double getRightTrigger() {
        double rightTrigger = this.gamepad.rightTriggerButton.getAxis();
        rightTrigger = applyDeadzone(rightTrigger, 0.1);
        return rightTrigger;
    }

    public double getTriggerDrifference() {
        double leftTrigger = getLeftTrigger();
        double rightTrigger = getRightTrigger();
        double diff = leftTrigger - rightTrigger;
        return diff;
    }

    public void rumble(double intensity) {
        this.gamepad.setRumble(intensity, intensity);
    }
}
