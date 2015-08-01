package com.github.hronom.poker.helper.core.cards.utils;

import com.github.hronom.poker.helper.core.cards.Card;
import com.github.hronom.poker.helper.core.cards.PokerDeck;
import com.github.hronom.poker.helper.core.poker.hands.PokerHand;

import java.util.ArrayList;

/**
 * Created by hronom on 20.06.15.
 */
public final class CardsUtils {
    private CardsUtils() {
    }

    public static long countOutsCardsForTurn(ArrayList<Card> availableCards, PokerHand pokerHand) {
        ArrayList<Card> cardsTemp = new ArrayList<>();
        cardsTemp.addAll(PokerDeck.cards);

        long countOfCombinations = 0;

        int[] starts = new int[6];
        for (int i = 0; i < starts.length; i++) {
            starts[i] = availableCards.size() > i ? getIndex(cardsTemp, availableCards.get(i)) : 0;
        }

        int[] sizes = new int[6];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = availableCards.size() > i ? starts[i] + 1 : cardsTemp.size();
        }

        for (int index1 = starts[0]; index1 < sizes[0]; index1++) {
            for (int index2 = starts[1]; index2 < sizes[1]; index2++) {
                if (index1 != index2) {
                    for (int index3 = starts[2]; index3 < sizes[2]; index3++) {
                        if (index1 != index3 && index2 != index3) {
                            for (int index4 = starts[3]; index4 < sizes[3]; index4++) {
                                if (index1 != index4 && index2 != index4 && index3 != index4) {
                                    for (int index5 = starts[4]; index5 < sizes[4]; index5++) {
                                        if (index1 != index5 && index2 != index5 &&
                                            index3 != index5 && index4 != index5) {
                                            for (int index6 = starts[5]; index6 < sizes[5];
                                                 index6++) {
                                                if (index1 != index6 &&
                                                    index2 != index6 &&
                                                    index3 != index6 &&
                                                    index4 != index6 &&
                                                    index5 != index6) {
                                                    Card combination[] = new Card[6];
                                                    combination[0] = cardsTemp.get(index1);
                                                    combination[1] = cardsTemp.get(index2);
                                                    combination[2] = cardsTemp.get(index3);
                                                    combination[3] = cardsTemp.get(index4);
                                                    combination[4] = cardsTemp.get(index5);
                                                    combination[5] = cardsTemp.get(index6);

                                                    if (pokerHand
                                                        .isAcceptableCombination(combination)) {
                                                        countOfCombinations++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return countOfCombinations;
    }

    public static long countOutsCardsForRiver(ArrayList<Card> availableCards, PokerHand pokerHand) {
        ArrayList<Card> cardsTemp = new ArrayList<>();
        cardsTemp.addAll(PokerDeck.cards);

        long countOfCombinations = 0;

        int[] starts = new int[7];
        for (int i = 0; i < starts.length; i++) {
            starts[i] = availableCards.size() > i ? getIndex(cardsTemp, availableCards.get(i)) : 0;
        }

        int[] sizes = new int[7];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = availableCards.size() > i ? starts[i] + 1 : cardsTemp.size();
        }

        for (int index1 = starts[0]; index1 < sizes[0]; index1++) {
            for (int index2 = starts[1]; index2 < sizes[1]; index2++) {
                if (index1 != index2) {
                    for (int index3 = starts[2]; index3 < sizes[2]; index3++) {
                        if (index1 != index3 && index2 != index3) {
                            for (int index4 = starts[3]; index4 < sizes[3]; index4++) {
                                if (index1 != index4 && index2 != index4 && index3 != index4) {
                                    for (int index5 = starts[4]; index5 < sizes[4]; index5++) {
                                        if (index1 != index5 && index2 != index5 &&
                                            index3 != index5 && index4 != index5) {
                                            for (int index6 = starts[5]; index6 < sizes[5];
                                                 index6++) {
                                                if (index1 != index6 &&
                                                    index2 != index6 &&
                                                    index3 != index6 &&
                                                    index4 != index6 &&
                                                    index5 != index6) {
                                                    for (int index7 = starts[6]; index7 < sizes[6];
                                                         index7++) {
                                                        if (index1 != index7 &&
                                                            index2 != index7 &&
                                                            index3 != index7 &&
                                                            index4 != index7 &&
                                                            index5 != index7 &&
                                                            index6 != index7) {
                                                            Card combination[] = new Card[7];
                                                            combination[0] = cardsTemp.get(index1);
                                                            combination[1] = cardsTemp.get(index2);
                                                            combination[2] = cardsTemp.get(index3);
                                                            combination[3] = cardsTemp.get(index4);
                                                            combination[4] = cardsTemp.get(index5);
                                                            combination[5] = cardsTemp.get(index6);
                                                            combination[6] = cardsTemp.get(index7);

                                                            if (pokerHand
                                                                .isAcceptableCombination(combination)) {
                                                                countOfCombinations++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return countOfCombinations;
    }

    private static int getIndex(ArrayList<Card> cards, Card card) {
        for (int i = 0; i < cards.size(); i++) {
            Card currentCard = cards.get(i);
            if (currentCard.denominationType == card.denominationType &&
                currentCard.suitType == card.suitType) {
                return i;
            }
        }

        return 0;
    }
}
