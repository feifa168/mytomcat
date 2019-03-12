package com.ft.mytomcat;

import java.io.IOException;

public class MyServletUser extends MyServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("get user");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("post user");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
