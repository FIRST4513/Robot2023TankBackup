package frc.robot.arm;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConfig;

public class arm extends SubsystemBase {
    private TalonSRX armMotor;

    // constructor
    public arm() {
        armMotor = new TalonSRX(RobotConfig.Motors.ArmMotorID);

        armMotor.configFactoryDefault();
    }

    public void setSpeed(double speed) {
        armMotor.set(TalonSRXControlMode.PercentOutput, capSpeedToMax(speed));
    }

    public void stopMotor() {
        setSpeed(0);
    }

    public double capSpeedToMax(double inputSpeed) {
        double output;

        if (inputSpeed > armConfig.maxArmSpeed) {
            output = armConfig.maxArmSpeed;
        } else  if (inputSpeed < -armConfig.maxArmSpeed) {
            output = -armConfig.maxArmSpeed;
        } else {
            output = inputSpeed;
        }

        return output;
    }

    public double getEncoderPosition() {
        return armMotor.getSelectedSensorPosition();
    }

    public double getArmSpeed() {
        return armMotor.getMotorOutputPercent();
    }
}
