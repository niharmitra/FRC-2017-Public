package com.palyrobotics.frc2016.subsystems;

import com.palyrobotics.frc2016.config.Commands;
import com.palyrobotics.frc2016.config.RobotState;
import com.palyrobotics.frc2016.util.Subsystem;
import com.palyrobotics.frc2016.util.SubsystemLoop;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * STEIK SPATULA
 * @author Ailyn Tong
 * Represents a "spatula" that stores gears and allows for passive scoring
 * Controlled by one DoubleSolenoid which toggles between UP and DOWN
 */
public class Spatula extends Subsystem implements SubsystemLoop {
	private static Spatula instance = new Spatula();
	public static Spatula getInstance() {
		return instance;
	}
	
	public enum SpatulaState { UP, DOWN }
	
	private DoubleSolenoid.Value mOutput;
	
	private Spatula() {
		super("Spatula");
	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
	}

	@Override
	public void update(Commands commands, RobotState robotState) {
		//TODO forward vs reverse
		switch (commands.wantedSpatulaState) {
		case UP:
			mOutput = DoubleSolenoid.Value.kForward;
			break;
		case DOWN:
			mOutput = DoubleSolenoid.Value.kReverse;
			break;
		}
	}
	
	public DoubleSolenoid.Value getOutput() {
		return mOutput;
	}

}