/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 22/08/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.util.Date;
import java.util.List;

public class DriftObservation {
    private String algorithm;
    private List<String> historicFeatures;
    private List<String> liveFeatures;
    private Date timeStamp;
    private String rawValue;
    private int level;
    
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
    public void setHistoricFeatures(List<String> historicFeatures) {
        this.historicFeatures = historicFeatures;
    }
    public void setLiveFeatures(List<String> liveFeatures) {
        this.liveFeatures = liveFeatures;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void setRawValue(String rawValue) {
        this.rawValue = rawValue;
    }
    public void setLevel(int level) {
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
    public Date getTimeStamp() {
        return timeStamp;
    }
    public String getRawValue() {
        return rawValue;
    }
    public int getLevel() {
        return level;
    }

}
