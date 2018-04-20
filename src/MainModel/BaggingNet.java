/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainModel;

import Data.DataSet;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Amir72c
 */
public class BaggingNet implements Serializable{
    DataSet myDataSet;
    ArrayList<SimpleNet> nets=new ArrayList();
}
