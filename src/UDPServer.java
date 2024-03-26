import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        while (true) {

            System.out.println("Server is Running");
            DatagramSocket ds = new DatagramSocket(8000);
            System.out.println("Server Waiting For Incoming Packet");
            byte[] data = new byte[1024];
            DatagramPacket dp = new DatagramPacket(data, data.length);
            ds.receive(dp);
            String str = new String(dp.getData());
            // System.out.println(str);

            // Extract Data From Client and Convert into Understandeble
            int i = 0;
            String[] arrOfArray = str.split(",");
            String[][] extractedData = new String[8][3];
            for (String key : arrOfArray) {
                String[] temp = key.split(":");
                if (i < 8) {
                    int j = 0;
                    extractedData[i][j] = temp[j];
                    j++;
                    extractedData[i][j] = temp[j];
                    i++;
                }
            }

            for (i = 0; i < 8; i++) {
                int j = 1;
                Double a = Double.parseDouble(extractedData[i][j]);
                System.out.println(extractedData[i][j]);
                if (a == 1.0) {
                    extractedData[i][2] = "terrible";
                } else if (a == 2.0) {
                    extractedData[i][2] = "disgusting";
                } else if (a == 3.0) {
                    extractedData[i][2] = "Good";
                } else if (a == 4.0) {
                    extractedData[i][2] = "awesome";
                } else {
                    extractedData[i][2] = "delicious";
                }
            }

            // Preparing String Data to Send Client
            String sendStr = "";
            for (i = 0; i < 8; i++) {
                sendStr = sendStr + extractedData[i][2] + ",";
            }

            // Sending Packet TO Client Foe acknowledgement
            byte[] sendData = sendStr.getBytes();
            InetAddress ip = dp.getAddress();
            int port = dp.getPort();
            DatagramPacket dp1 = new DatagramPacket(sendData, sendData.length, ip, port);
            ds.send(dp1);
        }
    }
}
