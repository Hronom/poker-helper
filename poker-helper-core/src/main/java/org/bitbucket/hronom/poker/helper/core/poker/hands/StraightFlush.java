package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.poker.hands.utils.PokerHandsUtils;

/**
 * Стрейт-флаш (англ. straight flush — «масть по порядку»): любые пять карт одной масти по порядку,
 * например: 9♠ 8♠ 7♠ 6♠ 5♠. Туз может как начинать порядок, так и заканчивать его.
 */
public class StraightFlush implements PokerHand {
    @Override
    public int getRating() {
        return 8;
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
        short countOfHighLowCards = 0;
        for (Card currentCard : cards) {
            short countOfAcceptableNeighbors = 0;
            if (currentCard != null) {
                for (Card checkCard : cards) {
                    if (checkCard != null) {
                        if (currentCard != checkCard) {
                            if (PokerHandsUtils
                                    .getCardDenominationSequenceNumber(currentCard.denominationType) ==
                                PokerHandsUtils
                                    .getCardDenominationSequenceNumber(checkCard.denominationType) -
                                1) {
                                countOfAcceptableNeighbors++;
                            } else if (PokerHandsUtils
                                           .getCardDenominationSequenceNumber(currentCard.denominationType) -
                                       1 == PokerHandsUtils
                                           .getCardDenominationSequenceNumber(checkCard.denominationType)) {
                                countOfAcceptableNeighbors++;
                            }
                            // Exception for Aces
                            else if ((currentCard.denominationType == CardDenominationType.ACE ||
                                      checkCard.denominationType == CardDenominationType.ACE) &&
                                     ((currentCard.denominationType == CardDenominationType.D2 ||
                                       checkCard.denominationType == CardDenominationType.D2) ||
                                      (currentCard.denominationType == CardDenominationType.KING ||
                                       checkCard.denominationType == CardDenominationType.KING))) {
                                countOfAcceptableNeighbors++;
                            }
                        }
                    }
                }

                if (countOfAcceptableNeighbors == 1) {
                    countOfHighLowCards++;
                } else if (countOfAcceptableNeighbors != 2) {
                    return false;
                }
            }
        }

        // Check count of high/low cards
        if (countOfHighLowCards != 2) {
            return false;
        }

        return true;
    }
}
