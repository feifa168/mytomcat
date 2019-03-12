package com.ft.mytomcat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTomcat {
    public MyTomcat(int port) {
        this.port = port;
    }

    public void initUrlServlet() {
        servletConfig = new ServletMappingConfig();

        // 这部分可以通过xml配置获取
        List<ServletMapping> servletMaps = new ArrayList<>();
        servletMaps.add(new ServletMapping("user", "/user", "com.ft.mytomcat.MyServletUser"));
        servletMaps.add(new ServletMapping("people", "/people", "com.ft.mytomcat.MyServletPeople"));

        for (ServletMapping servlet : servletMaps) {
            servletConfig.addServlet(servlet.getUrl(), servlet.getClazz());
        }
    }

    public void start() {
        initUrlServlet();

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("server on port " + port + " is running...");
            while (true) {
                Socket client = server.accept();
                disptach(new MyRequest(client.getInputStream()), new MyResponse(client.getOutputStream()));
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disptach(MyRequest request, MyResponse response) {
        String className = servletConfig.getServlet(request.getUrl());
        if (className != null) {
            try {
                Class cls = Class.forName(className);
                MyServlet myServlet = (MyServlet) cls.newInstance();
                myServlet.service(request, response);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private int port;
    private Map<String, String> urlServletMap = new HashMap<>();
    private ServletMappingConfig servletConfig;

    public static void main(String[] args) {
        MyTomcat mytomcat = new MyTomcat(8080);
        mytomcat.start();
    }
}
