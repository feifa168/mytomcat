package com.ft.mytomcat;

public abstract class MyServlet {
    public abstract void doGet(MyRequest request, MyResponse response);
    public abstract void doPost(MyRequest request, MyResponse response);

    public void service(MyRequest request, MyResponse response) {
        MyHttpRequestType method = request.getMethod();
        switch (method) {
            case MY_HTTP_REQUEST_TYPE_GET: {
                doGet(request, response);
                break;
            }
            case MY_HTTP_REQUEST_TYPE_POST: {
                doPost(request, response);
                break;
            }
        }
    }
}
