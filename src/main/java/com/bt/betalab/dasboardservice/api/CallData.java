/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 11/07/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.time.Instant;

public class CallData {
    private boolean isEasy;
    private Customer customer;

    private Instant arrivalTime;
    private Instant pickupTime;
    private Instant closingTime;
    private boolean isBounced = false;
    private boolean isSolved = false;
    private WorkerDetails workerDetails;

    private String simulationId;
    private String simulationStartTime;

    private int workers;

    private int callDelay;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Instant getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Instant arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Instant getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Instant pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Instant getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Instant closingTime) {
        this.closingTime = closingTime;
    }

    public boolean getIsEasy() {
        return isEasy;
    }

    public void setIsEasy(boolean easy) {
        isEasy = easy;
    }

    public boolean getIsBounced() {
        return isBounced;
    }

    public void setIsBounced(boolean bounced) {
        isBounced = bounced;
    }

    public boolean getIsSolved() {
        return isSolved;
    }

    public void setIsSolved(boolean solved) {
        isSolved = solved;
    }

    public String getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(String simulationId) {
        this.simulationId = simulationId;
    }

    public String getSimulationStartTime() {
        return simulationStartTime;
    }

    public void setSimulationStartTime(String simulationStartTime) {
        this.simulationStartTime = simulationStartTime;
    }

    public WorkerDetails getWorkerDetails() {
        return workerDetails;
    }

    public void setWorkerDetails(WorkerDetails workerDetails) {
        this.workerDetails = workerDetails;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    public int getCallDelay() {
        return callDelay;
    }

    public void setCallDelay(int callDelay) {
        this.callDelay = callDelay;
    }
}
