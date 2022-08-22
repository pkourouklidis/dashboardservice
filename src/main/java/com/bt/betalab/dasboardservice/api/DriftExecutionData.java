/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 22/08/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.util.List;

public class DriftExecutionData {
    private String id;
    private String algorithm;
    private List<String> historicFeatures;
    private List<String> liveFeatures;
    private long upperBound;
    private long lowerBound;
    private List<DriftObservation> observations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public List<String> getHistoricFeatures() {
        return historicFeatures;
    }

    public void setHistoricFeatures(List<String> historicFeatures) {
        this.historicFeatures = historicFeatures;
    }

    public List<String> getLiveFeatures() {
        return liveFeatures;
    }

    public void setLiveFeatures(List<String> liveFeatures) {
        this.liveFeatures = liveFeatures;
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

    public List<DriftObservation> getObservations() {
        return observations;
    }

    public void setObservations(List<DriftObservation> observations) {
        this.observations = observations;
    }
}
