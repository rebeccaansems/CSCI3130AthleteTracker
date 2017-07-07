package com.csci3130.athletetracker;

/**
 * Created by rainb on 2017/6/27.
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StepUnitTests {
    public AthleteSteps AthleteSteps;

    private int highStep = 30000, lowStep = 5, normalStep = 8000;
    private int minStep = 2000, maxStep = 17000;

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
        assertEquals(AthleteSteps.StepsMin, minStep);//min
    }

    @Test
    public void StepMaxRangeIsSetProperly() throws Exception{
        AthleteSteps.setStepsRange(minStep, maxStep);
        assertEquals(AthleteSteps.StepsMax, maxStep);//max
    }


    @Test
    public void lowStepIsOutOfRange() throws Exception{
        AthleteSteps.setStepsRange(minStep, maxStep);
        AthleteSteps.setCurrentSteps(lowStep);//low
        assertFalse(AthleteSteps.isStepInRange());
    }

    @Test
    public void highStepIsOutOfRange() throws Exception{
        AthleteSteps.setStepsRange(minStep, maxStep);
        AthleteSteps.setCurrentSteps(highStep);//high
        assertFalse(AthleteSteps.isStepInRange());
    }

    @Test
    public void normalStepIsInRange() throws Exception{
        AthleteSteps.setStepsRange(minStep, maxStep);
        AthleteSteps.setCurrentSteps(normalStep);//normal
        assertTrue(AthleteSteps.isStepInRange());
    }

}