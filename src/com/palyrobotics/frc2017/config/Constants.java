package com.palyrobotics.frc2017.config;

import com.palyrobotics.frc2017.robot.team254.lib.util.ConstantsBase;

public class Constants extends ConstantsBase {
	public enum RobotName {
		STEIK, AEGIR, DERICA
	}
	public static final RobotName kRobotName = RobotName.DERICA;

	// Cheesy Drive tuning
	public static double kDriveSensitivity = .85;
	public static double kNegativeInertiaScalar = 5.0;

	// Manual control speed tuning
	public static double kManualIntakeSpeed = 1.0;
	public static double kManualExhaustSpeed = -1.0;

	/*
	 * Control loop constants for both robots
	 */
	public static double kTurnInPlaceSpeed = 0.5;
	// Unit Conversions for CANTalons
	// TODO: Calculate the unit conversions for native units and inches, rpm, etc as needed
	public static double kDriveInchesToTicks = 0;

	// Tolerances
	public static double kAcceptableDrivePositionError = 100;
	public static double kAcceptableDriveVelocityError = 40;
	public static double kAcceptableTurnAngleError = 1;
	public static double kAcceptableSliderPositionError;
	
	// Unit Conversions
	// TODO: Calculate the unit conversions for native units and inches, rpm, etc as needed

	// Drive Position offboard control loop
	public static double kAegirDriveDistancekP = 0;
	public static double kAegirDriveDistancekI = 0;
	public static double kAegirDriveDistancekD = 0;
	public static double kAegirDriveDistancekF = 0;
	public static int kAegirDriveDistancekIzone = 0;
	public static double kAegirDriveDistancekRampRate = 0.0;

	// Drive Velocity offboard control loop
	public static double kAegirDriveVelocitykP = 0.0;
	public static double kAegirDriveVelocitykI = 0;
	public static double kAegirDriveVelocitykD = 0.0;
	public static double kAegirDriveVelocitykF = 0;
	public static int kAegirDriveVelocitykIzone = 0;
	public static double kAegirDriveVelocityRampRate = 0.0;
	
		// Slider position offboard control loop

	// Slider motion magic offboard control loop

	// Slider potentiometer position onboard control loop

	
	public static double kSliderMaxVoltage = 4.0;
	public static double kClimberMaxVoltage = 5.0;

	
	/* !!! End of editable Constants! !!!
	 **********************************************************************************
	 */
	public static int kEndEditableArea = 0;



	/*
	 * ************************************
	 *  STEIK ELECTRONIC CONSTANTS
	 * ************************************
	 */
	// DRIVETRAIN
	public static int kSteikLeftDriveMasterDeviceID  = 0;
	public static int kSteikLeftDriveSlaveDeviceID = 0;
	public static int kSteikLeftDriveFrontMotorPDP = 0;
	public static int kSteikLeftDriveBackMotorPDP = 0;
	public static int kSteikRightDriveMasterDeviceID = 0;
	public static int kSteikRightDriveSlaveDeviceID = 0;
	public static int kSteikRightDriveFrontMotorPDP = 0;
	public static int kSteikRightDriveBackMotorPDP = 0;

	//FLIPPERS
	public static int kSteikLeftFlipperPortExtend = 0;
	public static int kSteikLeftFlipperPortRetract = 0;
	public static int kSteikRightFlipperPortExtend = 0;
	public static int kSteikRightFlipperPortRetract = 0;

	//SLIDER
	public static int kSteikSliderMotorDeviceID = 0;
	public static int kSteikSliderMotorSpeed = 0;
	public static int kSteikSliderPotentiometer = 0;
	public static int kSteikSliderPotentiometerFullRange = 0;
	public static int kSteikSliderPotentiometerOffset;

	//SPATULA
	public static int kSteikSpatulaPortExtend = 0;
	public static int kSteikSpatulaPortRetract = 0;

	//INTAKE
	public static int kSteikLeftIntakeMotorDeviceID = 0;
	public static int kSteikLeftIntakeMotorPDP = 0;
	public static int kSteikRightIntakeMotorDeviceID = 0;
	public static int kSteikRightIntakeMotorPDP = 0;

	//CLIMBER
	public static int kSteikClimberMotorDeviceID = 0;
	public static int kSteikClimberMotorPDP = 0;

	/*
	 * ************************************
	 *  AEGIR ELECTRONIC CONSTANTS
	 * ************************************
	 */
	public static int kAegirLeftDriveMasterDeviceID  = 1;
	public static int kAegirLeftDriveSlaveDeviceID = 2;
	public static int kAegirLeftDriveFrontMotorPDP = 0;
	public static int kAegirLeftDriveBackMotorPDP = 0;
	public static int kAegirRightDriveMasterDeviceID = 4;
	public static int kAegirRightDriveSlaveDeviceID = 5;
	public static int kAegirRightDriveFrontMotorPDP = 0;
	public static int kAegirRightDriveBackMotorPDP = 0;

	// FLIPPER
	public static int kAegirLeftFlipperPortExtend = 0;
	public static int kAegirLeftFlipperPortRetract = 0;
	public static int kAegirRightFlipperPortExtend = 0;
	public static int kAegirRightFlipperPortRetract = 0;

	// SLIDER
	public static int kAegirSliderMotorDeviceID = 10;
	public static int kAegirSliderMotorSpeed = 0;
	public static int kAegirSliderPotentiometer = 3;
	public static int kAegirSliderPotentiometerFullRange = 0;
	public static int kAegirSliderPotentiometerOffset;

	//SPATULA
	public static int kAegirSpatulaPortExtend = 0;
	public static int kAegirSpatulaPortRetract = 0;

	//INTAKE
	public static int kAegirLeftIntakeMotorDeviceID = 0;
	public static int kAegirLeftIntakeMotorPDP = 0;
	public static int kAegirRightIntakeMotorDeviceID = 0;
	public static int kAegirRightIntakeMotorPDP = 0;

	// CLIMBER
	public static int kAegirClimberMotorDeviceID = 9;
	public static int kAegirClimberMotorPDP = 0;

	// !!! Physical constants
	// TODO: Ailyn insert the autonomous constants here
	public static double kBaseLineDistanceInches = 93.3;
	public static double kCenterPegDistanceInches = 110;
	public static double kSidePegDistanceForwardInches = 122.5688;
	public static double kSidePegDistanceToAirshipInches = 17.5688;

	// !!! Loop rate of normal Looper
	public static double kControlLoopsDt = 0.005;

	// !!! Loop rate of subsystem updates
	public static double kSubsystemLooperDt = 0.005;


	@Override
	public String getFileLocation() {
		return "~/constants.txt";
	}

	static {
		new Constants().loadFromFile();
	}
}
