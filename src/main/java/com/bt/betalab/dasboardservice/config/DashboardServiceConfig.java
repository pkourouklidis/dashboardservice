/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 11/07/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DashboardServiceConfig {
    @Value(value = "${dashboardservice.dataServiceUrl}")
    private String dataServiceUrl;

    @Value(value = "${dashboardservice.adminServiceUrl}")
    private String adminServiceUrl;

    @Value(value = "${dashboardservice.panoptesModelUrl}")
    private String panoptesModelUrl;

    public String getDataServiceUrl() {
        return dataServiceUrl;
    }

    public void setDataServiceUrl(String dataServiceUrl) {
        this.dataServiceUrl = dataServiceUrl;
    }

    public String getAdminServiceUrl() {
        return adminServiceUrl;
    }

    public void setAdminServiceUrl(String adminServiceUrl) {
        this.adminServiceUrl = adminServiceUrl;
    }

    public String getPanoptesModelUrl() {
        return panoptesModelUrl;
    }

    public void setPanoptesModelUrl(String panoptesModelUrl) {
        this.panoptesModelUrl = panoptesModelUrl;
    }
}
