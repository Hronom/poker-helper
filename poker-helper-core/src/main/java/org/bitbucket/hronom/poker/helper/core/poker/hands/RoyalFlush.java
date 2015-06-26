package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.poker.hands.utils.PokerHandsUtils;

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
        for (Card card : cards) {
            if (card != null) {
                switch (card.denominationType) {
                    case D2:
                    case D3:
                    case D4:
                    case D5:
                    case D6:
                    case D7:
                    case D8:
                    case D9:
                        return false;
                }
            }
        }
        return true;
    }
}
