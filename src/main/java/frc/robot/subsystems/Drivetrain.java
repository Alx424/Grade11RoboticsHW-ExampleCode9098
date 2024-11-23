// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.hardware.IDrivetrainHardware;
import frc.robot.hardware.drivetrainHardware;

public class Drivetrain{
  private IDrivetrainHardware hardware;

  public Drivetrain(drivetrainHardware hardware) {
    this.hardware = hardware;
  }

  public void arcadeDrive(double forward, double rotate) {
    double leftPower = capInput(forward + rotate, -1., 1.);
    double rightPower = capInput(forward - rotate, -1., 1.);
    hardware.setLeftPower(leftPower);
    hardware.setRightPower(rightPower);
  }

  public double capInput(double val, double min, double max) {
    if (val < min) return min;
    if (val > max) return max;
    return val;
  }
  
}
