package com.palyrobotics.frc2018.subsystems.controllers;

import com.palyrobotics.frc2018.config.Constants;
import com.palyrobotics.frc2018.config.Gains;
import com.palyrobotics.frc2018.config.RobotState;
import com.palyrobotics.frc2018.robot.Robot;
import com.palyrobotics.frc2018.subsystems.Drive.DriveController;
import com.palyrobotics.frc2018.util.Pose;
import com.palyrobotics.frc2018.util.TalonSRXOutput;
import com.palyrobotics.frc2018.util.archive.DriveSignal;

public class EncoderTurnAngleController implements DriveController {

	private Pose cachedPose;
	private double leftTarget;
	private double rightTarget;
	private double maxAccel;
	private double maxVel;
	private Gains mGains;
	private TalonSRXOutput leftOutput;
	private TalonSRXOutput rightOutput;
	
	public EncoderTurnAngleController(Pose priorSetpoint, double angle) {
		leftTarget = priorSetpoint.leftEnc + (angle * Constants.kDriveInchesPerDegree * Constants.kDriveTicksPerInch);
		System.out.println("Left target: "+leftTarget);
		rightTarget = priorSetpoint.rightEnc - (angle * Constants.kDriveInchesPerDegree * Constants.kDriveTicksPerInch);
		System.out.println("Right target: "+rightTarget);
		cachedPose = priorSetpoint;
		this.maxAccel = 72 * Constants.kDriveSpeedUnitConversion; 
		this.maxVel = 36 * Constants.kDriveSpeedUnitConversion;

		if(Constants.kRobotName.equals(Constants.RobotName.UNNAMED)) {
			mGains = new Gains(6.0, 0.01, 210, 2.0, 50, 0.0);
		} 

		leftOutput = new TalonSRXOutput();
		leftOutput.setMotionMagic(leftTarget, mGains, (int )maxVel, (int ) maxAccel);
		rightOutput = new TalonSRXOutput();
		rightOutput.setMotionMagic(rightTarget, mGains, (int )maxVel, (int) maxAccel);
	}

	@Override
	public boolean onTarget() {
		if(Robot.getRobotState().leftSetpoint != leftOutput.getSetpoint() || Robot.getRobotState().rightSetpoint != rightOutput.getSetpoint() ||
				Robot.getRobotState().leftControlMode != leftOutput.getControlMode() || Robot.getRobotState().rightControlMode != rightOutput.getControlMode()) {
			System.out.println("Mismatched desired talon and actual talon states!");
			return false;
		}

		double positionTolerance = Constants.kAcceptableTurnAngleError * Constants.kDriveInchesPerDegree * Constants.kDriveTicksPerInch;
		double velocityTolerance = Constants.kAcceptableDriveVelocityError;

		if(cachedPose == null) {
			System.out.println("Cached pose is null");
			return false;
		}
//		System.out.println("Left: " + Math.abs(leftTarget - cachedPose.leftEnc) + 
//				"Right: " + Math.abs(rightTarget - cachedPose.rightEnc));
		if(Math.abs(cachedPose.leftSpeed) < velocityTolerance && Math.abs(cachedPose.rightSpeed) < velocityTolerance &&
				Math.abs(leftTarget - cachedPose.leftEnc) < positionTolerance && Math.abs(rightTarget - cachedPose.rightEnc) < positionTolerance) {
			System.out.println("turn angle done");
			return true;
		}
		else return false;
	}

	@Override
	public DriveSignal update(RobotState state) {
		cachedPose = state.drivePose;
		return new DriveSignal(leftOutput, rightOutput);
	}

	@Override
	public Pose getSetpoint() {
		return new Pose(leftTarget, 0, 0, rightTarget, 0, 0, 0, 0, 0, 0);
	}

}
