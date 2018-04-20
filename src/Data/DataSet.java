/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Amir72c
 */
public class DataSet implements Serializable{

    public int caseIndex;
    public int eventIndex;
    public int timeIndex;
    public Header header;
    public ArrayList<FullCase> myFullCases = new ArrayList();
    public ArrayList<FullCase> myTimedFullCases = new ArrayList();

    public DataSet randomSample(double percent) {
        DataSet output = new DataSet();
        output.caseIndex = caseIndex;
        output.eventIndex = eventIndex;
        output.timeIndex = timeIndex;
        output.header = header;
        ArrayList<Integer> indexes = new ArrayList();
        for (int i = 0; i < myFullCases.size(); i++) {
            indexes.add(i);
        }
        for (int i = 0; i < ((float) percent / 100f) * myFullCases.size(); i++) {
            int randomIndex = (int) Math.floor(Math.random() * indexes.size());
            int tempIndex = indexes.get(randomIndex);
            output.myFullCases.add(new FullCase(timeIndex, myFullCases.get(tempIndex).staticTransactions, myFullCases.get(tempIndex).dynamicTransactions));
            indexes.remove(randomIndex);
        }
        output.myTimedFullCases=DataSetProcessor.extractTimedFullCases(output.myFullCases);
        return output;
    }

    public DataSet linearSample(double percent, boolean fromEnd) {
        DataSet output = new DataSet();
        output.caseIndex = caseIndex;
        output.eventIndex = eventIndex;
        output.timeIndex = timeIndex;
        output.header = header;
        if (fromEnd == false) {
            for (int i = 0; i < ((float) percent / 100f) * myFullCases.size(); i++) {
                output.myFullCases.add(new FullCase(timeIndex, myFullCases.get(i).staticTransactions, myFullCases.get(i).dynamicTransactions));
            }
        } else {
            for (int i = myFullCases.size()-1; i > Math.round(((float) (100 - percent) / 100f) * myFullCases.size()); i--) {
                output.myFullCases.add(new FullCase(timeIndex, myFullCases.get(i).staticTransactions, myFullCases.get(i).dynamicTransactions));
            }
        }
        output.myTimedFullCases=DataSetProcessor.extractTimedFullCases(output.myFullCases);
        return output;
    }
}
