package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private WPI_TalonFX LeftFront, LeftBack, RightFront, RightBack;

    public Drivetrain() {
        LeftFront = new WPI_TalonFX(DrivetrainConfig.LeftMotors.frontMotorID);
        LeftFront.configFactoryDefault();
        LeftFront.setInverted(DrivetrainConfig.LeftMotors.frontInverted);
        LeftFront.setNeutralMode(DrivetrainConfig.LeftMotors.frontBrakeMode);

        System.out.println("Drivetrain- Left Front made");

        LeftBack = new WPI_TalonFX(DrivetrainConfig.LeftMotors.backMotorID);
        LeftBack.configFactoryDefault();
        LeftBack.setInverted(DrivetrainConfig.LeftMotors.backInverted);
        LeftBack.setNeutralMode(DrivetrainConfig.LeftMotors.backBrakeMode);

       System.out.println("Drivetrain- Left Back made");

        RightFront = new WPI_TalonFX(DrivetrainConfig.RightMotors.frontMotorID);
        RightFront.configFactoryDefault();
        RightFront.setInverted(DrivetrainConfig.RightMotors.frontInverted);
        RightFront.setNeutralMode(DrivetrainConfig.RightMotors.frontBrakeMode);

        System.out.println("Drivetrain- Right Front made");

        RightBack = new WPI_TalonFX(DrivetrainConfig.RightMotors.backMotorID);
        RightBack.configFactoryDefault();
        RightBack.setInverted(DrivetrainConfig.RightMotors.backInverted);
        RightBack.setNeutralMode(DrivetrainConfig.RightMotors.backBrakeMode);

        System.out.println("Drivetrain- Right Back made");
    }

    public void tankDriveAbs(double leftSpeed, double rightSpeed) {
        LeftFront.set(leftSpeed);
        LeftBack.set(leftSpeed);
        RightFront.set(rightSpeed);
        RightBack.set(rightSpeed);
    }

    public void stop() {
        tankDriveAbs(0, 0);
    }
}
