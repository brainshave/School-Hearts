/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hearts.state.actions.gui;

import hearts.defs.actions.gui.AGUIAction;
import hearts.defs.state.GUIStateException;
import hearts.defs.state.GameConstants;
import hearts.defs.state.IGUIState;
import hearts.state.actions.AuctionDecisionAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Akcja wysyłana do wychodzącego informacje kto wygrał licytację i jego ofertę.
 * @author Paweł Trynkiewicz
 */
public class AuctionEndGUIAction extends AGUIAction {

    public AuctionEndGUIAction(int receiver) {
        super(receiver);
    }
    int lider;
    int commece;
    int quotion;
    int activeUser;

    public int getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(int activeUser) {
        this.activeUser = activeUser;
    }

    public int getCommece() {
        return commece;
    }

    public void setCommece(int commece) {
        this.commece = commece;
    }

    public int getLider() {
        return lider;
    }

    public void setLider(int lider) {
        this.lider = lider;
    }

    public int getQuotion() {
        return quotion;
    }

    public void setQuotion(int quotion) {
        this.quotion = quotion;
    }

    @Override
    public void perform(IGUIState gui) throws GUIStateException {
        AuctionDecisionAction decision = new AuctionDecisionAction(GameConstants.SERVER);
        
        decision.setAccep(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
                (JFrame) gui,
                "Zaoferowano: " + quotion + ".\nPrzyjmujesz ofertę?",
                "Koniec aukcji",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE));

        gui.getSocket().actionReceived(decision);
    }
}
