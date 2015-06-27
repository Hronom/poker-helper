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
}
