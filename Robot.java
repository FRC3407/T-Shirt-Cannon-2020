/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  
  Compressor c = new Compressor (0);
	Solenoid X = new Solenoid (3);
	Solenoid Y = new Solenoid (0);
	Solenoid B = new Solenoid (1);
	Solenoid A = new Solenoid (2);
	Joystick stick = new Joystick (1);
	
  Button buttona = new JoystickButton(stick, 1), 
      buttonb = new JoystickButton(stick,2),
	    buttonx = new JoystickButton(stick,3),
	    buttony = new JoystickButton(stick,4),
      buttonr = new JoystickButton(stick,6);
      
  @Override
  public void robotInit() {
    SpeedController left = new PWMVictorSPX(0);
    SpeedController right = new PWMVictorSPX(1);
    right.setInverted(true);
    m_myRobot = new DifferentialDrive(left, right);
    
  }
  //m_myRobot.setSafetyEnabled(true);
  //drive.setSensitivity(0.75);




public void teleopPeriodic() {
    final boolean buttonB = stick.getRawButton(2);
    final boolean buttonA = stick.getRawButton(1);
    final boolean buttonX = stick.getRawButton(3);
    final boolean buttonY = stick.getRawButton(4);
    //final boolean buttonR = stick.getRawButton(6);
    //double differential = Math.abs(stick.getX() / 4);
    c.setClosedLoopControl(true);
    //drive.arcadeDrive(stick);
    m_myRobot.arcadeDrive(stick.getX()*0.75, stick.getY()*-0.75);
    //if (buttonR == true){
        //m_myRobot.arcadeDrive(stick.getRawAxis(1)*-0.75, stick.getX()*-1);

  
    
    
    
    if(buttonA){
      A.set(true);
      Timer.delay(0.1);
      A.set(false);
    }
    if (buttonB){
      B.set(true);
      Timer.delay(0.1);
      B.set(false);
    }
    if (buttonX){
      X.set(true);
      Timer.delay(0.1);
      X.set(false);
    }
    if (buttonY){
      Y.set(true);
      Timer.delay(0.1);
      Y.set(false);
    }
    else {
      A.set(false);
      B.set(false);
      X.set(false);
      Y.set(false);
    }
    }
  
  
  
  

/**
 * This function is called periodically during test mode
 */
public void testPeriodic() {

}

}
