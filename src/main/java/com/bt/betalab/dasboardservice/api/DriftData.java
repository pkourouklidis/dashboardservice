/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 22/08/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.util.List;

public class DriftData {
    private List<DriftObservation> driftObservations;

    public List<DriftObservation> getDriftObservations() {
        return driftObservations;
    }

    public void setDriftObservations(List<DriftObservation> driftObservations) {
        this.driftObservations = driftObservations;
    }
}
