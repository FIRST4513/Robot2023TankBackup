package frc.robot;

public final class RobotConfig {
    // Constants Lib requires to be defined
    public static final double loopPeriodSecs = 0.02;
    public static final boolean TUNING_MODE = false;

    // CAN IDs for the motors on the robot
    public final class Motors {
        // Main Motors Drive
        public static final int LeftMotorBackID    = 1;  // CAN ID for Talon FX
        public static final int RightMotorBackID   = 2;  // CAN ID for Talon FX

        // Secondary Motors Drive
        public static final int LeftMotorFrontID   = 3;  // CAN ID for Talon FX
        public static final int RightMotorFrontID  = 4;  // CAN ID for Talon FX

        // Intake and Arm Motors
        public static final int ArmMotorID         = 5;  // CAN ID for Talon SRX
        public static final int IntakeMotorBackID  = 6;  // CAN ID for Talon SRX
    }

    // Port Numbers for Limit Switches (use Digital IO ports)
    public final class Switches {
        public static final int armExtendSwitch    = 0;  // DIO Port # for arm extend (bottom)
        public static final int armRetractSwitch   = 1;  // DIO Port # for arm retract (top)
    }

    // Port Numbers for controlers and/or joysticks
    public final class Gamepads {
        public static final int PilotGamepadPort   = 0;  // Port # for pilot xbox controller
        public static final int CopilotGamepadPort = 1;  // Port # for copilot xbox controller
    }
}