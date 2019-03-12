package com.ft.mytomcat;

public class ServletMapping {

    public ServletMapping(String servletName, String url, String clazz) {
        this.servletName = servletName;
        this.url = url;
        this.clazz = clazz;
    }

    public String getUrl() {
        return url;
    }

    public String getServletName() {
        return servletName;
    }

    public String getClazz() {
        return clazz;
    }

    private String url;
    private String servletName;
    private String clazz;
}
