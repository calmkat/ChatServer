package ChatServer;
/**
 * Created by marcu on 11/3/2015.
 */

public class CircularBuffer {
    private int size;
    private String[] buffer;
    SessionCookie sessionCookie = new SessionCookie((long) Math.floor(10000 * Math.random()));
    int lastMessageBufferIndex = 0;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new String[size];
    }

    public void put(String message) {
        for (int i = 0; i < size; i++) {
            buffer[i] = sessionCookie.getID() + ") " + message;
            lastMessageBufferIndex = i;
            if (i == 5) {
                i = 0;
            }
        }
    }

    public String[] getNewest(int numMessages) {
        String[] error = new String[1];
        error[0] = "error";
        String[] messageArray = new String[size];
        String[] nullArray = new String[0];
        if (numMessages > size || numMessages < 1) {
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
