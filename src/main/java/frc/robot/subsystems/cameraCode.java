/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.vision.VisionPipeline;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.camera_pipeline.LineFollower;
import org.opencv.imgproc.Imgproc;

/**
 * Add your docs here.
 */
public class cameraCode extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  UsbCamera camera1;
  UsbCamera camera2;
  VisionThread visionThread;
  VisionPipeline pipeline;
  CvSink cvSink;
  Mat mat;
  LineFollower grip;
  public static final int IMG_WIDTH = 320;
  public static final int IMG_HEIGHT = 240;
  int boundCenter;
  @Override
  public void initDefaultCommand() {
    
  }
  public cameraCode(){
    camera1 = CameraServer.getInstance().startAutomaticCapture(RobotMap.camera1);
    camera2 = CameraServer.getInstance().startAutomaticCapture(RobotMap.camera2);
    camera1.setResolution(IMG_WIDTH, IMG_HEIGHT);
    cvSink = CameraServer.getInstance().getVideo(camera1);
    mat = new Mat();
    grip = new LineFollower();
  }
  public ArrayList<MatOfPoint> gripOutput(){
    grip.process(mat);
    return grip.filterContoursOutput();
  }
  public void createBoundingBoxAroundObject(){
    if (!grip.filterContoursOutput().isEmpty()) {
      Rect boundingBox = Imgproc.boundingRect(grip.filterContoursOutput().get(0));
      boundCenter = boundingBox.x + (boundingBox.width / 2);
    }
    
  }
  public int getBoundingBoxCenter(){
    return boundCenter;
  }
}