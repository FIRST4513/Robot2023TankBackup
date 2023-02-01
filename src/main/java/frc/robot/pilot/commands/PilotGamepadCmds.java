package frc.robot.pilot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;
import frc.robot.drivetrain.commands.DrivetrainTankDriveCmd;

public class PilotGamepadCmds {
    /** Set default command to turn off the rumble */
    public static void setupDefaultCommand() {
        Robot.pilotGamepad.setDefaultCommand(rumblePilotCmd(0));
    }

    public static Command tankDrive() {
        System.out.println("\nTank drive called;\nLeft Input  /  Right Input\n" + Robot.pilotGamepad.getLeftInput() + ", " + Robot.pilotGamepad.getRightInput());
        
        return new DrivetrainTankDriveCmd(() -> Robot.pilotGamepad.getLeftInput(), () -> Robot.pilotGamepad.getRightInput());
    }

    /** Command that can be used to rumble the pilot controller */
    public static Command rumblePilotCmd(double intensity) {
        return new RunCommand(() -> Robot.pilotGamepad.rumble(intensity), Robot.pilotGamepad);
    }
}
