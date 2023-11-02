package frc.robot.arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConfig;

public class arm extends SubsystemBase {
    private TalonSRX armMotor;

    private armSRXMotorConfig motorConfig;

    public double currentEncCount = 0.0;
    public double currentArmAngle = 0.0;
    public double currentArmPower = 0.0;

    public double targetArmAngle = armConfig.armStowAngle;

    // ---------- CONSTRUCTOR ----------
    public arm() {
        motorConfig = new armSRXMotorConfig();
        armMotor = new TalonSRX(RobotConfig.Motors.ArmMotorID);
        configArmMotor();
        stopMotor();
    }

    public void periodic() {
        updateCurrentArmAngle();
        driveMotorByMM();
        currentArmPower = armMotor.getMotorOutputPercent();
    }

    public void adjustTargetAngle(double angle) {
        setMMAngle(currentArmAngle - angle);
    }

    public void configArmMotor() {
        armMotor.configFactoryDefault();
        armMotor.configAllSettings(armSRXMotorConfig.config);
        armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        armMotor.configForwardSoftLimitThreshold(encAngleToCounts(armConfig.armExtendLimit));
        armMotor.configReverseSoftLimitThreshold(encAngleToCounts(armConfig.armRetractLimit));
    }

    public void updateCurrentArmAngle() {
        currentEncCount = armMotor.getSelectedSensorPosition();
        currentArmAngle = encCountsToAngle(currentEncCount);
    }

    public double getArmTargetAngle() {
        return targetArmAngle;
    }

    public double getArmCurrentAngle() {
        return currentArmAngle;
    }

    public boolean isAtTarget() {
        if (((targetArmAngle-armConfig.isAtTargetError) < currentArmAngle) && (currentArmAngle < (targetArmAngle+armConfig.isAtTargetError))) {
            return true;
        } else {
            return false;
        }
    }

    public double encCountsToAngle(double counts) {
        return (counts - armConfig.encCountOffset) * armConfig.encDegsPerCount;
    }

    public double encAngleToCounts(double angle) {
        return (angle * armConfig.encCountsPerDeg) + armConfig.encCountOffset;
    }

    public void driveMotorByMM() {
        armMotor.set(ControlMode.MotionMagic, encAngleToCounts(targetArmAngle),
                     DemandType.ArbitraryFeedForward, armSRXMotorConfig.feedForwardScaler);
    }

    public void setMMAngle(double newAngle) {
        newAngle = limitTargetAngle(newAngle);
        targetArmAngle = newAngle;
        System.out.println("Setting new angle");
    }

    public double limitTargetAngle(double angle) {
        if (angle < armConfig.armExtendLimit) { angle = armConfig.armExtendLimit; }
        if (angle > armConfig.armRetractLimit) { angle = armConfig.armRetractLimit; }
        return angle;
    }

    public void setSpeed(double speed) {
        armMotor.set(TalonSRXControlMode.PercentOutput, speed);
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
