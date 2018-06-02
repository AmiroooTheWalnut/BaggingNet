/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainModel;

import Data.FullCase;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Amir72c
 */
public class TestResult implements Serializable{
    public ArrayList<FullCase> predictions;
    public double realDurations[];
    public double predictedDurations[];
    public double durationMeanAbsoluteError;
    public int numEventInconformities[];
    public int timeInconformityDays[];
    TestResult(ArrayList<FullCase> passed_predictions,double[] passed_realDurations,double[] passed_predictedDurations,double passed_durationMeanAbsoluteError,int passed_numEventInconformities[],int passed_timeInconformityDays[])
    {
        predictions=passed_predictions;
        realDurations=passed_realDurations;
        predictedDurations=passed_predictedDurations;
        durationMeanAbsoluteError=passed_durationMeanAbsoluteError;
        numEventInconformities=passed_numEventInconformities;
        timeInconformityDays=passed_timeInconformityDays;
    }
}
