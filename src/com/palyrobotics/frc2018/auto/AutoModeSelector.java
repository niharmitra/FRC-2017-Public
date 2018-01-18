package com.palyrobotics.frc2018.auto;

import com.palyrobotics.frc2018.auto.modes.TestAutoMode;
import com.palyrobotics.frc2018.auto.modes.TestMotionMagicAutoMode;
import com.palyrobotics.frc2018.auto.modes.TestTrajectoryAutoMode;
import com.palyrobotics.frc2018.util.logger.Logger;

import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.logging.Level;

/**
 * @author Nihar, based off Team 254 2015
 */
public class AutoModeSelector {
	private static AutoModeSelector instance = null;
	private ArrayList<AutoModeBase> mAutoModes = new ArrayList<>();
	private enum AutoIndices {
		TEST(0), TEST_TRAJECTORY(1);
		private final int id;
		AutoIndices(int id) {this.id = id;}
		public int get() {return id;}
	}
	
	/**
	 * comment for which auto mode the selectedIndex refers to
	 */

	int selectedIndex = AutoIndices.TEST_TRAJECTORY.get();

	public static AutoModeSelector getInstance() {
		if (instance == null) {
			instance = new AutoModeSelector();
		}
		return instance;
	}

	/**
	 * Add an AutoMode to list to choose from
	 * @param auto AutoMode to add
	 */
	public void registerAutonomous(AutoModeBase auto) {
		mAutoModes.add(auto);
	}

	private AutoModeSelector() {
  /*1*/registerAutonomous(new TestAutoMode());
  /*2*/registerAutonomous(new TestTrajectoryAutoMode());
	}

	/**
	 * Get the currently selected AutoMode
	 * @return AutoMode currently selected
	 */
	public AutoModeBase getAutoMode() {
		return mAutoModes.get(selectedIndex);
	}

	/**
	 * Get the AutoMode at specified index
	 * @param index index of desired AutoMode
	 * @return AutoMode at specified index
	 */
	public AutoModeBase getAutoMode(int index) {
		// Assumes future selections will be the same auto mode
		selectedIndex = index;
		return mAutoModes.get(index);
	}

	/**
	 * Gets the names of all registered AutoModes
	 * @return ArrayList of AutoModes string name
	 * @see AutoModeBase#toString()
	 */
	public ArrayList<String> getAutoModeList() {
		ArrayList<String> list = new ArrayList<String>();
		for (AutoModeBase autoMode : mAutoModes) {
			list.add(autoMode.toString());
		}
		return list;
	}

	public JSONArray getAutoModeJSONList() {
		JSONArray list = new JSONArray();
		list.addAll(getAutoModeList());
		return list;
	}

	/**
	 * Attempt to set
	 * @return false if unable to find appropriate AutoMode
	 * @see AutoModeBase#toString()
	 */
	public boolean setAutoModeByName(String name) {
		int numOccurrences = 0;
		int index = -1;
		for(int i = 0; i<mAutoModes.size(); i++) {
			if(mAutoModes.get(i).toString() == name) {
				numOccurrences++;
				index = i;
			}
		}
		if(numOccurrences == 1) {
			setAutoModeByIndex(index);
			return true;
		}
		Logger.getInstance().logRobotThread(Level.FINE, ((numOccurrences == 0) ? "Couldn't find AutoMode" : "Found multiple AutoModes"), name);
		Logger.getInstance().logRobotThread(Level.WARNING, "Didn't set AutoMode");
		return false;
	}

	/**
	 * Called during disabled in order to access dashbord and set auto mode
	 * @return false if unable to set automode
	 */
	public boolean setFromDashboard(String selection) {
		if(!setAutoModeByName(selection)) {
			Logger.getInstance().logRobotThread(Level.WARNING, "Did not find requested auto mode");
			return false;
		}
		return true;
	}

	private void setAutoModeByIndex(int which) {
		if (which < 0 || which >= mAutoModes.size()) {
			which = 0;
		}
		selectedIndex = which;
		Logger.getInstance().logRobotThread(Level.INFO, "Selected AutoMode", mAutoModes.get(selectedIndex));
	}

}