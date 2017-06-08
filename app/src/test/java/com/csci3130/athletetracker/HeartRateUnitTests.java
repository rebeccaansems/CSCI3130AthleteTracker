package com.csci3130.athletetracker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class HeartRateUnitTests {

    public AthleteHeartRate athleteHeartRate;

    private int highHeartRate = 150, lowHeartRate = 50, normalHeartRate = 80;
    private int minHeartRate = 60, maxHeartRate = 120;

    @Before
    public void Start(){
        athleteHeartRate = new AthleteHeartRate();
    }

    @Test
    public void currentHeartRateIsCorrect() throws Exception {
        athleteHeartRate.setCurrentHeartRate(normalHeartRate);
        assertEquals(normalHeartRate, athleteHeartRate.getHeartRate());
    }

    @Test
    public void heartRateMinRangeIsSetProperly() throws Exception{
        athleteHeartRate.setHeartRateRange(minHeartRate, maxHeartRate);
        assertEquals(athleteHeartRate.heartRateMin, minHeartRate);
    }

    @Test
    public void heartRateMaxRangeIsSetProperly() throws Exception{
        athleteHeartRate.setHeartRateRange(minHeartRate, maxHeartRate);
        assertEquals(athleteHeartRate.heartRateMax, maxHeartRate);
    }

    @Test
    public void lowHeartRateIsOutOfRange() throws Exception{
        athleteHeartRate.setHeartRateRange(minHeartRate, maxHeartRate);
        athleteHeartRate.setCurrentHeartRate(lowHeartRate);
        assertFalse(athleteHeartRate.isHeartRateInRange());
    }

    @Test
    public void highHeartRateIsOutOfRange() throws Exception{
        athleteHeartRate.setHeartRateRange(minHeartRate, maxHeartRate);
        athleteHeartRate.setCurrentHeartRate(highHeartRate);
        assertFalse(athleteHeartRate.isHeartRateInRange());
    }

    @Test
    public void normalHeartRateIsInRange() throws Exception{
        athleteHeartRate.setHeartRateRange(minHeartRate, maxHeartRate);
        athleteHeartRate.setCurrentHeartRate(normalHeartRate);
        assertTrue(athleteHeartRate.isHeartRateInRange());
    }

    @Test
    public void resetHeartRates() throws Exception{
        athleteHeartRate.setHeartRateRange(normalHeartRate, normalHeartRate);
        athleteHeartRate.resetRangeToDefault();
        assertTrue(athleteHeartRate.heartRateMin == minHeartRate && athleteHeartRate.heartRateMax == maxHeartRate);
    }


}