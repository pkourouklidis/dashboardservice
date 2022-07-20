/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 11/07/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.time.Instant;

public class SimulationStatus {
    private String simulationId;
    private Instant simulationStartTime;

    private int callDelay;
    private int difficultyBias;
    private int waitTimeBias;
    private int serviceTimeBias;
    private int understandingBias;
    private int workers;

    private int queueDepth;
    private int activeWorkers;
    private String status;

    public String getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(String simulationId) {
        this.simulationId = simulationId;
    }

    public Instant getSimulationStartTime() {
        return simulationStartTime;
    }

    public void setSimulationStartTime(Instant simulationStartTime) {
        this.simulationStartTime = simulationStartTime;
    }

    public int getCallDelay() {
        return callDelay;
    }

    public void setCallDelay(int callDelay) {
        this.callDelay = callDelay;
    }

    public int getDifficultyBias() {
        return difficultyBias;
    }

    public void setDifficultyBias(int difficultyBias) {
        this.difficultyBias = difficultyBias;
    }

    public int getWaitTimeBias() {
        return waitTimeBias;
    }

    public void setWaitTimeBias(int waitTimeBias) {
        this.waitTimeBias = waitTimeBias;
    }

    public int getServiceTimeBias() {
        return serviceTimeBias;
    }

    public void setServiceTimeBias(int serviceTimeBias) {
        this.serviceTimeBias = serviceTimeBias;
    }

    public int getUnderstandingBias() {
        return understandingBias;
    }

    public void setUnderstandingBias(int understandingBias) {
        this.understandingBias = understandingBias;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    public int getQueueDepth() {
        return queueDepth;
    }

    public void setQueueDepth(int queueDepth) {
        this.queueDepth = queueDepth;
    }

    public int getActiveWorkers() {
        return activeWorkers;
    }

    public void setActiveWorkers(int activeWorkers) {
        this.activeWorkers = activeWorkers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
