/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "WebSer")
public class WebSer {
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addition")
    public int addition(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
        //TODO write your implementation code here:
        return num1 + num2;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "subtraction")
    public int subtraction(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
        //TODO write your implementation code here:
        return num1 - num2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiplication")
    public double multiplication(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1 * num2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "division")
    public double division(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1 / num2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "interest")
    public double interest(@WebParam(name = "principal") double principal, @WebParam(name = "time") double time, @WebParam(name = "rate") double rate) {
        //TODO write your implementation code here:
        return (principal * time * rate) / 100;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String name) {
        //TODO write your implementation code here:
        return "Hello " + name;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "milesTokm")
    public double milesTokm(@WebParam(name = "miles") double miles) {
        //TODO write your implementation code here:
        return miles * 1.609;
    }
    
}



//🔵 Web Service (Distributed Web Service Consumer)
//🧠 Definition
//
//A Web Service is a software component that allows communication between applications over a network using standard protocols like HTTP.
//
//        ⚡ What are we doing in this assignment?
//
//        👉 Client sends request (e.g., add, reverse string)
//👉 Server processes it
//👉 Server sends response back
//
//🔧 Architecture
//Client → HTTP → Web Service → Process → Response → Client
//⚡ Key Components
//1. Service Provider (Server)
//Hosts the web service
//Contains business logic
//2. Service Consumer (Client)
//Calls the web service
//Receives result
//3. WSDL (Web Service Description Language)
//XML file describing service
//Contains:
//methods
//        parameters
//return types
//4. SOAP (Simple Object Access Protocol)
//XML-based communication protocol
//Used to send request/response
//5. UDDI (optional)
//Directory to publish/search services
//⚡ Working (Step-by-step)
//Server creates and publishes web service
//WSDL is generated
//Client reads WSDL
//Client generates stub
//Client calls method
//Server processes request
//Response sent back
//⚡ In your Java assignment (simplified)
//Server
//Endpoint.publish("http://localhost:8080/ws", new ServiceImpl());
//
//        👉 publishes service
//
//Client
//Service service = Service.create(...);
//PortType obj = service.getPort(...);
//        obj.method();
//
//👉 calls service
//
//🔥 Features
//Platform independent
//Language independent
//Interoperable
//Uses standard protocols
//⚡ Advantages
//Easy integration
//Reusable services
//Works over internet
//        Scalable
//❌ Disadvantages
//Slower (XML overhead)
//Complex setup
//Security concerns
//⚡ Web Service vs RMI vs CORBA
//Feature	RMI	CORBA	Web Service
//Language	Java only	Multi	Multi
//Protocol	RMI	IIOP	HTTP
//Format	Binary	Binary	XML/JSON
//Use	LAN	Distributed	Internet
//🧠 One-line memory
//
//👉 “Web service exposes functionality over HTTP using XML-based communication.”