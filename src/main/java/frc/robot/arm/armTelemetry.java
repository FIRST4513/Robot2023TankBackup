package frc.robot.arm;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Robot;

public class armTelemetry {
    protected ShuffleboardTab tab;

    public armTelemetry(arm arm) {
        tab = Shuffleboard.getTab("Arm");  // get tab for "Arm", making a new one if none exists

        // arm
        tab.addNumber("ARM- Enc Val", () -> Robot.arm.getEncoderPosition());
        tab.addNumber("ARM- Motor Speed", () -> Robot.arm.getArmSpeed());
        tab.addNumber("ARM- angle", () -> Robot.arm.currentArmAngle);
        tab.addNumber("ARM- Taget Angle", () -> Robot.arm.getArmTargetAngle());

        // [extend switch pressed]
        // [retract switch pressed]
    }
}
