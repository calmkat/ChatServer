package ChatServer;
/**
 * Created by marcu on 11/3/2015.
 */

public class CircularBuffer {
    int num = 0;
    private String[] buffer;
    private String message;
    String sessionCookie = "0000";
    int lastMessageBufferIndex = 0;

    public CircularBuffer(String message) {
        this.buffer = new String[6];
        this.message = message;
    }

    public void put(String message) {
        for (int i = 0; i < 6; i++) {
            if (num < 10) {
                sessionCookie = "000" + num;
            } else if (num < 100 && num > 9) {
                sessionCookie = "00" + num;
            } else if (num < 1000 && num > 99) {
                sessionCookie = "0" + num;
            } else {
                sessionCookie = String.valueOf(num);
            }
            buffer[i] = sessionCookie + message;
            lastMessageBufferIndex = i;
            num++;
            if (i == 5) {
                i = 0;
            }
        }
    }

    public String[] getNewest(int numMessages) {
        String[] error = new String[1];
        error[0] = "error";
        String[] messageArray = new String[6];
        String[] nullArray = new String[0];
        if (numMessages > 6 || numMessages < 1) {
            return error;
        } else if (numMessages == 0) {
            return nullArray;
        } else {
            for (int i = 0; i < numMessages; i++) {
                int back = lastMessageBufferIndex - i;
                if (back < 0) {
                    back += 6;
                }
                messageArray[i] = buffer[back];
            }
            return messageArray;
        }
    }
}
