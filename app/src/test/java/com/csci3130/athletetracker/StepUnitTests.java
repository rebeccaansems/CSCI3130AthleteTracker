package com.csci3130.athletetracker;

/**
 * Created by rainb on 2017/6/27.
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StepUnitTests {
    public AthleteSteps AthleteSteps;

    private int highStep = 15000, lowStep = 5000, normalStep = 8000;
    private int minStep = 6000, maxStep = 12000;

    @Before
    public void Start(){
        AthleteSteps = new AthleteSteps();
    }

    @Test
    public void currentStepIsCorrect() throws Exception {
        AthleteSteps.setCurrentSteps(normalStep);
        assertEquals(normalStep, AthleteSteps.getSteps());
    }

    @Test
    public void StepMinRangeIsSetProperly() throws Exception{
        AthleteSteps.setStepsRange(minStep, maxStep);
        assertEquals(AthleteSteps.StepsMin, minStep);
    }

    @Test
    public void StepMaxRangeIsSetProperly() throws Exception{
        AthleteSteps.setStepsRange(minStep, maxStep);
        assertEquals(AthleteSteps.StepsMax, maxStep);
    }


    @Test
    public void lowStepIsOutOfRange() throws Exception{
        AthleteSteps.setStepsRange(minStep, maxStep);
        AthleteSteps.setCurrentSteps(lowStep);
        assertFalse(AthleteSteps.isStepInRange());
    }

    @Test
    public void highStepIsOutOfRange() throws Exception{
        AthleteSteps.setStepsRange(minStep, maxStep);
        AthleteSteps.setCurrentSteps(highStep);
        assertFalse(AthleteSteps.isStepInRange());
    }

    @Test
    public void normalStepIsInRange() throws Exception{
        AthleteSteps.setStepsRange(minStep, maxStep);
        AthleteSteps.setCurrentSteps(normalStep);
        assertTrue(AthleteSteps.isStepInRange());
    }

    /*
    @Test
    public void resetSteps() throws Exception{
        AthleteSteps.setStepsRange(normalStep, normalStep);
        AthleteSteps.resetRangeToDefault();
        assertTrue(AthleteSteps.StepsMin == minStep && AthleteSteps.StepsMax == maxStep);
    }
    */
}
