// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
   
   // PWM Channels
   public static final int kDriverJoystickPort = 0;
   public static final int kOperatorJoystickPort = 1;
 
   // Driver Station Ports
   public static final class OIConstants {
      public static final int kDriveTrainJoystickPort = 0;
      public static final int kOthersJoystickPort = 1;

      public static final int leftStick_X = 0;
      public static final int leftStick_Y = 1;
      public static final int rightStick_X = 4;
      public static final int rightStick_Y = 5;
      public static final int trigger_L = 2;
      public static final int trigger_R = 3;
      public static final int Btn_A = 1;
      public static final int Btn_B = 2;
      public static final int Btn_X = 3;
      public static final int Btn_Y = 4;
      public static final int Btn_LB = 5;
      public static final int Btn_RB = 6;
      public static final int Btn_LS = 9;  
      public static final int Btn_RS = 10;
   }

   public static final class PenumaticConstants {
      public static final double kDefaultPeriod = 0;
      public static final double kMaxPressure = 60;
      public static final int DoubleSolenoidForwardChannel = 1;
      public static final int DoubleSolenoidReserveChannel = 2;
   }
}
