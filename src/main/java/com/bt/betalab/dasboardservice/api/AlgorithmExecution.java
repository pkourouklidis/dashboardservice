/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 22/08/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.util.List;

public class AlgorithmExecution {
    private String algorithm;
    private List<DriftObservation> algorithmExecutions;

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public List<DriftObservation> getAlgorithmExecutions() {
        return algorithmExecutions;
    }

    public void setAlgorithmExecutions(List<DriftObservation> algorithmExecutions) {
        this.algorithmExecutions = algorithmExecutions;
    }
}
