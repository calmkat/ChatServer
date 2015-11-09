package ChatServer;
/**
 * Created by marcu on 11/3/2015.
 */
public class SessionCookie {
    private long id;
    public static int timeoutLength = 300;
    long time = System.currentTimeMillis();
    public SessionCookie(long id) {
        this.id = id;
    }
    public boolean hasTimedOut() {
        long time1 = System.currentTimeMillis();
        long elapsed = time - time1;
        if (elapsed / 100 > timeoutLength) {
            return true;
        } else {
            return false;
        }
    }
    public void updateTimeOfActivity() {
        int time =
    }
    public long getID() {
        return id;
    }
}

