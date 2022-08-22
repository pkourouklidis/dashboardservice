/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 22/08/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.time.Instant;

public class DriftObservation {
    private Instant timeStamp;
    private long rawValue;
    private long discretisedValue;
    private boolean unacceptableDrift;

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getRawValue() {
        return rawValue;
    }

    public void setRawValue(long rawValue) {
        this.rawValue = rawValue;
    }

    public long getDiscretisedValue() {
        return discretisedValue;
    }

    public void setDiscretisedValue(long discretisedValue) {
        this.discretisedValue = discretisedValue;
    }

    public boolean getIsUnacceptableDrift() {
        return unacceptableDrift;
    }

    public void setIsUnacceptableDrift(boolean unacceptableDrift) {
        this.unacceptableDrift = unacceptableDrift;
    }
}
