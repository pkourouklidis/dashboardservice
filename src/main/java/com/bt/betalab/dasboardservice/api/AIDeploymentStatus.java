/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 22/08/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.util.List;

public class AIDeploymentStatus {
    private String id;

    private String modelid;
    private String displayName;
    private String status;
    private boolean healthy;
    private List<ObservationType> observations;

    private DriftData data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelid() {
        return modelid;
    }

    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getIsHealthy() {
        return healthy;
    }

    public void setIsHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public List<ObservationType> getObservations() {
        return observations;
    }

    public void setObservations(List<ObservationType> observations) {
        this.observations = observations;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public DriftData getData() {
        return data;
    }

    public void setData(DriftData data) {
        this.data = data;
    }
}
