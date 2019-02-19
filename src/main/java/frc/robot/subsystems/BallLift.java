/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class BallLift extends Subsystem {
  private TalonSRX BallLift1;
  public void lift() {
    BallLift1 = new TalonSRX(RobotMap.BallLift1);
  }

  @Override
  public void initDefaultCommand() {
  }
  
  public void PushOut() {
    BallLift1.set(ControlMode.PercentOutput, 1);
 }

 public void PullIn(){
    BallLift1.set(ControlMode.PercentOutput, -.5);
 }

}
