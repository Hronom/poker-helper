package org.bitbucket.hronom.poker.helper.core.managers;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.poker.hands.PokerHand;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hronom on 27.06.15.
 */
public class CardsCombinationsManager {
    private final ForkJoinPool pool = new ForkJoinPool();

    private class Work extends RecursiveAction {
        final PokerHand pokerHand;
        final Card[] combination;
        final AtomicLong counter;

        private Work(PokerHand pokerHandArg, Card[] combinationArg, AtomicLong counterArg) {
            pokerHand = pokerHandArg;
            combination = combinationArg;
            counter = counterArg;
        }

        @Override
        protected void compute() {
            if (pokerHand.isAcceptableCombination(combination)) {
                counter.incrementAndGet();
            }
        }
    }

    public CardsCombinationsManager() {
    }

    public AtomicLong countCombinationsForAvailableCards(
        ArrayList<Card> cards,
        ArrayList<Card> availableCards,
        ArrayList<Card> excludeCards,
        PokerHand pokerHand
    ) {
        AtomicLong countOfCombinations = new AtomicLong(0);

        int[] starts = new int[7];
        for (int i = 0; i < 7; i++) {
            starts[i] = availableCards.size() > i ? getIndex(cards, availableCards.get(i)) : 0;
        }

        int[] sizes = new int[7];
        for (int i = 0; i < 7; i++) {
            sizes[i] = availableCards.size() > i ? starts[i] + 1 : cards.size();
        }

        HashSet<Integer> skipIndexes = new HashSet<>();
        for (Card cardToSkip : excludeCards) {
            skipIndexes.add(getIndex(cards, cardToSkip));
        }

        for (int index1 = starts[0]; index1 < sizes[0]; index1++) {
            if (!skipIndexes.contains(index1)) {
                for (int index2 = starts[1]; index2 < sizes[1]; index2++) {
                    if (index1 != index2 && !skipIndexes.contains(index2)) {
                        for (int index3 = starts[2]; index3 < sizes[2]; index3++) {
                            if (index1 != index3 && index2 != index3 &&
                                !skipIndexes.contains(index3)) {
                                for (int index4 = starts[3]; index4 < sizes[3]; index4++) {
                                    if (index1 != index4 && index2 != index4 &&
                                        index3 != index4 &&
                                        !skipIndexes.contains(index4)) {
                                        for (int index5 = starts[4]; index5 < sizes[4]; index5++) {
                                            if (index1 != index5 && index2 != index5 &&
                                                index3 != index5 && index4 != index5 &&
                                                !skipIndexes.contains(index5)) {
                                                for (int index6 = starts[5]; index6 < sizes[5];
                                                     index6++) {
                                                    if (index1 != index6 &&
                                                        index2 != index6 &&
                                                        index3 != index6 &&
                                                        index4 != index6 &&
                                                        index5 != index6 &&
                                                        !skipIndexes.contains(index6)) {
                                                        for (int index7 = starts[6];
                                                             index7 < sizes[6]; index7++) {
                                                            if (index1 != index7 &&
                                                                index2 != index7 &&
                                                                index3 != index7 &&
                                                                index4 != index7 &&
                                                                index5 != index7 &&
                                                                index6 != index7 &&
                                                                !skipIndexes.contains(index7)) {
                                                                Card combination
                                                                    [
                                                                    ] = new Card[7];
                                                                combination[0] = cards.get(index1);
                                                                combination[1] = cards.get(index2);
                                                                combination[2] = cards.get(index3);
                                                                combination[3] = cards.get(index4);
                                                                combination[4] = cards.get(index5);
                                                                combination[5] = cards.get(index6);
                                                                combination[6] = cards.get(index7);

                                                                Work work = new Work(
                                                                    pokerHand,
                                                                    combination,
                                                                    countOfCombinations
                                                                );
                                                                pool.invoke(work);
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

        while (pool.getQueuedTaskCount() != 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return countOfCombinations;
    }

    private int getIndex(ArrayList<Card> cards, Card card) {
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