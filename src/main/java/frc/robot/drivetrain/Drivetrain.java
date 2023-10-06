package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConfig;

public class Drivetrain extends SubsystemBase {
    private WPI_TalonFX leftFront, leftBack, rightFront, rightBack;

    // Constructor - sets up some things
    public Drivetrain() {
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

    public void move(float leftSpeed, float rightSpeed) {
    // output ^      ^ input
        leftFront.set(leftSpeed);
        // [left Back]
        rightFront.set(rightSpeed);
        // [right Back]
    }

    // turn + speed function here
}
