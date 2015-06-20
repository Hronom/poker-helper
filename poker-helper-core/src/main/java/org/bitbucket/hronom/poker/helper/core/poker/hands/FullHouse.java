package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.poker.hands.utils.PokerHandsUtils;

/**
 * Фул-хаус/Полный дом/Три плюс два (англ. full house, full boat — «полный дом», «полная лодка»):
 * одна тройка и одна пара, например: 10♥ 10♦ 10♠ 8♣ 8♥.
 */
public class FullHouse implements PokerHand {
    @Override
    public boolean isAcceptableCombination(Card[] cards) {
        if (!PokerHandsUtils.checkOneDenomination(cards, 3) &&
            !PokerHandsUtils.checkOneDenomination(cards, 2)) {
            return false;
        }

        return true;
    }
}
