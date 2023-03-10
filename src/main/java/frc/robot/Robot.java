// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.drivetrain.commands.DrivetrainCmds;
import frc.robot.pilot.PilotGamepad;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  // Declaration of substystems
  public static PilotGamepad pilotGamepad;
  public static Drivetrain drivetrain;

  // Declaration of sensor
  public static AnalogInput IRSensor = new AnalogInput(0);

  // Declaration and Instantiation of timer
  public static Timer sysTimer = new Timer();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Reset and start timer, then intialize robot subsystems
    sysTimer.reset();
    sysTimer.start();

    System.out.println("Robot init-ted");

    initSubsystems();

    System.out.println("Init subsystems done");
  }

  private void initSubsystems() {
    // Instantiate subsystems
    pilotGamepad = new PilotGamepad();
    drivetrain = new Drivetrain();

    System.out.println("gamepad and drivetrain made");

    // setup default commands
    DrivetrainCmds.setupDefaultCommand();

    System.out.println("setup default command for drivetrain");
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("IR Sensor Reading", IRSensor.getAverageVoltage());
  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // Once teleop is enable, set motors to 0 to start with
    drivetrain.stop();
    System.out.println("telop init-ted");
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {
    CommandScheduler.getInstance().enable();
  }

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
