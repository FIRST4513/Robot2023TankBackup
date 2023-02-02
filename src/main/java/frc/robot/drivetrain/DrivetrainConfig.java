package frc.robot.drivetrain;

import frc.robot.RobotConfig;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class DrivetrainConfig {
    public static class LeftMotors {
        public static final String frontMotorName = "Left Front";
        public static final String backMotorName = "Left Back";

        public static final int frontMotorID = RobotConfig.Motors.LeftMotorFrontID;
        public static final int backMotorID = RobotConfig.Motors.LeftMotorBackID;
        
        public static final boolean frontInverted = false;
        public static final boolean backInverted = false;
        
        public static final NeutralMode frontBrakeMode = NeutralMode.Brake;  // default
        public static final NeutralMode backBrakeMode = NeutralMode.Brake;
    }

    public static class RightMotors {
        public static final String frontMotorName = "Right Front";
        public static final String backMotorName = "Right Back";

        public static final int frontMotorID = RobotConfig.Motors.RightMotorFrontID;
        public static final int backMotorID = RobotConfig.Motors.RightMotorBackID;
        
        public static final boolean frontInverted = true;
        public static final boolean backInverted = true;
        
        public static final NeutralMode frontBrakeMode = NeutralMode.Brake;  // default
        public static final NeutralMode backBrakeMode = NeutralMode.Brake;
    }
}
