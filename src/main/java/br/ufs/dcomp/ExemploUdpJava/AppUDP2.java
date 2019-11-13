package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;
import java.util.Scanner;

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{
            
            Scanner sc = new Scanner(System.in);
            //String message = sc.nextLine();
            
            System.out.print("[ Alocando porta UDP                  ..................  ");
        	DatagramSocket socket = new DatagramSocket(20000);
            System.out.println("[OK] ]");
            
            byte[] buf, msg_buf, received_data;
            DatagramPacket pack;
            //byte[] received_data;
            String received_msg, msg; 
            InetAddress origin_address, destination_address;
            int origin_port, msg_size, destination_port = 10000;
            //String msg;
            //byte[] msg_buf;
            //int msg_size;
            //InetAddress destination_address;
            //int destination_port = 10000;
                
            
            while(true) {
                /*Inicio do receive*/
                buf = new byte[200];
                pack = new DatagramPacket(buf, buf.length);
    
                System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
                socket.receive(pack);
                System.out.println("[OK] ]");
                
                received_data = pack.getData();
                received_msg = new String(received_data); 
                origin_address = pack.getAddress();
                origin_port = pack.getPort();
                
                System.out.println("  Mensagem:             "+received_msg);
                System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
                System.out.println("  Porta de origem:      "+origin_port);
                
                /*Fim do receive*/
                
                /*Inicio do send*/
                
                //String msg = "Olá!!!";
                msg = sc.nextLine();
                
                msg_buf = msg.getBytes();
                msg_size = msg_buf.length;
                destination_address = InetAddress.getLocalHost();
    
                System.out.print("[ Montando datagrama UDP  ..................  ");
                pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
                System.out.println("[OK] ]");
                
                System.out.print("[ Enviando datagrama UDP  ..................  ");
                socket.send(pack);
                System.out.println("[OK] ]");
                
                /*Fim do send*/
            }
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
      


    }
}