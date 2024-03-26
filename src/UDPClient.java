
import java.io.File;
import java.io.FileWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        String filePath = "./data.txt";
        File myObj = new File(filePath);
        Scanner myReader = new Scanner(myObj);
        String data = "";
        while (myReader.hasNextLine()) {
            data = data + myReader.nextLine();
        }
        // System.out.println(data);
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte[] byteData = data.toString().getBytes();
        DatagramPacket dp = new DatagramPacket(byteData, byteData.length, ip, 8000);
        ds.send(dp);

        byte[] recData = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(recData, recData.length);
        ds.receive(dp1);
        String recString = new String(dp1.getData(), 0, dp1.getLength());
        System.out.println("Received response from server: " + recString);

        try(FileWriter writer = new FileWriter("./extractedData.txt")){
            writer.write(recString);
        }
        
        ds.close();
        myReader.close();
    }
}
