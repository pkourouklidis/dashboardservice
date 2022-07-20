/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 11/07/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.time.Instant;

public class SimulationSummary {
    private String simulationId;
    private Instant simulationStartTime;

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
}
