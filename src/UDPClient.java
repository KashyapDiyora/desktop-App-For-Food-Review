import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

    public String udpClient(String data) throws SocketException, UnknownHostException, IOException {
        String recString = "";

        try(DatagramSocket ds = new DatagramSocket()) {        
                InetAddress ip = InetAddress.getLocalHost();

                // make udp lacket then send to server
                
                byte[] byteData = data.getBytes();
                DatagramPacket dp = new DatagramPacket(byteData, byteData.length, ip, 8000);
                ds.send(dp);

                // After Processing Data which is given by Client then Server Will send data to Client 

                System.out.println("recevicing");
                byte[] recData = new byte[1024];
                DatagramPacket dp1 = new DatagramPacket(recData, recData.length);
                ds.receive(dp1);
                recString = new String(dp1.getData());
                System.out.println("Received response from server: " + recString);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
            throw e; 
        }
        return recString; 
    }
}
