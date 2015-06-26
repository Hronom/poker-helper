package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;

/**
 * Created by hronom on 20.06.15.
 */
public interface PokerHand {
    int getRating();
    boolean isAcceptableCombination(Card cards[]);
}
