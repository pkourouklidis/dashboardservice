/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 22/08/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.time.Instant;
import java.util.List;

public class DriftObservation {
    private String algorithm;
    private List<String> historicFeatures;
    private List<String> liveFeatures;
    private Instant timeStamp;
    private long rawValue;
    private long level;
    
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
    public void setHistoricFeatures(List<String> historicFeatures) {
        this.historicFeatures = historicFeatures;
    }
    public void setLiveFeatures(List<String> liveFeatures) {
        this.liveFeatures = liveFeatures;
    }
    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void setRawValue(long rawValue) {
        this.rawValue = rawValue;
    }
    public void setLevel(long level) {
        this.level = level;
    }
    public String getAlgorithm() {
        return algorithm;
    }
    public List<String> getHistoricFeatures() {
        return historicFeatures;
    }
    public List<String> getLiveFeatures() {
        return liveFeatures;
    }
    public Instant getTimeStamp() {
        return timeStamp;
    }
    public long getRawValue() {
        return rawValue;
    }
    public long getLevel() {
        return level;
    }

}
