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

    // constructor
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
        if (DriverStation.isTeleop()) {
            double leftSpeed = leftSpeedSupplier.getAsDouble();
            double rightSpeed = rightSpeedSupplier.getAsDouble();

            drivetrain.tankDriveAbs(leftSpeed, rightSpeed);
        } else {
            drivetrain.stop();
        }
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
