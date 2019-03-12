package com.ft.mytomcat;

import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {

    public MyResponse(OutputStream osm) {
        this.osm = osm;
    }

    public void write(String content) throws IOException {
        StringBuilder sbd = new StringBuilder(128);
        String tailPad = "\r\n";
        sbd.append("HTTP/1.1 200 ").append(tailPad)
                .append("Content-Type:text/html").append(tailPad)
                .append(tailPad)
                .append("<html><body>")
                .append(content)
                .append("</body></html>");
        osm.write(sbd.toString().getBytes());
    }

    public void stop() throws IOException {
        osm.close();
    }

    private OutputStream osm;
}
