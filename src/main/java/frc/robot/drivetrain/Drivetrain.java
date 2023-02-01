package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    // declare LF, LB, RF, and RB motors as WPI_TalonFX objects
    private WPI_TalonFX LeftFront, LeftBack, RightFront, RightBack;

    // Constructor
    public Drivetrain() {
        // Instantiate and config Left Front motor
        LeftFront = new WPI_TalonFX(DrivetrainConfig.LeftMotors.frontMotorID);
        LeftFront.configFactoryDefault();
        LeftFront.setInverted(DrivetrainConfig.LeftMotors.frontInverted);
        LeftFront.setNeutralMode(DrivetrainConfig.LeftMotors.frontBrakeMode);

        System.out.println("Drivetrain- Left Front made");

        // Instantiate and config Left Back motor
        LeftBack = new WPI_TalonFX(DrivetrainConfig.LeftMotors.backMotorID);
        LeftBack.configFactoryDefault();
        LeftBack.setInverted(DrivetrainConfig.LeftMotors.backInverted);
        LeftBack.setNeutralMode(DrivetrainConfig.LeftMotors.backBrakeMode);

        System.out.println("Drivetrain- Left Back made");

        // Instantiate and config Right Front motor
        RightFront = new WPI_TalonFX(DrivetrainConfig.RightMotors.frontMotorID);
        RightFront.configFactoryDefault();
        RightFront.setInverted(DrivetrainConfig.RightMotors.frontInverted);
        RightFront.setNeutralMode(DrivetrainConfig.RightMotors.frontBrakeMode);

        System.out.println("Drivetrain- Right Front made");

        // Instantiate and config Right Back motor
        RightBack = new WPI_TalonFX(DrivetrainConfig.RightMotors.backMotorID);
        RightBack.configFactoryDefault();
        RightBack.setInverted(DrivetrainConfig.RightMotors.backInverted);
        RightBack.setNeutralMode(DrivetrainConfig.RightMotors.backBrakeMode);

        System.out.println("Drivetrain- Right Back made");
    }

    // method for driving the wheels by tank drive,
    // accepts motor values: -1 to 1
    public void tankDriveAbs(double leftSpeed, double rightSpeed) {
        LeftFront.set(leftSpeed);
        LeftBack.set(leftSpeed);
        RightFront.set(rightSpeed);
        RightBack.set(rightSpeed);
    }

    // stop motors by setting them to 0
    public void stop() {
        tankDriveAbs(0, 0);
    }
}
