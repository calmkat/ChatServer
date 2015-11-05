package ChatServer;
/**
 * Created by marcu on 11/3/2015.
 */
public class SessionCookie {
    private long id;
    public static int timeoutLength = 300;
    public SessionCookie(long id) {
        this.id = id;
    }
    public boolean hasTimedOut() {
        //long time = System.currentTimeMillis();
        //long time1 = System.currentTimeMillis();
        //long elapsed = time - time1;
        if (System.currentTimeMillis() / 100 > timeoutLength) {
            return true;
        } else {
            return false;
        }
    }
    public void updateTimeOfActivity() {

    }
    public long getID() {
        return id;
    }
}

