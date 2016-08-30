/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketfun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author christian
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        
        
        ServerSocket ss = new ServerSocket(9991);
        System.out.println("Server is waiting for client request");
        Socket s = ss.accept();
        System.out.println("client connected");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = br.readLine();
        
        System.out.println("Client data: " + str);
        
        String testString = "Hej fra Server!";
        
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);
        out.println(testString);
        out.flush();
        
//        String serv2Client = "Hej med dig Christian";
//        
//        OutputStreamWriter sos = new OutputStreamWriter(s.getOutputStream());
//        PrintWriter spw = new PrintWriter(sos);
//        spw.println(serv2Client);
//        spw.flush();
        
    }
}
