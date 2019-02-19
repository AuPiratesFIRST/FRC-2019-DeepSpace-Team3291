/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

public class DriveTrain extends Subsystem {
 
  private Spark leftWheel1;
  private Spark leftWheel2;
  private Spark rightWheel1;
  private Spark rightWheel2;
 
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }

  public DriveTrain() {   
    leftWheel1 = new Spark(RobotMap.LeftMotor1);
    leftWheel2 = new Spark(RobotMap.LeftMotor2);
    rightWheel1 = new Spark(RobotMap.RightMotor1);
    rightWheel2 = new Spark(RobotMap.RightMotor2);
  }

  public void setRaw(double leftValue, double rightValue) {
    leftWheel1.set(leftValue);
    leftWheel2.set(leftValue);
    rightWheel1.set(-rightValue);
    rightWheel2.set(-rightValue);
  }
}
