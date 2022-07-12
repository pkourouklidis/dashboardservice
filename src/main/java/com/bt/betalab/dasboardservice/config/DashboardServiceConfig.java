/**
 * @author Joost Noppen (611749237), BetaLab, Applied Research
 * Date: 11/07/2022
 * Copyright (c) British Telecommunications plc 2022
 **/


package com.bt.betalab.dasboardservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DashboardServiceConfig {
    private String dataServiceUrl;

    private String adminServiceUrl;

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
}
