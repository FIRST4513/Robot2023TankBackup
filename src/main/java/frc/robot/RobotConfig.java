package frc.robot;

public final class RobotConfig {
    // Constants Lib requires to be defined
    public static final double loopPeriodSecs = 0.02;
    public static final boolean TUNING_MODE = false;

    // CAN IDs for the motors on the robot
    public final class Motors {
        public static final int LeftMotorFrontID  = 1;  // CAN ID for Talon SRX
        public static final int LeftMotorBackID   = 2;  // CAN ID for Talon SRX
        public static final int RightMotorFrontID = 3;  // CAN ID for Talon SRX
        public static final int RightMotorBackID  = 4;  // CAN ID for Talon SRX

        public static final int IntakeMotorBackID = 5;  // CAN ID for Talon SRX
        public static final int ArmMotorID        = 6;  // CAN ID for Talon SRX
    }

    // Port Numbers for controlers and/or joysticks
    public final class Gamepads {
        public static final int PilotGamepadPort   = 0;  // Port for pilot xbox controller
    }
}
