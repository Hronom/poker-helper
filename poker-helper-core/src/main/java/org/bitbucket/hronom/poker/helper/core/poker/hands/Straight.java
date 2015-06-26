package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.poker.hands.utils.PokerHandsUtils;

/**
 * Стрейт (англ. straight — «порядок») или «стрит»: пять карт по порядку любых мастей, например: 5♦
 * 4♥ 3♠ 2♦ Т♦. Туз может как начинать порядок, так и заканчивать его. В данном примере Т♦ начинает
 * комбинацию и его достоинство оценивается в единицу, а 5♦ считается старшей картой. Самый младший
 * стрейт (от туза до пятерки) иногда именуют «колесо».
 */
public class Straight implements PokerHand {
    @Override
    public int getRating() {
        return 4;
    }

    @Override
    public boolean isAcceptableCombination(Card[] cards) {
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
