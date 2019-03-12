package com.ft.mytomcat;

import java.io.IOException;

public class MyServletPeople extends MyServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("get people");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("post people");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
