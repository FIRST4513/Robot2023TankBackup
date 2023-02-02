package frc.robot.pilot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class PilotGamepadTelemtry {
    protected ShuffleboardTab tab;
    private PilotGamepad gamepad;

    public PilotGamepadTelemtry(PilotGamepad gamepad) {
        this.gamepad = gamepad;
        tab = Shuffleboard.getTab("Pilot Gamepad");

        tab.addNumber("Left Stick Y", () -> gamepad.getLeftStickY());
        tab.addNumber("Right Stick Y", () -> gamepad.getRightStickY());
        tab.addNumber("Left Trigger", () -> gamepad.getLeftTrigger());
        tab.addNumber("Right Trigger", () -> gamepad.getRightTrigger());
    }
}
