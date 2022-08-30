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
    private int unresolvedCalls;
    private float callDelay;

    private float overallWaitTime;
    private float averageWaitTime;
    private float longestWaitTime;
    private float shortestWaitTime;

    private float overallServiceTime;
    private float averageServiceTime;
    private float longestServiceTime;
    private float shortestServiceTime;

    private float predictedHappinessSum;
    private float averagePredictedHappiness;

    private float actualHappinessSum;
    private float averageActualHappiness;

    private float easySum;
    private float easyFraction = 0;
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

    public float getCallDelay() {
        return callDelay;
    }

    public void setCallDelay(float callDelay) {
        this.callDelay = callDelay;
    }

    public float getAverageWaitTime() {
        return averageWaitTime;
    }

    public void setAverageWaitTime(float averageWaitTime) {
        this.averageWaitTime = averageWaitTime;
    }

    public float getLongestWaitTime() {
        return longestWaitTime;
    }

    public void setLongestWaitTime(float longestWaitTime) {
        this.longestWaitTime = longestWaitTime;
    }

    public float getShortestWaitTime() {
        return shortestWaitTime;
    }

    public void setShortestWaitTime(float shortestWaitTime) {
        this.shortestWaitTime = shortestWaitTime;
    }

    public float getAveragePredictedHappiness() {
        return averagePredictedHappiness;
    }

    public void setAveragePredictedHappiness(float averagePredictedHappiness) {
        this.averagePredictedHappiness = averagePredictedHappiness;
    }

    public float getAverageActualHappiness() {
        return averageActualHappiness;
    }

    public void setAverageActualHappiness(float averageActualHappiness) {
        this.averageActualHappiness = averageActualHappiness;
    }

    public float getEasyFraction() {
        return easyFraction;
    }

    public void setEasyFraction(float easyFraction) {
        this.easyFraction = easyFraction;
    }

    public List<CallData> getCalls() {
        return calls;
    }

    public void setCalls(List<CallData> calls) {
        this.calls = calls;
    }

    public int getUnresolvedCalls() {
        return unresolvedCalls;
    }

    public void setUnresolvedCalls(int unresolvedCalls) {
        this.unresolvedCalls = unresolvedCalls;
    }

    public float getOverallWaitTime() {
        return overallWaitTime;
    }

    public void setOverallWaitTime(float overallWaitTime) {
        this.overallWaitTime = overallWaitTime;
    }

    public float getOverallServiceTime() {
        return overallServiceTime;
    }

    public void setOverallServiceTime(float overallServiceTime) {
        this.overallServiceTime = overallServiceTime;
    }

    public float getAverageServiceTime() {
        return averageServiceTime;
    }

    public void setAverageServiceTime(float averageServiceTime) {
        this.averageServiceTime = averageServiceTime;
    }

    public float getLongestServiceTime() {
        return longestServiceTime;
    }

    public void setLongestServiceTime(float longestServiceTime) {
        this.longestServiceTime = longestServiceTime;
    }

    public float getShortestServiceTime() {
        return shortestServiceTime;
    }

    public void setShortestServiceTime(float shortestServiceTime) {
        this.shortestServiceTime = shortestServiceTime;
    }

    public float getPredictedHappinessSum() {
        return predictedHappinessSum;
    }

    public void setPredictedHappinessSum(float predictedHappinessSum) {
        this.predictedHappinessSum = predictedHappinessSum;
    }

    public float getActualHappinessSum() {
        return actualHappinessSum;
    }

    public void setActualHappinessSum(float actualHappinessSum) {
        this.actualHappinessSum = actualHappinessSum;
    }

    public float getEasySum() {
        return easySum;
    }

    public void setEasySum(float easySum) {
        this.easySum = easySum;
    }
}
