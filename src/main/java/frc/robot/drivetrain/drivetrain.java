// 2 MOTOR DRIVETRAIN OPTIMIZED + NO RIOLOG ERRORS FOR CAN FIRMWARE VERSIONS

package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConfig;

public class drivetrain extends SubsystemBase {
    private WPI_TalonFX left, right;

    // ---------- CONSTRUCTOR ----------

    public drivetrain() {
        // Instantiate the motors; make them exist
        left = new WPI_TalonFX(RobotConfig.Motors.LeftMotorBackID);
        right = new WPI_TalonFX(RobotConfig.Motors.RightMotorBackID);

        // Configure the motors to the factory settings; start fresh
        left.configFactoryDefault();
        right.configFactoryDefault();

        // Set the motors to be inverted or not
        // Constants taken from drivetrainConfig
        left.setInverted(drivetrainConfig.leftInverted);
        right.setInverted(drivetrainConfig.rightInverted);

        // Set the motors to coast or brake
        // Constants taken from drivetrainConfig
        left.setNeutralMode(drivetrainConfig.neutralMode);
        right.setNeutralMode(drivetrainConfig.neutralMode);
    }

    // ---------- SETTER METHODS ----------

    public void stop() {
        // Stop motors
        left.stopMotor();
        right.stopMotor();
    }

    // Takes in a left and right speed
    public void move(double leftSpeed, double rightSpeed) {
    // output ^      ^ input
        // Set left motors to the value given
        left.set(leftSpeed);
        // Set right motors to the value given
        right.set(rightSpeed);
    }

    // Takes in a forward (or backward) speed, and an amount to turn.
    public void arcadeDrive(double forwardSpeed, double turnAmount) {
        // do some magic????
        double leftSpeed = forwardSpeed - (2.0f * (turnAmount/3));
        double rightSpeed = forwardSpeed + (2.0f * (turnAmount/3));

        // Make sure values don't go past one
        // [Optional]
        // Motors can't realistically go past -1 or 1
        leftSpeed = constrainTo1(leftSpeed);
        rightSpeed = constrainTo1(rightSpeed);

        // Call move and give the newly calculated left and right speed
        move(leftSpeed, rightSpeed);
    }

    private double constrainTo1(double input) {
        // define output variable
        double output;
        if (input > 1) {
            output = 1;  // set to 1 if input greater than 1
        } else if (input < -1) {
            output = -1;  // set to -1 if input less than 1
        } else {
            output = input;  // set to input otherwise
        }
        // give back the new value
        return output;
    }

    public double encCountsToInches(double counts) {
        return counts * drivetrainConfig.encoderScale;
    }

    // ---------- GETTER METHODS ----------
    
    public double getLeftSpeed() {
        return left.get();
    }

    public double getRightSpeed() {
        return right.get();
    }

    public double getLeftDistance() {
        return encCountsToInches(left.getSelectedSensorPosition());
    }

    public double getRightDistance() {
        return encCountsToInches(right.getSelectedSensorPosition());
    }
}
