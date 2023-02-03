// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OIConstants;
import frc.robot.commands.PenumaticsCommand;
import frc.robot.subsystems.PenumaticsSubsystem;
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
  private final PenumaticsSubsystem m_penumaticsSub = new PenumaticsSubsystem();

  Joystick js1 = new Joystick(OIConstants.kDriveTrainJoystickPort);

  public RobotContainer() {
    configureButtonBindings();
  
    m_penumaticsSub.setDefaultCommand(new RunCommand(()->{ m_penumaticsSub.forward(); }, m_penumaticsSub));
    m_penumaticsSub.setDefaultCommand(new RunCommand(()->{ m_penumaticsSub.stop(); }, m_penumaticsSub));
    m_penumaticsSub.setDefaultCommand(new RunCommand(()->{ m_penumaticsSub.Halfforward(); }, m_penumaticsSub));
  }

  private void configureButtonBindings() {
    new JoystickButton(js1, OIConstants.Btn_A)
      .onTrue(new PenumaticsCommand(m_penumaticsSub, "Forward"));
    
    new JoystickButton(js1, OIConstants.Btn_X)
      .onTrue(new PenumaticsCommand(m_penumaticsSub, "HalfForward"));

    new JoystickButton(js1, OIConstants.Btn_B)
      .onTrue(new PenumaticsCommand(m_penumaticsSub, "Reverse"));
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
