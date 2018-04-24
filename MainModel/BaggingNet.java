/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainModel;

import Data.DataSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amir72c
 */
public class BaggingNet implements Serializable {

    DataSet myDataSets[];
    ArrayList<SimpleNet> nets = new ArrayList();
    
    public void trainNet(DataSet dataSets[]) {
        myDataSets=dataSets;
        for (int i = 0; i < dataSets.length; i++) {
            SimpleNet tempNet = new SimpleNet();
            tempNet.trainNet(dataSets[i]);
            nets.add(tempNet);            
        }
    }
}
