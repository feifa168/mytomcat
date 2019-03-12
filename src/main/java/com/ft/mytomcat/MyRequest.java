package com.ft.mytomcat;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest {
    private String url;
    private MyHttpRequestType method;

    public MyRequest(InputStream ism) throws IOException {
        byte[] content = new byte[64];
        int readLen = ism.read(content);
        if (readLen > 0) {
            String s = new String(content, 0, readLen);
            String[] ss = s.split("\\s");
            url = ss[1];
            switch (ss[0]) {
                case "GET": {
                    method = MyHttpRequestType.MY_HTTP_REQUEST_TYPE_GET;
                    break;
                }
                case "POST": {
                    method = MyHttpRequestType.MY_HTTP_REQUEST_TYPE_POST;
                    break;
                }
            }
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "url='" + url + '\'' +
                ", method=" + method +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public MyHttpRequestType getMethod() {
        return method;
    }
}
