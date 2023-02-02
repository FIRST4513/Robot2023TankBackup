package frc.robot.drivetrain.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.drivetrain.Drivetrain;

public class DrivetrainArcadeDriveCmd extends CommandBase {
    private DoubleSupplier forwardSpeedSupplier;
    private DoubleSupplier turnAmountSupplier;

    private Drivetrain drivetrain;

    public DrivetrainArcadeDriveCmd(DoubleSupplier forwardSpeed, DoubleSupplier turnAmount) {
        this.drivetrain = Robot.drivetrain;
        addRequirements(drivetrain);
        this.forwardSpeedSupplier = forwardSpeed;
        this.turnAmountSupplier = turnAmount;
    }

    public void initialize() {
    }

    public void execute() {
        double forwardSpeed = this.forwardSpeedSupplier.getAsDouble();
        double turnAmount = this.turnAmountSupplier.getAsDouble();

        drivetrain.arcadeDriveABS(forwardSpeed, turnAmount);
    }

    public void end() {
        drivetrain.stop();
    }
}
