package com.cag.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class HelloClient {
    public static void main(String[] args) throws TException {
        TTransport tTransport = new TSocket("localhost", 7912);
        TProtocol tProtocol = new TBinaryProtocol(tTransport);
        HelloService.Client client = new HelloService.Client(tProtocol);
        tTransport.open();
        Request request = new Request().setType(RequestType.SAY_HELLO).setName("cag");
        System.out.println(client.doAction(request));
        request.setType(RequestType.QUERY_TIME).setName("cag");
        System.out.println(client.doAction(request));
    }
}
