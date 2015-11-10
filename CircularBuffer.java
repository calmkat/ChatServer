package ChatServer;

/**
 * Created by marcu on 11/3/2015.
 */

public class CircularBuffer {
    private int size;
    private String[] buffer;
    int lastMessageBufferIndex = 0;
    int num = 0;
    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new String[size];
    }

    public void put(String message) {
        SessionCookie sessionCookie = new SessionCookie(num);
        if (sessionCookie.getID() >= 0 && sessionCookie.getID() < 10) {
            buffer[num] = "000" + sessionCookie.getID() + ") " + message;
        } else if (sessionCookie.getID() >= 10 && sessionCookie.getID() < 100) {
            buffer[num] = "00" + sessionCookie.getID() + ") " + message;
        } else if (sessionCookie.getID() >= 100 && sessionCookie.getID() < 1000) {
            buffer[num] = "0" + sessionCookie.getID() + ") " + message;
        } else {
            buffer[num] = sessionCookie.getID() + ") " + message;
        }
        if (num >= 0 && num < 6) {
            lastMessageBufferIndex = num;
        } else {
            lastMessageBufferIndex = (num % 6) - (num / 6);
        }
        num++;
    }

    public String[] getNewest(int numMessages) {
        String[] messageArray;
        int nullCount = 0;
        /*for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == null) {
                nullCount++;
            }
        }*/
        if (numMessages > (buffer.length)) {
            messageArray = new String[buffer.length];
        } else {
            messageArray = new String[numMessages];
        }
        String[] nullArray = new String[0];
        if (numMessages == 0) {
            return nullArray;
        } else {
            for (int i = 0; i < numMessages; i++) {
                int back = lastMessageBufferIndex - i; //2
                if (back < 0) {
                    back += 5;
                }
                messageArray[back] = buffer[back]; //make this print backwards
            }
            return messageArray;
        }
    }
}
