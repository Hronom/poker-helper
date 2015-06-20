package org.bitbucket.hronom.poker.helper.core.poker.hands.utils;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;

/**
 * Created by hronom on 20.06.15.
 */
public final class PokerHandsUtils {
    private PokerHandsUtils() {

    }

    public static boolean checkOneSuit(Card[] cards, int countOfOneSuitCards) {
        for (Card currentCard : cards) {
            int countOfCards = 0;
            if (currentCard != null) {
                for (Card checkCard : cards) {
                    if (checkCard != null) {
                        if (currentCard != checkCard) {
                            if (currentCard.suitType == checkCard.suitType) {
                                countOfCards++;
                            }
                        }
                    }
                }
            }

            if (countOfCards + 1 == countOfOneSuitCards) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkOneDenomination(Card[] cards, int countOfOneDenominationCards) {
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

            if (countOfCards + 1 == countOfOneDenominationCards) {
                return true;
            }
        }

        return false;
    }

    public static short getCardDenominationSequenceNumber(CardDenominationType denominationType) {
        switch (denominationType) {
            case ACE:
                return 1;
            case D2:
                return 2;
            case D3:
                return 3;
            case D4:
                return 4;
            case D5:
                return 5;
            case D6:
                return 6;
            case D7:
                return 7;
            case D8:
                return 8;
            case D9:
                return 9;
            case D10:
                return 10;
            case JACK:
                return 11;
            case QUEEN:
                return 12;
            case KING:
                return 13;
            default:
                return -1;
        }
    }
}
