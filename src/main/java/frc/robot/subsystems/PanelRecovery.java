/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class PanelRecovery extends Subsystem {
  private Servo Servo1;
  private Servo Servo2;
  private Servo actuator;
  boolean PanelOpen = false;
  boolean PanelExtended = true;
  public void Recovery() {
    Servo1 = new Servo(RobotMap.servo1);
    Servo2 = new Servo(RobotMap.servo2);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void PanelToggle() {
    if(PanelOpen == false) {
      int x = 90;
      Servo1.setAngle(x);
      Servo2.setAngle(x);
      x++;
      PanelOpen = true;
    }else if(PanelOpen == true) {
      int y = 0;
      Servo1.setAngle(y);
      Servo2.setAngle(y);
      y--;
      PanelOpen = false;
    }
  }

  public void PanelExtend() {
    if (PanelExtended == true) {
      actuator.set(0);
      PanelExtended = false;
    }else if (PanelExtended ==  false) {
      actuator.set(1);
      PanelExtended = true;
    }
  }
}
