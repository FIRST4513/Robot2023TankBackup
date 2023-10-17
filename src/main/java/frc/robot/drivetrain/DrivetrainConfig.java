package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;

public class drivetrainConfig {
    // Whether or not to invert the left or right side
    public static boolean leftInverted = false;
    public static boolean rightInverted = true;

    // What type of mode to have the motors coast in
    public static NeutralMode neutralMode = NeutralMode.Brake;
}
