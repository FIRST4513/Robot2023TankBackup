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

        leftFront.setInverted(drivetrainConfig.leftInverted);
        leftBack.setInverted(drivetrainConfig.leftInverted);
        rightFront.setInverted(drivetrainConfig.rightInverted);
        rightBack.setInverted(drivetrainConfig.rightInverted);

        leftFront.setNeutralMode(drivetrainConfig.neutralMode);
        leftBack.setNeutralMode(drivetrainConfig.neutralMode);
        rightFront.setNeutralMode(drivetrainConfig.neutralMode);
        rightBack.setNeutralMode(drivetrainConfig.neutralMode);
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

    public void arcadeDrive(double forwardSpeed, double turnAmount) {
        double leftSpeed = forwardSpeed - (2.0f * (turnAmount/3));
        double rightSpeed = forwardSpeed + (2.0f * (turnAmount/3));
        leftSpeed = constrainTo1(leftSpeed);
        rightSpeed = constrainTo1(rightSpeed);

        move(leftSpeed, rightSpeed);
    }

    private double constrainTo1(double input) {
        double output;
        if (input > 1) {
            output = 1;
        } else if (input < -1) {
            output = -1;
        } else {
            output = input;
        }
        return output;
    }

    // turn + speed function here
}
