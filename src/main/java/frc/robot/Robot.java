// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.arm.arm;
import frc.robot.arm.commands.armCmds;
import frc.robot.auto.AutoCmds;
import frc.robot.copilot.copilot;
import frc.robot.copilot.commands.copilotCmds;
import frc.robot.drivetrain.drivetrain;
import frc.robot.drivetrain.commands.drivetrainCmds;
import frc.robot.intake.intake;
import frc.robot.intake.commands.intakeCmds;
import frc.robot.pilot.pilot;
import frc.robot.pilot.commands.pilotCmds;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {
  
  // Declaration of substystems
  public static drivetrain drivetrain;
  public static arm arm;
  public static intake intake;
  public static pilot pilot;
  public static copilot copilot;
  public static RobotTelemetry telemetry;

  // Declaration and instantiation of timer
  public static Timer sysTimer = new Timer();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Reset and start timer
    sysTimer.reset();
    sysTimer.start();

    // Initialize subsystems and setup default commands
    initSubsystems();
    setupDefaultCommands();
  }

  private void initSubsystems() {
    // Instantiate subsystems (make them exist)
    drivetrain = new drivetrain();
    arm = new arm();
    intake = new intake();
    pilot = new pilot();
    copilot = new copilot();
    telemetry = new RobotTelemetry();
  }

  private void setupDefaultCommands() {
    drivetrainCmds.setupDefaultCommand();
    armCmds.setupDefaultCommand();
    intakeCmds.setupDefaultCommand();
    pilotCmds.setupDefaultCommand();
    copilotCmds.setupDefaultCommand();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    resetCommandsAndButtons();
    // AutoCmds.EjectOnlyCmd().schedule();
    AutoCmds.EjectAndCrossCmd().schedule();
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // When teleoperated mode is enabled, stop the motors
    drivetrain.stop();
    arm.stopMotor();
    intake.stopMotor();

    // reset commands and buttons
    resetCommandsAndButtons();
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

  // misc methods
  public static void resetCommandsAndButtons() {
    CommandScheduler.getInstance().cancelAll();
    CommandScheduler.getInstance().getActiveButtonLoop().clear();
    pilot.resetConfig();
    copilot.resetConfig();
  }
}
