/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.myservice.WebSer_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author DELL
 */
public class WS_Servlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Server/WebSer.wsdl")
    private WebSer_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int add_num1 = Integer.parseInt(request.getParameter("add_num1"));
            int add_num2 = Integer.parseInt(request.getParameter("add_num2"));
            
            int sub_num1 = Integer.parseInt(request.getParameter("sub_num1"));
            int sub_num2 = Integer.parseInt(request.getParameter("sub_num2"));
            
            double mul_num1 = Double.parseDouble(request.getParameter("mul_num1"));
            double mul_num2 = Double.parseDouble(request.getParameter("mul_num2"));
            
            double div_num1 = Double.parseDouble(request.getParameter("div_num1"));
            double div_num2 = Double.parseDouble(request.getParameter("div_num2"));
            
            double principal = Double.parseDouble(request.getParameter("principal"));
            double rate = Double.parseDouble(request.getParameter("rate"));
            double time = Double.parseDouble(request.getParameter("time"));
            
            String name = request.getParameter("name");
            
            double miles = Double.parseDouble(request.getParameter("miles"));
                              
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WS_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> ADDITION is " + addition(add_num1, add_num2) + "</h1>");
            out.println("<h1> SUBTRACTION is " + subtraction(sub_num1, sub_num2) + "</h1>");
            out.println("<h1> MULTIPLICATION is " + multiplication(mul_num1, mul_num2) + "</h1>");
            out.println("<h1> DIVISION is " + division(div_num1, div_num2) + "</h1>");
            out.println("<h1> SIMPLE INTEREST is " + interest(principal, time, rate) + "</h1>");
            out.println("<h1> HELLO is " + hello(name) + "</h1>");
            out.println("<h1> KILOMETER VALUE is " + milesTokm(miles) + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private int addition(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.myservice.WebSer port = service.getWebSerPort();
        return port.addition(num1, num2);
    }

    private int subtraction(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.myservice.WebSer port = service.getWebSerPort();
        return port.subtraction(num1, num2);
    }

    private double multiplication(double num1, double num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.myservice.WebSer port = service.getWebSerPort();
        return port.multiplication(num1, num2);
    }

    private double division(double num1, double num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.myservice.WebSer port = service.getWebSerPort();
        return port.division(num1, num2);
    }

    private double interest(double principal, double time, double rate) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.myservice.WebSer port = service.getWebSerPort();
        return port.interest(principal, time, rate);
    }

    private String hello(String name) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.myservice.WebSer port = service.getWebSerPort();
        return port.hello(name);
    }

    private double milesTokm(double miles) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.myservice.WebSer port = service.getWebSerPort();
        return port.milesTokm(miles);
    }

    
}
