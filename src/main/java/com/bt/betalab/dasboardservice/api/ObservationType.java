/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 22/08/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.api;

import java.util.List;

public class ObservationType {
    private String type;
    private List<String> executions;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getExecutions() {
        return executions;
    }

    public void setExecutions(List<String> executions) {
        this.executions = executions;
    }
}
