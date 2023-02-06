// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.PneumaticsSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class PneumaticsCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final PneumaticsSubsystem solenoid;
  private final String status;

  /**
   * Creates a new solenoid command
   *
   * @param subsystem The subsystem used by this command.
   */
  public PneumaticsCommand( PneumaticsSubsystem solenoid, String flag ) {
    this.solenoid = solenoid;
    status = flag;

    System.out.println(status);

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(solenoid);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    solenoid.enablecompressor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println(status);
    if( status == "Reverse" )  solenoid.reverse();
    if( status == "Forward" ) solenoid.forward();
    if( status == "HalfForward" ) solenoid.HalfForward();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
