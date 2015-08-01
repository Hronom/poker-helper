package com.github.hronom.poker.helper.core.poker.hands;

import com.github.hronom.poker.helper.core.cards.Card;
import com.github.hronom.poker.helper.core.cards.CardSuitType;
import com.github.hronom.poker.helper.core.poker.hands.utils.PokerHandsUtils;

/**
 * Роял-флаш (англ. royal flush — «королевская масть»): не является отдельной комбинацией, а
 * является частным случаем стрейт-флаша, старшим из всех возможных, и состоит из 5 старших (туз,
 * король, дама, валет, десять) карт одной масти, например: Т♥ К♥ Д♥ В♥ 10♥.
 */
public class RoyalFlush implements PokerHand {
    @Override
    public int getRating() {
        return 9;
    }

    @Override
    public boolean isAcceptableCombination(Card[] cards) {
        if (!PokerHandsUtils.checkOneSuit(cards, 5)) {
            return false;
        }

        if (!isAcceptableCards(cards)) {
            return false;
        }

        return true;
    }

    private boolean isAcceptableCards(Card[] cards) {
        for (CardSuitType cardSuitType : CardSuitType.values()) {
            int count = 0;
            for (Card card : cards) {
                if (card != null) {
                    if (card.suitType == cardSuitType) {
                        switch (card.denominationType) {
                            case D10:
                            case JACK:
                            case QUEEN:
                            case KING:
                            case ACE:
                                count++;
                        }
                    }
                }
            }

            if (count >= 5) {
                return true;
            }
        }

        return false;
    }
}
