package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConfig;

public class intake extends SubsystemBase{
    public TalonSRX intakeMotor;

    // ---------- CONSTRUCTOR ----------
    
    public intake() {
        intakeMotor = new TalonSRX(RobotConfig.Motors.IntakeMotorBackID);
        configIntakeMotor();
    }

    // ---------- CONFIGURATION METHODS ----------

    // config the motors
    public void configIntakeMotor() {
        intakeMotor.configFactoryDefault();
        intakeMotor.setInverted(intakeConfig.intakeMotorInvert);
    }

    // ---------- SETTER METHODS ----------

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

    // ---------- GETTER METHODS ----------

    public double getIntakeSpeed() {
        return intakeMotor.getMotorOutputPercent();
    }
}
