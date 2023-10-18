package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConfig;

public class intake extends SubsystemBase{
    public TalonSRX intakeMotor;

    // Constructor
    public intake() {
        intakeMotor = new TalonSRX(RobotConfig.Motors.IntakeMotorBackID);
        intakeMotor.configFactoryDefault();
    }

    // setter methods

    public void setSpeed(double speed) {
        intakeMotor.set(TalonSRXControlMode.PercentOutput, speed);
    }

    public void stopMotor() {
        setSpeed(0);
    }

    public void setSpeedRetract() {
        setSpeed(intakeConfig.retractSpeed);
    }

    public void setSpeedHold() {
        setSpeed(intakeConfig.holdSpeed);
    }

    public void setSpeedEject() {
        setSpeed(intakeConfig.ejectSpeed);
    }

    // getter methods

    public double getIntakeSpeed() {
        return intakeMotor.getMotorOutputPercent();
    }
}
