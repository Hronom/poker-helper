package com.github.hronom.poker.helper.core.poker.hands;

import com.github.hronom.poker.helper.core.cards.Card;
import com.github.hronom.poker.helper.core.cards.CardDenominationType;

/**
 * Фул-хаус/Полный дом/Три плюс два (англ. full house, full boat — «полный дом», «полная лодка»):
 * одна тройка и одна пара, например: 10♥ 10♦ 10♠ 8♣ 8♥.
 */
public class FullHouse implements PokerHand {
    @Override
    public int getRating() {
        return 6;
    }

    @Override
    public boolean isAcceptableCombination(Card[] cards) {
        if (!checkCards(cards)) {
            return false;
        }

        return true;
    }

    private boolean checkCards(Card[] cards) {
        // Check two pairs
        CardDenominationType twoCardDenominationType = null;
        for (Card currentCard : cards) {
            int countOfCards = 0;
            if (currentCard != null) {
                for (Card checkCard : cards) {
                    if (checkCard != null) {
                        if (currentCard != checkCard) {
                            if (currentCard.denominationType == checkCard.denominationType) {
                                countOfCards++;
                            }
                        }
                    }
                }
            }

            if (countOfCards == 1) {
                twoCardDenominationType = currentCard.denominationType;
                break;
            }
        }

        if (twoCardDenominationType == null) {
            return false;
        }

        // Check three pairs
        CardDenominationType threeCardDenominationType = null;
        for (Card currentCard : cards) {
            int countOfCards = 0;
            if (currentCard != null) {
                for (Card checkCard : cards) {
                    if (checkCard != null) {
                        if (currentCard != checkCard) {
                            if (currentCard.denominationType == checkCard.denominationType &&
                                twoCardDenominationType != currentCard.denominationType) {
                                countOfCards++;
                            }
                        }
                    }
                }
            }

            if (countOfCards == 2) {
                threeCardDenominationType = currentCard.denominationType;
                break;
            }
        }

        return threeCardDenominationType != null;
    }
}
