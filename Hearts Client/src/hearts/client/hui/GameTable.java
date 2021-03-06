/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * gameTable.java
 *
 * Created on 2010-05-06, 19:06:12
 */
package hearts.client.hui;

import hearts.client.hui.details.CardClickListener;
import hearts.client.hui.details.CardIcon;
import hearts.client.hui.details.CardPlaceHolder;
import hearts.client.hui.details.OpponentCardsStack;
import hearts.client.hui.details.PointsTableModel;
import hearts.defs.state.CardColor;
import hearts.defs.state.GameConstants;
import hearts.defs.state.GameStateException;
import hearts.defs.state.IAuctionPanel;
import hearts.defs.state.ICard;
import hearts.defs.state.IGUIGameTable;
import hearts.defs.state.IGUIPanel.Panel;
import hearts.defs.state.IGUIState;
import hearts.defs.state.IGameState.Mode;
import hearts.defs.state.IOpponentCardStack;
import hearts.defs.state.ITrick;
import hearts.state.Card;
import hearts.state.actions.ChatAction;
import hearts.state.actions.gui.AddCardToTrickGUIAction;
import hearts.state.exceptions.WrongCardValueException;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author szymon
 */
public class GameTable extends javax.swing.JPanel implements IGUIGameTable {

    private CardPlaceHolder[] placeHolders = new CardPlaceHolder[13];
    protected CardClickListener[] cardClickListeners =
            new CardClickListener[13];
    protected IGUIState gui;
    protected Mode mode = null;
    protected String tableName = null;
    protected JLabel[] playerLabels;
    protected String[] playerNames = {null, null, null, null};
    protected int[] playerTricks = {0, 0, 0, 0};
    //protected int[] playerPoints = {0, 0, 0, 0};
    protected OpponentCardsStack[] cardsStacks;
    protected PointsTableModel pointsModel = new PointsTableModel();

    /** Creates new form gameTable */
    public GameTable() {
        initComponents();
        for (int i = 0; i < placeHolders.length; ++i) {
            CardPlaceHolder holder = new CardPlaceHolder();
            // gui jest i tak null, więc null
            CardClickListener listener = new CardClickListener(null, holder);

            holder.addMouseListener(listener);
            placeHolders[i] = holder;
            cardClickListeners[i] = listener;
            cardsPanel.add(holder);
        }
        // dodanie jednego placeholdera na koniec:
        cardsPanel.add(new CardPlaceHolder());


        JLabel[] playerLabelsTMP = {userLabel, opponentLabel1,
                                    opponentLabel2, opponentLabel3};
        playerLabels = playerLabelsTMP;

        OpponentCardsStack[] cardsStacksTMP = {null, opponentCardsStack1,
                                               opponentCardsStack2, opponentCardsStack3};
        cardsStacks = cardsStacksTMP;

        //uglyTest();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        auctionPanel = new hearts.client.hui.AuctionPanel();
        opponentCardsStack2 = new hearts.client.hui.details.OpponentCardsStack();
        opponentCardsStack1 = new hearts.client.hui.details.OpponentCardsStack();
        opponentCardsStack3 = new hearts.client.hui.details.OpponentCardsStack();
        cardsPanel = new javax.swing.JPanel();
        trick = new hearts.client.hui.details.GUITrick();
        opponentLabel2 = new javax.swing.JLabel();
        opponentLabel3 = new javax.swing.JLabel();
        opponentLabel1 = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        chatScrollPane = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        chatInput = new javax.swing.JTextField();
        pointsScrollPane = new javax.swing.JScrollPane();
        pointsTable = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        opponentCardsStack2.setVertical(false);

        javax.swing.GroupLayout opponentCardsStack2Layout = new javax.swing.GroupLayout(opponentCardsStack2);
        opponentCardsStack2.setLayout(opponentCardsStack2Layout);
        opponentCardsStack2Layout.setHorizontalGroup(
            opponentCardsStack2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );
        opponentCardsStack2Layout.setVerticalGroup(
            opponentCardsStack2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(opponentCardsStack2, gridBagConstraints);

        opponentCardsStack1.setInverted(true);

        javax.swing.GroupLayout opponentCardsStack1Layout = new javax.swing.GroupLayout(opponentCardsStack1);
        opponentCardsStack1.setLayout(opponentCardsStack1Layout);
        opponentCardsStack1Layout.setHorizontalGroup(
            opponentCardsStack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );
        opponentCardsStack1Layout.setVerticalGroup(
            opponentCardsStack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        add(opponentCardsStack1, gridBagConstraints);

        javax.swing.GroupLayout opponentCardsStack3Layout = new javax.swing.GroupLayout(opponentCardsStack3);
        opponentCardsStack3.setLayout(opponentCardsStack3Layout);
        opponentCardsStack3Layout.setHorizontalGroup(
            opponentCardsStack3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );
        opponentCardsStack3Layout.setVerticalGroup(
            opponentCardsStack3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        add(opponentCardsStack3, gridBagConstraints);

        cardsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Karty do wyłożenia", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BELOW_TOP));
        cardsPanel.setLayout(new java.awt.GridLayout(2, 7, 3, 3));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(cardsPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(trick, gridBagConstraints);

        opponentLabel2.setText("przeciwnik2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 10, 2);
        add(opponentLabel2, gridBagConstraints);

        opponentLabel3.setText("przeciwnik3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 2);
        add(opponentLabel3, gridBagConstraints);

        opponentLabel1.setText("przeciwnik1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 10);
        add(opponentLabel1, gridBagConstraints);

        userLabel.setText("user");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 2, 2);
        add(userLabel, gridBagConstraints);

        chatScrollPane.setMinimumSize(new java.awt.Dimension(200, 27));
        chatScrollPane.setPreferredSize(new java.awt.Dimension(200, 87));

        chatArea.setColumns(10);
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setRows(5);
        chatArea.setTabSize(4);
        chatScrollPane.setViewportView(chatArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(chatScrollPane, gridBagConstraints);

        chatInput.setMinimumSize(new java.awt.Dimension(140, 29));
        chatInput.setPreferredSize(new java.awt.Dimension(120, 29));
        chatInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                chatInputKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(chatInput, gridBagConstraints);

        pointsTable.setModel(pointsModel);
        pointsScrollPane.setViewportView(pointsTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(pointsScrollPane, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void chatInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chatInputKeyTyped
        if (evt.getKeyChar() == '\n') {
            if (gui.getSocket() == null) {
                System.out.println("Nie ma socketa!");
                return;
            }
            gui.getSocket().actionReceived(
                    new ChatAction(GameConstants.ALL_USERS,
                    chatInput.getText()));
            chatInput.setText("");
        }
    }//GEN-LAST:event_chatInputKeyTyped
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hearts.client.hui.AuctionPanel auctionPanel;
    private javax.swing.JPanel cardsPanel;
    private javax.swing.JTextArea chatArea;
    private javax.swing.JTextField chatInput;
    private javax.swing.JScrollPane chatScrollPane;
    private hearts.client.hui.details.OpponentCardsStack opponentCardsStack1;
    private hearts.client.hui.details.OpponentCardsStack opponentCardsStack2;
    private hearts.client.hui.details.OpponentCardsStack opponentCardsStack3;
    private javax.swing.JLabel opponentLabel1;
    private javax.swing.JLabel opponentLabel2;
    private javax.swing.JLabel opponentLabel3;
    private javax.swing.JScrollPane pointsScrollPane;
    private javax.swing.JTable pointsTable;
    private hearts.client.hui.details.GUITrick trick;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables

    public Panel getPanelType() {
        return Panel.GAME;
    }

    public void setCards(ICard[] cards) {
        int i = 0;

        // ustawianie kart
        for (; i < cards.length && i < placeHolders.length; ++i) {
            placeHolders[i].setCardIcon(new CardIcon(cards[i]));
        }
        // kasowanie ew. pozostałych kart
        for (; i < placeHolders.length; ++i) {
            placeHolders[i].setCardIcon(null);
        }
    }

    public void setFlipped(boolean flipped) {
        for (CardPlaceHolder placeHolder : placeHolders) {
            placeHolder.setFlipped(flipped);
        }
    }

    public void uglyTest() {
        try {
            ICard[] cards = new ICard[13];
            for (int i = 0; i < 13; ++i) {
                try {
                    cards[i] = new Card(CardColor.HEART, i + 2);
                } catch (WrongCardValueException ex) {
                    Logger.getLogger(GameTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.setCards(cards);
            this.setFlipped(false);
            this.trick.setUserId(2);
            this.trick.setActiveUser(2);

            AddCardToTrickGUIAction acttguia = new AddCardToTrickGUIAction(0);
            acttguia.setCard(new Card(CardColor.HEART, 10));
            this.gui.actionReceived(acttguia);
            this.setActiveUser(3);

            AddCardToTrickGUIAction act2 = new AddCardToTrickGUIAction(0);
            act2.setCard(new Card(CardColor.DIAMOND, 14));
            this.gui.actionReceived(act2);
            this.setActiveUser(0);

        } catch (WrongCardValueException ex) {
            Logger.getLogger(GameTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ITrick getTrick() {
        return this.trick;
    }

    public void clearTrick() {
        this.trick.clear();
    }

    public void setGui(IGUIState gui) {
        this.gui = gui;
        for (CardClickListener listener : cardClickListeners) {
            listener.setGui(gui);
        }

        auctionPanel.setGui(gui);
    }

    public void setUser(int id, String name) {
        playerNames[id] = name;
        refreshPlayerLabel(id);
        pointsModel.setColumnIdentifiers(playerNames);
    }

    public String getUserName(int id) {
        return playerNames[id];
    }

    private void refreshPlayerLabel(int id) {
        playerLabels[trick.getPlace(id)].setText(
                playerNames[id] + ", " + playerTricks[id]);
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Mode getMode() {
        return mode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String name) {
        this.tableName = name;
    }

    public void setLocalUserId(int id) {
        // TODO gdzies jeszcze ustawic?
        trick.setUserId(id);
    }

    public int getLocalUserId() {
        return trick.getUserId();
    }

    public void appendToChatArea(String line) {
        chatArea.append('\n' + line);
        chatArea.setCaretPosition(chatArea.getText().length() - 1);
    }

    public void setActiveUser(int id) {
        this.trick.setActiveUser(id);
    }

    public int getActiveUser() {
        return this.trick.getActiveUser();
    }

    public IOpponentCardStack getCardsStack(int id) {
        return cardsStacks[trick.getPlace(id)];
    }

    public void withdrawCard(ICard c) throws GameStateException {
        boolean success = false;
        for (CardPlaceHolder holder : placeHolders) {
            CardIcon ci = holder.getCardIcon();
            if (ci != null && ci.equals(c)) {
                holder.setCardIcon(null);
                success = true;
                break;
            }
        }
        if (!success) {
            throw new GameStateException("Cant find " + c + " in user stack");
        }
    }

    public void showChooseTrumpDialog() {
        ChooseTrumpDialog dialog =
                new ChooseTrumpDialog((JFrame) gui, true);
        dialog.setGui(gui);
        dialog.setVisible(true);
    }

    public void setPoints(List<Integer>[] points) {
//        int lastRowNum = points[0].size() - 1;
//        if (lastRowNum >= 0) {
//            Integer[] tmp = new Integer[4];
//            for(int i = 0; i < points.length; ++i) {
//                tmp[i] = points[i].get(lastRowNum);
//            }
//            this.points.insertRow(lastRowNum, points);
//        }
        // musimy przerobić tablicę kolumn w tablicę rzędów:
        ListIterator<Integer>[] columnIterators = new ListIterator[4];
        int rowCount = Integer.MAX_VALUE;

        for (int i = 0; i < 4; ++i) {
            List<Integer> p = points[i];
            int size = p.size();
            columnIterators[i] = p.listIterator();
            if (size < rowCount) {
                rowCount = size;
            }
        }

        Integer[][] data = new Integer[rowCount][4];

        for(int r = 0; r < rowCount; ++r) {
            for(int c = 0; c < 4; ++c) {
                data[r][c] = columnIterators[c].next();
            }
        }

        pointsModel.setDataVector(data, playerNames);
    }

    public void setUserTricks(int id, int tricks) {
        playerTricks[id] = tricks;
        refreshPlayerLabel(id);
    }

    public void increaseUserTricks(int id) {
        playerTricks[id]++;
        refreshPlayerLabel(id);
    }

    public void reset() {
        clearTrick();
        setTableName(null);
        for (int i = 0; i < 4; ++i) {
            playerNames[i] = "";
            //playerPoints[i] = 0;
            playerTricks[i] = 0;
            refreshPlayerLabel(i);
        }
        // TODO wiecej fajnego stuffu
    }

    /**
     * Pokazuje panel aukcji, gdy show, badz panel wziatki gdy ~show.
     * @param show
     */
    public void showAuction(boolean show) {
        boolean trickVisible = false;
        boolean auctionVisible = false;
        for (Component c : this.getComponents()) {
            if (c == trick) {
                trickVisible = true;
            } else if (c == auctionPanel) {
                auctionVisible = true;
            }
        }

        invalidate();
        if (show && trickVisible) {
            GridBagConstraints constraints = ((GridBagLayout) this.getLayout()).getConstraints(trick);
            this.remove(trick);
            this.add(auctionPanel, constraints);
        } else if (!show && auctionVisible) {
            GridBagConstraints constraints = ((GridBagLayout) this.getLayout()).getConstraints(auctionPanel);
            this.remove(auctionPanel);
            this.add(trick, constraints);
        }

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                repaint();
            }
        });
    }

    public IAuctionPanel getAuctionPanel() {
        return auctionPanel;
    }
}
