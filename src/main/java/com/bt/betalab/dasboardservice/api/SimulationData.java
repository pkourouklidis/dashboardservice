/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 11/07/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.time.Instant;
import java.util.List;

public class SimulationData {
    private String simulationId;
    private Instant startTime;
    private int workers;
    private int totalCalls;
    private int bouncedCalls;
    private int resolvedCalls;
    private long callDelay;
    private long averageWaitTime;
    private long longestWaitTime;
    private long shortestWaitTime;
    private long averagePredictedHappiness;
    private long averageActualHappiness;

    private long easyFraction = 0;
    private List<CallData> calls;

    public String getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(String simulationId) {
        this.simulationId = simulationId;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    public int getTotalCalls() {
        return totalCalls;
    }

    public void setTotalCalls(int totalCalls) {
        this.totalCalls = totalCalls;
    }

    public int getBouncedCalls() {
        return bouncedCalls;
    }

    public void setBouncedCalls(int bouncedCalls) {
        this.bouncedCalls = bouncedCalls;
    }

    public int getResolvedCalls() {
        return resolvedCalls;
    }

    public void setResolvedCalls(int resolvedCalls) {
        this.resolvedCalls = resolvedCalls;
    }

    public long getCallDelay() {
        return callDelay;
    }

    public void setCallDelay(long callDelay) {
        this.callDelay = callDelay;
    }

    public long getAverageWaitTime() {
        return averageWaitTime;
    }

    public void setAverageWaitTime(long averageWaitTime) {
        this.averageWaitTime = averageWaitTime;
    }

    public long getLongestWaitTime() {
        return longestWaitTime;
    }

    public void setLongestWaitTime(long longestWaitTime) {
        this.longestWaitTime = longestWaitTime;
    }

    public long getShortestWaitTime() {
        return shortestWaitTime;
    }

    public void setShortestWaitTime(long shortestWaitTime) {
        this.shortestWaitTime = shortestWaitTime;
    }

    public long getAveragePredictedHappiness() {
        return averagePredictedHappiness;
    }

    public void setAveragePredictedHappiness(long averagePredictedHappiness) {
        this.averagePredictedHappiness = averagePredictedHappiness;
    }

    public long getAverageActualHappiness() {
        return averageActualHappiness;
    }

    public void setAverageActualHappiness(long averageActualHappiness) {
        this.averageActualHappiness = averageActualHappiness;
    }

    public long getEasyFraction() {
        return easyFraction;
    }

    public void setEasyFraction(long easyFraction) {
        this.easyFraction = easyFraction;
    }

    public List<CallData> getCalls() {
        return calls;
    }

    public void setCalls(List<CallData> calls) {
        this.calls = calls;
    }
}
