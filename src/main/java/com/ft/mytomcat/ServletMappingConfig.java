package com.ft.mytomcat;

import java.util.HashMap;
import java.util.Map;

public class ServletMappingConfig {
    private Map<String, String> servletMaps = new HashMap<>();

    public void addServlet(String servletUrl, String servletClass){
        servletMaps.put(servletUrl, servletClass);
    }

    public String getServlet(String servletUrl) {
        return servletMaps.get(servletUrl);
    }
}
