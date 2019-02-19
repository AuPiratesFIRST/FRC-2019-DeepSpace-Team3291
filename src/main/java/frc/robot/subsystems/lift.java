/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
Compressor c;
Solenoid frontLeftSolenoid;
Solenoid frontRightSolenoid;
Solenoid backLeftSolenoid;
Solenoid backRightSolenoid;
Solenoid leftPush;
Solenoid rightPush;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public lift(){
    c = new Compressor(RobotMap.CompressorID);
    frontLeftSolenoid = new Solenoid(RobotMap.frontLeftSolenoid);
    frontRightSolenoid = new Solenoid(RobotMap.frontRightSolenoid);
    backLeftSolenoid = new Solenoid(RobotMap.backLeftSolenoid);
    backRightSolenoid = new Solenoid(RobotMap.backRightSolenoid);
  }
  public void useCompressor(boolean isOn){
    if(isOn){
      c.start();
    }else{
      c.stop();
    }
  }
  public void useSolenoid(boolean isOn, int sNum){
    if(sNum == 1){
      frontLeftSolenoid.set(isOn);
    }else if(sNum == 2){  
      frontRightSolenoid.set(isOn);
    }else if(sNum == 3){  
      backLeftSolenoid.set(isOn);
    }else if(sNum == 4){  
      backRightSolenoid.set(isOn);
    }else if(sNum == 5){
      leftPush.set(isOn);
    }else if(sNum == 6){
      rightPush.set(isOn);
    }
  }  
} 