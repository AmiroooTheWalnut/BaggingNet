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
    
    public String getRestultsInString()
    {
        StringBuilder resultText = new StringBuilder();
        for (int i = 0; i < this.predictions.size(); i++) {
            resultText.append("%%%");
            resultText.append("\n");
            for (int j = 0; j < this.predictions.get(i).staticTransactions.size(); j++) {
                if (this.predictions.get(i).staticTransactions.get(j).isPredicted==true) {
                    for (int k = 0; k < this.predictions.get(i).staticTransactions.get(j).data.length; k++) {
                        resultText.append(this.predictions.get(i).staticTransactions.get(j).data[k]);
                        resultText.append(",");
                    }
                    resultText.append("Duration: ").append(this.predictions.get(i).staticTransactions.get(j).duration);
                    resultText.append(",");
                    resultText.append("*PREDICTED*");
                } else {
                    for (int k = 0; k < this.predictions.get(i).staticTransactions.get(j).data.length; k++) {
                        resultText.append(this.predictions.get(i).staticTransactions.get(j).data[k]);
                        resultText.append(",");
                    }
                    resultText.append("Duration: ").append(this.predictions.get(i).staticTransactions.get(j).duration);
                    resultText.append(",");
                    resultText.append("KNOWN");
                }
                resultText.append("\n");
            }
            resultText.append("Real duration: ").append(this.realDurations[i]);
            resultText.append("\n");
            resultText.append("Predicted duration: ").append(this.predictedDurations[i]);
            resultText.append("\n");
            resultText.append("Case event inconformity: ").append(this.numEventInconformities[i]);
            resultText.append("\n");
            resultText.append("Case time inconformity: ").append(this.timeInconformityDays[i]);
            resultText.append("\n");
            resultText.append("%%%");
            resultText.append("\n");
            resultText.append("\n");
            resultText.append("Mean absolute error:");
            resultText.append(this.durationMeanAbsoluteError);
        }
        return resultText.toString();
    }
    
}
