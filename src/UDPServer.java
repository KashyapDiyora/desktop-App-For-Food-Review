import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    public void udpServer() {
        try {
            System.out.println("Server is Running");
            try (DatagramSocket ds = new DatagramSocket(8000)) 
            {
                System.out.println("Server Waiting For Incoming Packet");

                while (true) 
                {

                    // Receive Packet From Client Which is Loaded with food review data
                    byte[] data = new byte[1024];
                    DatagramPacket dp = new DatagramPacket(data, data.length);
                    ds.receive(dp);
                    String recStr = new String(dp.getData());

                    // Extract Data and according data send acknowledgment to Client
                    String[] extractedData = recStr.split(",");
                    String reviewStr = "";

                    for (int i = 0; i < extractedData.length; i++) 
                    {
                        try 
                        {
                            int tempData = (int) Double.parseDouble(extractedData[i].trim());
                            if (tempData == 1) {
                                reviewStr += "terrible,";
                            } else if (tempData == 2) {
                                reviewStr += "disgusting,";
                            } else if (tempData == 3) {
                                reviewStr += "Good,";
                            } else if (tempData == 4) {
                                reviewStr += "awesome,";
                            } else {
                                reviewStr += "delicious,";
                            }
                        } 
                        catch (NumberFormatException e) 
                        {
                        }
                    }

                    // After Extracting Data make packet and send to Client

                    byte[] sendDataBytes = reviewStr.getBytes();
                    DatagramPacket dp1 = new DatagramPacket(sendDataBytes, sendDataBytes.length, dp.getAddress(),
                            dp.getPort());
                    ds.send(dp1);
                    System.out.println(reviewStr);
                }
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        UDPServer server = new UDPServer();
        server.udpServer();
    }
}
