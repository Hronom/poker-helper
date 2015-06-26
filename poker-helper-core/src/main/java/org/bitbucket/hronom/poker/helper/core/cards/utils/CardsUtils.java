package org.bitbucket.hronom.poker.helper.core.cards.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.poker.hands.PokerHand;
import org.bitbucket.hronom.poker.helper.core.poker.hands.RoyalFlush;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by hronom on 20.06.15.
 */
public class CardsUtils {
    private static final Logger logger = LogManager.getLogger();

    public static void printToFileCombinations(
        ArrayList<Card> cards, PokerHand pokerHand, Path filePath, Charset charset
    ) throws IOException {
        int categoriesSize = cards.size();
        int categoriesProcessed = 0;
        int percentCompleted = -1;

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(
            filePath, charset, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING
        );
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            for (int index1 = 0; index1 < cards.size(); index1++) {
                for (int index2 = 0; index2 < cards.size(); index2++) {
                    if (index1 != index2) {
                        for (int index3 = 0; index3 < cards.size(); index3++) {
                            if (index1 != index3 && index2 != index3) {
                                for (int index4 = 0; index4 < cards.size(); index4++) {
                                    if (index1 != index4 && index2 != index4 && index3 != index4) {
                                        for (int index5 = 0; index5 < cards.size(); index5++) {
                                            if (index1 != index5 && index2 != index5 &&
                                                index3 != index5 && index4 != index5) {
                                                Card combination[] = new Card[5];
                                                combination[0] = cards.get(index1);
                                                combination[1] = cards.get(index2);
                                                combination[2] = cards.get(index3);
                                                combination[3] = cards.get(index4);
                                                combination[4] = cards.get(index5);

                                                if (pokerHand
                                                    .isAcceptableCombination(combination)) {
                                                    printWriter
                                                        .println(Arrays.toString(combination));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                categoriesProcessed++;
                int currentPercent = (100 * categoriesProcessed) / categoriesSize;
                if (percentCompleted != currentPercent) {
                    percentCompleted = currentPercent;
                    logger.info(percentCompleted + "%");
                }
            }
        }
    }

    public static long countCombinations(ArrayList<Card> cards) {
        long countOfCombinations = 0;

        int categoriesSize = cards.size();
        int categoriesProcessed = 0;
        int percentCompleted = -1;

        RoyalFlush royalFlush = new RoyalFlush();

        for (int index1 = 0; index1 < cards.size(); index1++) {
            for (int index2 = 0; index2 < cards.size(); index2++) {
                if (index1 != index2) {
                    for (int index3 = 0; index3 < cards.size(); index3++) {
                        if (index1 != index3 && index2 != index3) {
                            for (int index4 = 0; index4 < cards.size(); index4++) {
                                if (index1 != index4 && index2 != index4 && index3 != index4) {
                                    for (int index5 = 0; index5 < cards.size(); index5++) {
                                        if (index1 != index5 && index2 != index5 &&
                                            index3 != index5 && index4 != index5) {
                                            Card combination[] = new Card[5];
                                            combination[0] = cards.get(index1);
                                            combination[1] = cards.get(index2);
                                            combination[2] = cards.get(index3);
                                            combination[3] = cards.get(index4);
                                            combination[4] = cards.get(index5);
                                            countOfCombinations++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            categoriesProcessed++;
            int currentPercent = (100 * categoriesProcessed) / categoriesSize;
            if (percentCompleted != currentPercent) {
                percentCompleted = currentPercent;
                logger.info(percentCompleted + "%");
            }
        }

        return countOfCombinations;
    }

    public static long countCombinationsForAvailableCards(
        ArrayList<Card> cards,
        ArrayList<Card> availableCards,
        ArrayList<Card> excludeCards,
        PokerHand pokerHand
    ) {
        long countOfCombinations = 0;

        int start1 = availableCards.size() > 0 ? getIndex(cards, availableCards.get(0)) : 0;
        int size1 = availableCards.size() > 0 ? start1 + 1 : cards.size();

        int start2 = availableCards.size() > 1 ? getIndex(cards, availableCards.get(1)) : 0;
        int size2 = availableCards.size() > 1 ? start2 + 1 : cards.size();

        int start3 = availableCards.size() > 2 ? getIndex(cards, availableCards.get(2)) : 0;
        int size3 = availableCards.size() > 2 ? start3 + 1 : cards.size();

        int start4 = availableCards.size() > 3 ? getIndex(cards, availableCards.get(3)) : 0;
        int size4 = availableCards.size() > 3 ? start4 + 1 : cards.size();

        int start5 = availableCards.size() > 4 ? getIndex(cards, availableCards.get(4)) : 0;
        int size5 = availableCards.size() > 4 ? start5 + 1 : cards.size();

        HashSet<Integer> skipIndexes = new HashSet<>();
        for (Card cardToSkip : excludeCards) {
            skipIndexes.add(getIndex(cards, cardToSkip));
        }

        for (int index1 = start1; index1 < size1; index1++) {
            if (!skipIndexes.contains(index1)) {
                for (int index2 = start2; index2 < size2; index2++) {
                    if (index1 != index2 && !skipIndexes.contains(index2)) {
                        for (int index3 = start3; index3 < size3; index3++) {
                            if (index1 != index3 && index2 != index3 &&
                                !skipIndexes.contains(index3)) {
                                for (int index4 = start4; index4 < size4; index4++) {
                                    if (index1 != index4 && index2 != index4 && index3 != index4 &&
                                        !skipIndexes.contains(index4)) {
                                        for (int index5 = start5; index5 < size5; index5++) {
                                            if (index1 != index5 && index2 != index5 &&
                                                index3 != index5 && index4 != index5 &&
                                                !skipIndexes.contains(index5)) {
                                                Card combination[] = new Card[5];
                                                combination[0] = cards.get(index1);
                                                combination[1] = cards.get(index2);
                                                combination[2] = cards.get(index3);
                                                combination[3] = cards.get(index4);
                                                combination[4] = cards.get(index5);

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
