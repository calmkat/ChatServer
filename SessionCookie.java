package ChatServer;
/**
 * Created by marcu on 11/3/2015.
 */
public class SessionCookie {
    private long id;
    long elapsed;
    public static int timeoutLength = 300;
    long time = System.currentTimeMillis();
    public SessionCookie(long id) {
        this.id = id;
    }
    public boolean hasTimedOut() {
        long time1 = System.currentTimeMillis();
        elapsed = time - time1;
        return ((elapsed / 100) > timeoutLength);
    }
    public void updateTimeOfActivity() {
        elapsed = 0;
    }
    public long getID() {
        return id;
    }
}

