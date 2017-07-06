package com.csci3130.athletetracker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests to see if heart rate functions are working
 */
public class HeartRateUnitTests {

    public AthleteHeartRate athleteHeartRate;

    private int highHeartRate = 150, lowHeartRate = 50, normalHeartRate = 80;
    private int minHeartRate = 60, maxHeartRate = 120;

    @Before
    public void Start(){
        athleteHeartRate = new AthleteHeartRate();
    }

    /**
     * Test that setting the current heart rate updates the current
     * heart rate properly
     */
    @Test
    public void currentHeartRateIsCorrect() {
        athleteHeartRate.setCurrentHeartRate(normalHeartRate);
        assertEquals(normalHeartRate, athleteHeartRate.getHeartRate());
    }

    /**
     * Tests that the value entered into the min heart rate field
     * is set as the min heart rate range
     */
    @Test
    public void heartRateMinRangeIsSetProperly(){
        athleteHeartRate.setHeartRateRange(minHeartRate, maxHeartRate);
        assertEquals(athleteHeartRate.heartRateMin, minHeartRate);
    }

    /**
     * Tests that the value entered into the max heart rate field is set
     * as the max heart rate range
     */
    @Test
    public void heartRateMaxRangeIsSetProperly(){
        athleteHeartRate.setHeartRateRange(minHeartRate, maxHeartRate);
        assertEquals(athleteHeartRate.heartRateMax, maxHeartRate);
    }

    /** Tests that a heart rate tha is too low returns that it's out of range
     *
     */
    @Test
    public void lowHeartRateIsOutOfRange() {
        athleteHeartRate.setHeartRateRange(minHeartRate, maxHeartRate);
        athleteHeartRate.setCurrentHeartRate(lowHeartRate);
        assertFalse(athleteHeartRate.isHeartRateInRange());
    }

    /** Tests that a heart rate that is too high returns that it's out of range
     *
     */
    @Test
    public void highHeartRateIsOutOfRange() {
        athleteHeartRate.setHeartRateRange(minHeartRate, maxHeartRate);
        athleteHeartRate.setCurrentHeartRate(highHeartRate);
        assertFalse(athleteHeartRate.isHeartRateInRange());
    }

    /**
     * Tests that an in range heart rate returns that it's in range
     */
    @Test
    public void normalHeartRateIsInRange() {
        athleteHeartRate.setHeartRateRange(minHeartRate, maxHeartRate);
        athleteHeartRate.setCurrentHeartRate(normalHeartRate);
        assertTrue(athleteHeartRate.isHeartRateInRange());
    }

    /**
     * Tests that the reset heart rate button resets the min and max heart rates
     * to their default values
     */
    @Test
    public void resetHeartRates() {
        athleteHeartRate.setHeartRateRange(normalHeartRate, normalHeartRate);
        athleteHeartRate.resetRangeToDefault();
        assertTrue(athleteHeartRate.heartRateMin == minHeartRate && athleteHeartRate.heartRateMax == maxHeartRate);
    }


}