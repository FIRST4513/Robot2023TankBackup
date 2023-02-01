package frc.robot.pilot;

import frc.lib.gamepads.Gamepad;

public class PilotGamepad extends Gamepad {
    public PilotGamepad() {
        super("Pilot", PilotGamepadConfig.port);
        //telemetry = new PilotGamepadTelemetry(this);
        setupTeleopButtons();
        setupDisabledButtons();
        setupTestButtons();

        System.out.println("Pilot Gamepad created");
    }

    public void setupTeleopButtons() {
    }

    public void setupDisabledButtons() {
    }

    public void setupTestButtons() {

    }

    public double getLeftInput() {
        return this.gamepad.leftStick.getY();
    }

    public double getRightInput() {
        return this.gamepad.rightStick.getY();
    }

    public double getRotationInput() {
        return this.gamepad.rightStick.getX();
    }

    public void rumble(double intensity) {
        this.gamepad.setRumble(intensity, intensity);
    }
}
