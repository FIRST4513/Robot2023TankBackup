package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConfig;

public class drivetrain extends SubsystemBase {
    private WPI_TalonFX leftFront, leftBack, rightFront, rightBack;

    // Constructor - sets up some things
    public drivetrain() {
        leftFront = new WPI_TalonFX(RobotConfig.Motors.LeftMotorFrontID);
        leftBack = new WPI_TalonFX(RobotConfig.Motors.LeftMotorBackID);
        rightFront = new WPI_TalonFX(RobotConfig.Motors.RightMotorFrontID);
        rightBack = new WPI_TalonFX(RobotConfig.Motors.RightMotorBackID);

        leftFront.configFactoryDefault();
        leftBack.configFactoryDefault();
        rightFront.configFactoryDefault();
        rightBack.configFactoryDefault();
    }

    public void stop() {
        leftFront.stopMotor();
        leftBack.stopMotor();
        rightFront.stopMotor();
        rightBack.stopMotor();
    }

    public void move(double leftSpeed, double rightSpeed) {
    // output ^      ^ input
        leftFront.set(leftSpeed);
        leftBack.set(leftSpeed);
        rightFront.set(rightSpeed);
        rightBack.set(rightSpeed);
    }

    // turn + speed function here
}
