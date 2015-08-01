package com.github.hronom.game.cards.gui.models;

import com.github.hronom.poker.helper.core.cards.Card;
import com.github.hronom.poker.helper.core.cards.PokerDeck;

import javax.swing.*;

/**
 * Created by hronom on 29.06.15.
 */
public class CardsComboBoxModel extends AbstractListModel<Card> implements ComboBoxModel<Card> {
    private Object selectedObject = null;

    public CardsComboBoxModel() {
        //selectedItem = PokerDeck.cards.get(0);
    }

    @Override
    public void setSelectedItem(Object anObject) {
        if ((selectedObject != null && !selectedObject.equals(anObject)) ||
            selectedObject == null && anObject != null) {
            selectedObject = anObject;
            fireContentsChanged(this, -1, -1);
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedObject;
    }

    @Override
    public int getSize() {
        return PokerDeck.cards.size() + 1;
    }

    @Override
    public Card getElementAt(int index) {
        if (index > 0) {
            return PokerDeck.cards.get(index - 1);
        }

        return null;
    }
}
