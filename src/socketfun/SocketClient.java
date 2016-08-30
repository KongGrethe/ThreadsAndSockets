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
import java.net.Socket;

/**
 *
 * @author christian
 * 
 * Det man gør når en socket skal laves, starter vi med at oprette en socket i klassen.
 * En socket skal tilknyttes en port og en IP-Addresse. Der findes 65535 porte 
 * i en computer, hvoraf de første 1024 (0-1023) er reserveret. 
 * 
 * 
 */


public class SocketClient {
    
    //
    
    public static void main(String[] args) throws IOException {
        
        String ip = "localHost";
        int port = 9991; 
        //Her opretter vi en socket fra client
        Socket s = new Socket(ip, port);
        // når der er forbundet sendes denne streng til serveren.
        String testString = "Hej server! Fra Christian";
        
        // For at kunne sende strengen til serveren skal vi først lave en output 
        // stream. 
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        // Herefter laver vi en PrintWriter, som skal omdanne outputstreamen fra 
        //
        PrintWriter out = new PrintWriter(os);
        out.println(testString);
        out.flush();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = br.readLine();
        
        System.out.println("servers data: " + str);
        
//        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//        String stri = br.readLine();
//        System.out.println("Message from server: " + stri);
    }
    
}
