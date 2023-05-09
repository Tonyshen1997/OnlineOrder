package com.onlineorder.onlineorder;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;
import com.onlineorder.onlineorder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();

        Customer customer = new Customer();
        customer.setEmail("Tony1997");
        customer.setPassword("12345");
        customer.setFirstName("Tony");
        customer.setLastName("Shen");
        customer.setEnabled(true);

        response.getWriter().print(mapper.writeValueAsString(customer));


//        JSONObject customer = new JSONObject();
//        customer.put("email", "Tony1997");
//        customer.put("first_name", "Tony");
//        customer.put("last_name", "shen");
//        customer.put("age", 50);
//        response.getWriter().print(customer);

//        String customer = request.getParameter("username");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1> What sup, \n" + customer + "</h1>");
//        out.println("</body></html>");



//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String email = jsonRequest.getString("email");
        String firstName = jsonRequest.getString("first_name");
        String lastname = jsonRequest.getString("last_name");
        int age = jsonRequest.getInt("age");

        System.out.println(email);
        System.out.println(firstName);
        System.out.println(lastname);
        System.out.println(age);

        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status","ok");
        response.getWriter().print(jsonResponse);
    }


    public void destroy() {
    }
}