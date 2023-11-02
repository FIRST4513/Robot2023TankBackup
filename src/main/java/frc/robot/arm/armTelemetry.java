package frc.robot.arm;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Robot;

public class armTelemetry {
    protected ShuffleboardTab tab;

    public armTelemetry(arm arm) {
        // Get shuffleboard tab for name "Arm", and create one if it does not exist
        tab = Shuffleboard.getTab("Arm");

        // Important things
        tab.addNumber("ARM- Target Angle", () -> Robot.arm.getArmTargetAngle()) .withSize(2, 1) .withPosition(0, 0);
        tab.addBoolean("ARM- At Target?", () -> Robot.arm.isAtTarget())         .withSize(2, 1) .withPosition(0, 1);
        tab.addNumber("ARM- Current Angle", () -> Robot.arm.getArmCurrentAngle())    .withSize(2, 1) .withPosition(0, 2);
        
        // Other info
        tab.addNumber("ARM- Enc Val", () -> Robot.arm.getEncoderPosition()) .withSize(2, 1) .withPosition(3, 0);
        tab.addNumber("ARM- Motor Speed", () -> Robot.arm.getArmSpeed())    .withSize(2, 1) .withPosition(3, 1);
    }
}
