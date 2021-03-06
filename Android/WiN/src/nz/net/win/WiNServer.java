package nz.net.win;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import android.util.Log;

public class WiNServer implements Runnable {
        public static final int MCAST_PORT = 8946;
    public static final String MCAST_ADDR = "224.168.2.9";
    public static final int DGRAM_LEN = 1024;
    public static final int TIME_TO_LIVE = 1;
        MulticastSocket sock;
    DatagramPacket pack;
    
    public WiNServer()
    {
        try
        {
            sock = new MulticastSocket(MCAST_PORT);
            sock.joinGroup(InetAddress.getByName(MCAST_ADDR));
        }
        catch(Exception e)
        {
            Log.e("Error: " ,e.getMessage());
        }
    }
    @Override
    public void run()
    {
            //Get message to send
            String formattedMessage = MainActivity.formattedMessage();
            
            int loop = 0;
            while (loop <= 50) {
                    try
                    {
                            pack = new DatagramPacket(formattedMessage.getBytes(), formattedMessage.getBytes().length, InetAddress.getByName(MCAST_ADDR), MCAST_PORT);
                            sock.setTimeToLive(TIME_TO_LIVE);
                            sock.send(pack);
                            loop++;
                    }
                    catch(Exception e)
                    {
                            Log.e("Error: ", e.getMessage());
                    }
            }
    }
}