package com.palyrobotics.frc2016.subsystems;

import com.palyrobotics.frc2016.config.Commands;
import com.palyrobotics.frc2016.config.RobotState;
import com.palyrobotics.frc2016.util.CANTalonOutput;
import com.palyrobotics.frc2016.util.Subsystem;
import com.palyrobotics.frc2016.util.SubsystemLoop;

/**
 * Created by Nihar on 1/28/17.
 * TODO: All
 */
public class Slider extends Subsystem implements SubsystemLoop {
	private static Slider instance = new Slider();
	public static Slider getInstance() {
		return instance;
	}

	@Override
	public void start() {

	}

	@Override
	public void stop() {

	}

	@Override
	public void update(Commands commands, RobotState robotState) {

	}

	private Slider() {
		super("Slider");
	}

	public CANTalonOutput getOutput() {
		return new CANTalonOutput();
	}
}