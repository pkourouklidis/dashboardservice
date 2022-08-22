/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 22/08/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.util.List;

public class DriftData {
    private String id;
    private long upperBound;
    private long lowerBound;
    private List<AlgorithmExecution> algorithmExecutions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(long upperBound) {
        this.upperBound = upperBound;
    }

    public long getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(long lowerBound) {
        this.lowerBound = lowerBound;
    }

    public List<AlgorithmExecution> getAlgorithmExecutions() {
        return algorithmExecutions;
    }

    public void setAlgorithmExecutions(List<AlgorithmExecution> algorithmExecutions) {
        this.algorithmExecutions = algorithmExecutions;
    }
}
