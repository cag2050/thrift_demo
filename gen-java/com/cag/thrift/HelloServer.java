package com.cag.thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import java.io.IOException;
import java.net.ServerSocket;

public class HelloServer {
    public static void main(String[] args) throws IOException, TTransportException {
        ServerSocket serverSocket = new ServerSocket(7912);
        TServerSocket tServerSocket = new TServerSocket(serverSocket);
//        com.cag.thrift.HelloService.Processor processor = new com.cag.thrift.HelloService.Processor(new HelloServiceImpl());
        HelloService.Processor<HelloServiceImpl> processor = new com.cag.thrift.HelloService.Processor<HelloServiceImpl>(new HelloServiceImpl());
        TServer tServer = new TSimpleServer(new TServer.Args(tServerSocket).processor(processor));
        System.out.println("Running server...");
        tServer.serve();
    }
}
