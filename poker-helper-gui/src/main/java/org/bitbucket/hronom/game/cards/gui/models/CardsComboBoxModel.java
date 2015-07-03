package org.bitbucket.hronom.game.cards.gui.models;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.PokerDeck;

import javax.swing.*;
import javax.swing.event.ListDataListener;

/**
 * Created by hronom on 29.06.15.
 */
public class CardsComboBoxModel implements ComboBoxModel<Card> {
    private Object selectedItem = null;

    public CardsComboBoxModel() {
        //selectedItem = PokerDeck.cards.get(0);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return PokerDeck.cards.size() + 1;
    }

    @Override
    public Card getElementAt(int index) {
        if (index == 0) {
            return null;
        } else {
            return PokerDeck.cards.get(index - 1);
        }
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
