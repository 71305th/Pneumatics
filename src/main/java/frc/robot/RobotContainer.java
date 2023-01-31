// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OIConstants;
import frc.robot.commands.Grab;
import frc.robot.commands.Release;
import frc.robot.subsystems.Solenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Solenoid m_solenoid = new Solenoid();
  private final Grab grab = new Grab(m_solenoid);
  private final Release release = new Release(m_solenoid);

  Joystick js1 = new Joystick(OIConstants.kDriveTrainJoystickPort);
  public RobotContainer() {
    
    configureButtonBindings();
  
  m_solenoid.setDefaultCommand(new RunCommand(()->{m_solenoid.forward(Value.kForward);},m_solenoid));
  m_solenoid.setDefaultCommand(new RunCommand(()->{m_solenoid.stop(Value.kOff);},m_solenoid));

  }
  private void configureButtonBindings() {
    new JoystickButton(js1, OIConstants.Btn_A).onFalse(grab);
    new JoystickButton(js1, OIConstants.Btn_B).onFalse(release);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
