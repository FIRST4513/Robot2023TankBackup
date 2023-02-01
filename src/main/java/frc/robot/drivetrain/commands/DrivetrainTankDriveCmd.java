package frc.robot.drivetrain.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.Robot;

public class DrivetrainTankDriveCmd extends CommandBase {
    private DoubleSupplier leftSpeedSupplier;
    private DoubleSupplier rightSpeedSupplier;

    private Drivetrain drivetrain;

    // Constructor for cmd; sets variables to access and requirements for interrupted
    public DrivetrainTankDriveCmd(DoubleSupplier leftspeed, DoubleSupplier rightSpeed) {
        this.drivetrain = Robot.drivetrain;
        addRequirements(drivetrain);
        this.leftSpeedSupplier = leftspeed;
        this.rightSpeedSupplier = rightSpeed;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // if teleop is enabld:
        if (DriverStation.isTeleop()) {
            // get left and right speed from stick on controller
            double leftSpeed = leftSpeedSupplier.getAsDouble();
            double rightSpeed = rightSpeedSupplier.getAsDouble();

            // call tank drive method in drivetrain and pass in left/right speeds
            drivetrain.tankDriveAbs(leftSpeed, rightSpeed);
        } else {
            drivetrain.stop();
        }
    }

    @Override
    public void end(boolean interrupted) {
        // when command ends, stop drivetrain
        drivetrain.stop();
    }
}
