# Penumatics

# v1.0 Finish Penumatics Code

Commiter : Gayting

## Features

- Press A to change solenoid to forward
- Press B to change solenoid to reverse

# v2.0 Improve Design Pattern

Commiter : Moyu

## Features

1. Change Command snd Subsystem name to `SolenoidSubsystem` and `SolenoidCommand`
2. Remove Constants Input
    1. 
        ```java
            public void forward(){
                DoublePCM1.set(DoubleSolenoid.Value.kForward);
                DoublePCM2.set(DoubleSolenoid.Value.kForward);
            }
        ```

    2. 
        ```java
            public void reverse(){
                DoublePCM1.set(DoubleSolenoid.Value.kReverse);
                DoublePCM2.set(DoubleSolenoid.Value.kReverse);
            }
        ```
    
    3. 
        ```java
            public void stop(){
                DoublePCM1.set(DoubleSolenoid.Value.kOff);
                DoublePCM2.set(DoubleSolenoid.Value.kOff);
            }
        ```
3. Improve Design Pattern
    1. Improve Button Design
        ```java
            new JoystickButton(js1, OIConstants.Btn_A)
                .onTrue(new SolenoidCommand(m_solenoidSub, "Forward"));

            new JoystickButton(js1, OIConstants.Btn_B)
                .onTrue(new SolenoidCommand(m_solenoidSub, "Reverse"));
        ```
    
    2. Combine Two Commands Into One
        Integrated everything related to pneumatics into one Command, which can help simplify unnecessary programs.