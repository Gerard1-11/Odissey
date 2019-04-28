package mx.dbas.odissey;
import mx.dbas.*;

import com.google.common.collect.ComputationException;

import java.io.IOException;

public class Visor {
    String projectID="hackmx2-238923\n";
    String computeRegion="";
    String modelId = "SalonCongresos_v20190428072703";
    String filePath;
    String scoreThreshold="90";

    PredictionApi pred;

    public void main(String[] args){

        prediction(filePath);

    }


    private void prediction(String filepath){
        try {
            pred.predict(projectID, computeRegion, modelId, filePath, scoreThreshold);

        }catch (IOException e){
            System.out.println("Unreachable path");

        }
    }

}