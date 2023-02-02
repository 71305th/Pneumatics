// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OIConstants;
import frc.robot.commands.SolenoidCommand;
import frc.robot.subsystems.SolenoidSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final SolenoidSubsystem m_solenoidSub = new SolenoidSubsystem();

  Joystick js1 = new Joystick(OIConstants.kDriveTrainJoystickPort);

  public RobotContainer() {
    configureButtonBindings();
  
    m_solenoidSub.setDefaultCommand(new RunCommand(()->{ m_solenoidSub.forward(); }, m_solenoidSub));
    m_solenoidSub.setDefaultCommand(new RunCommand(()->{ m_solenoidSub.stop(); }, m_solenoidSub));
  }

  private void configureButtonBindings() {
    new JoystickButton(js1, OIConstants.Btn_A)
      .onTrue(new SolenoidCommand(m_solenoidSub, "Forward"));

    new JoystickButton(js1, OIConstants.Btn_B)
      .onTrue(new SolenoidCommand(m_solenoidSub, "Reverse"));
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
