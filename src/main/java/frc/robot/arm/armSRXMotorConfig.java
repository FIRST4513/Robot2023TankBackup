package frc.robot.arm;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

public class armSRXMotorConfig {
    // TalonSRX config object
    public static TalonSRXConfiguration config = new TalonSRXConfiguration();

    // Motor control sets
    public static final NeutralMode armDefaultNeutralMode = NeutralMode.Brake;
    public static final boolean armMotorInvert = armConfig.armMotorInvert;
    public static final boolean armEncoderInvert = false;

    // Motor Limits (Degree Angles)
    public static final int armExtendSoftLimitThreshold = armConfig.armExtendLimit;
    public static final int armRetractSoftLimitTrheshold = armConfig.armRetractLimit;

    // Motion Magic Control Loop Constants
    public static final double feedForwardScaler = 0.0;
    public final double motionCruiseVelocity = 3500;
    public final double motionAcceleration = 4000;
    public static final int allowableError = 10;
    public final int motionCurveStrength = 0;

    // PID Loop Constants
    public final double kP = 3.0;
    public final double kI = 0.0;
    public final double kD = 0.0;
    public final double kF = 0.0;
    public final double kIz = 0.0;

    // Current Limiting
    public static final int continuousCurrentLimit = 30;
    public static final int peakCurrentLimit = 40;
    public static final int peakCurrentDuration = 200;
    
    // Voltage Compensation
    public final double voltageCompSaturation = 12;

    // Ramp Rate
    public final double openLoopRamp = 0;
    public final double closedLoopRamp = 0;

    // Motor Characterization Value
    public final double kS = 0;
    public final double kV = 0;
    public final double kA = 0;

    // ---------- CONSTRUCTOR ----------
    public armSRXMotorConfig() {
        config.slot0.kP = kP;
        config.slot0.kI = kI;
        config.slot0.kD = kD;
        config.slot0.kF = kF;
        config.slot0.integralZone               = kIz;
        config.motionCruiseVelocity             = motionCruiseVelocity;
        config.motionAcceleration               = motionAcceleration;
        
        config.openloopRamp                     = openLoopRamp;
        config.closedloopRamp                   = closedLoopRamp;
        config.voltageCompSaturation            = voltageCompSaturation;

        config.continuousCurrentLimit           = continuousCurrentLimit; 
        config.peakCurrentLimit                 = peakCurrentLimit;         
        config.peakCurrentDuration              = peakCurrentDuration;
        config.slot0.allowableClosedloopError   = allowableError;

        config.forwardSoftLimitEnable = false;
        // config.forwardSoftLimitThreshold = Robot.arm.encAngleToCounts(armConfig.armExtendLimit);

        config.reverseSoftLimitEnable = false;
        // config.reverseSoftLimitThreshold = Robot.arm.encAngleToCounts(armConfig.armRetractLimit);
    }
}
