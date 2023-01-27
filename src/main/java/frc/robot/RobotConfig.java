package frc.robot;

public final class RobotConfig {
    public static final double loopPeriodSecs = 0.02;
    public static final boolean TUNING_MODE = false;

    public final class Motors {
        public static final int LeftMotorFrontID  = 1;  // CAN ID for Talon SRX
        public static final int LeftMotorBackID   = 2;  // CAN ID for Talon SRX
        public static final int RightMotorFrontID = 3;  // CAN ID for Talon SRX
        public static final int RightMotorBackID  = 4;  // CAN ID for Talon SRX
    }
}
