package ChatServer;
/**
 * Created by marcu on 11/3/2015.
 */

public class CircularBuffer {
    private int size;
    private String num = "0000";
    private String[] buffer;
    private String mess;
    int count = 0;
    public CircularBuffer(int size) {
        this.size = size;
        buffer = new String[size];
    }
    public void put(String message) {
        int num1 = Integer.parseInt(num);
        if (num1 < size) {
            mess = num1 + ") " + message;
            buffer[num1] = mess;
        } else if (buffer[size - 1] != null) {

        }
        num1++;
        num = Integer.toString(num1);
    }
    public String[] getNewest(int numMessages) {
        String[] messages = new String[numMessages];
        int num2 = Integer.parseInt(num);
        if (numMessages < 0) {
            return null;
        } else if (numMessages == 0) {
            String[] empty = new String[0];
            return empty;
        }
    }
}
