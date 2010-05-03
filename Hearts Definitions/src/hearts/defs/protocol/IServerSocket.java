package hearts.defs.protocol;

/**
 * Socket do serwera po stronie klienta<br/>
 * getId() powinno zwracać GameConstants.SERVER
 * @author szymon
 */
public interface IServerSocket extends IObjectSocket, IMaintenaceListener, IMaintenanceNotifier {

    public boolean isLoggedIn();

    public void setLoggedIn(boolean loggedIn);
}
