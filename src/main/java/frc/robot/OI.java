/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.FollowLine;
import frc.robot.commands.PanelExtend;
import frc.robot.commands.PanelToggle;
import frc.robot.commands.PullBallIn;
import frc.robot.commands.PushBallOut;
import frc.robot.commands.liftBack;
import frc.robot.commands.liftFront;

public class OI {
 
  public static final double StickDeadzone = 0.05;
  public final Joystick leftStick = new Joystick(RobotMap.leftStick);
  public final Joystick rightStick = new Joystick(RobotMap.rightStick);
  public final Joystick controlStick = new Joystick(RobotMap.controlStick);
  
  //Operator Buttons
  Button Button1 = new JoystickButton(controlStick, 1);
  Button Button2 = new JoystickButton(controlStick, 2);
  Button Button3 = new JoystickButton(controlStick, 3);
  Button Button4 = new JoystickButton(controlStick, 4);
  Button Button5 = new JoystickButton(controlStick, 5);
  Button Button6 = new JoystickButton(controlStick, 6);
  
  //Left buttons
  Button left1 = new JoystickButton(leftStick, 1);

  //right buttons
  Button right1 = new JoystickButton(rightStick, 1);
  Button right4 = new JoystickButton(rightStick,4);
  Button right5 = new JoystickButton(rightStick,5);

  
  public OI() {
    //Button1.toggleWhenPressed(new PushBallOut());
    //Button3.toggleWhenPressed(new PullBallIn());
    //Button2.whenPressed(new PanelToggle());
    //Button4.whenPressed(new PanelExtend());
    //left1.toggleWhenPressed(new liftFront());
    //right1.toggleWhenPressed(new liftBack());
    //right4.whenPressed(new FollowLine());
    //right5.cancelWhenPressed(new FollowLine()); 
  }

    public double getLeftJoyY() {
      double raw = leftStick.getY();
      return Math.abs(raw) < StickDeadzone ? 0.0 : raw;
    }

    public double getRightJoyY() {
      double raw = rightStick.getY();
      return Math.abs(raw) < StickDeadzone ? 0.0 : raw;
    }

    public double getLeftJoyX() {
      double raw = leftStick.getX();
      return Math.abs(raw) < StickDeadzone ? 0.0 : raw;
    }

    public double getRightJoyX() {
      double raw = rightStick.getX();
      return Math.abs(raw) < StickDeadzone ? 0.0 : raw;
    }
}
