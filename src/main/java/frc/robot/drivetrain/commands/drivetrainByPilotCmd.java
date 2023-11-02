package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.drivetrain.drivetrain;

public class drivetrainByPilotCmd extends CommandBase {
    public drivetrainByPilotCmd() {
        // tell the robot that the drivetrain is being used by this command
    addRequirements(Robot.drivetrain);
    
    }

    public void initialize() {
        // nothing to do here
    }

    public void execute() {
        // get inputs from pilot
        double speedInput = Robot.pilot.getLeftStickY();
        double turnInput = Robot.pilot.getTriggerDifferenceScaled();

        // send those values to the drive train
        Robot.drivetrain.arcadeDrive(speedInput, turnInput);
    }

    public void end(boolean interruped) {
        Robot.drivetrain.stop();
    }

    public boolean isFinished() {
        // no conditions in which this should quit
        return false;
    }
}
