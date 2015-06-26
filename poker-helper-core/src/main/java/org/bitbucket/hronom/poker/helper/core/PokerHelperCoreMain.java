package org.bitbucket.hronom.poker.helper.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.bitbucket.hronom.poker.helper.core.cards.utils.CardsUtils;
import org.bitbucket.hronom.poker.helper.core.db.H2Manager;
import org.bitbucket.hronom.poker.helper.core.poker.hands.Flush;
import org.bitbucket.hronom.poker.helper.core.poker.hands.FourOfKind;
import org.bitbucket.hronom.poker.helper.core.poker.hands.FullHouse;
import org.bitbucket.hronom.poker.helper.core.poker.hands.HighCard;
import org.bitbucket.hronom.poker.helper.core.poker.hands.OnePair;
import org.bitbucket.hronom.poker.helper.core.poker.hands.PokerHand;
import org.bitbucket.hronom.poker.helper.core.poker.hands.RoyalFlush;
import org.bitbucket.hronom.poker.helper.core.poker.hands.Straight;
import org.bitbucket.hronom.poker.helper.core.poker.hands.StraightFlush;
import org.bitbucket.hronom.poker.helper.core.poker.hands.ThreeOfKind;
import org.bitbucket.hronom.poker.helper.core.poker.hands.TwoPair;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by hronom on 14.06.15.
 */
public class PokerHelperCoreMain {
    private final Logger logger = LogManager.getLogger();
    private final ArrayList<PokerHand> pokerHands = new ArrayList<>();

    public PokerHelperCoreMain() {
        pokerHands.add(new RoyalFlush());
        pokerHands.add(new StraightFlush());
        pokerHands.add(new FourOfKind());
        pokerHands.add(new FullHouse());
        pokerHands.add(new Flush());
        pokerHands.add(new Straight());
        pokerHands.add(new ThreeOfKind());
        pokerHands.add(new TwoPair());
        pokerHands.add(new OnePair());
        pokerHands.add(new HighCard());
    }

    public static void main(String args[]) {
        PokerHelperCoreMain pokerHelperCoreMain = new PokerHelperCoreMain();
        pokerHelperCoreMain.run();
    }

    public void run() {
        //testCardsGeneration();
        testCombinationsForAvailableCards();
        //testHibernate();
    }

    private void testCardsGeneration() {
        ArrayList<Card> cards = new ArrayList<>();
        for (CardSuitType suitType : CardSuitType.values()) {
            for (CardDenominationType denominationType : CardDenominationType.values()) {
                cards.add(new Card(suitType, denominationType));
            }
        }

        for (Card card : cards) {
            System.out.println(card);
        }

        //System.out.println(String.valueOf(CardsUtils.countCombinations(cards)));
        try {
            /*CardsUtils.printToFileCombinations(
                cards, new RoyalFlush(), Paths.get("royal_flush_combinations.txt"), Charset.forName("UTF-8")
            );
            CardsUtils.printToFileCombinations(
                cards, new StraightFlush(), Paths.get("straight_flush_combinations.txt"), Charset.forName("UTF-8")
            );*/
            /*CardsUtils.printToFileCombinations(
                cards, new FourOfKind(), Paths.get("four_of_kind_combinations.txt"), Charset.forName("UTF-8")
            );*/
            CardsUtils.printToFileCombinations(
                cards,
                new FullHouse(),
                Paths.get("full_house_combinations.txt"),
                Charset.forName("UTF-8")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testCombinationsForAvailableCards() {
        ArrayList<Card> cards = new ArrayList<>();
        for (CardSuitType suitType : CardSuitType.values()) {
            for (CardDenominationType denominationType : CardDenominationType.values()) {
                cards.add(new Card(suitType, denominationType));
            }
        }

        ArrayList<Card> availableCards = new ArrayList<>();
        availableCards.add(new Card(CardSuitType.CLUB, CardDenominationType.ACE));
        availableCards.add(new Card(CardSuitType.CLUB, CardDenominationType.KING));
        availableCards.add(new Card(CardSuitType.DIAMOND, CardDenominationType.KING));
        {
            for (PokerHand pokerHand : pokerHands) {
                long count = CardsUtils.countCombinationsForAvailableCards(
                    cards, availableCards, new ArrayList<Card>(), pokerHand
                );
                System.out.println(pokerHand.getClass().getSimpleName() + ": " + count);

                switch (pokerHand.getRating()) {
                    case 9:
                        System.out.println(
                            pokerHand.getClass().getSimpleName() + ": " + (100 * count) / 480 + "%"
                        );
                        break;
                    case 8:
                        System.out.println(
                            pokerHand.getClass().getSimpleName() + ": " + (100 * count) / 6240 + "%"
                        );
                        break;
                    case 7:
                        System.out.println(
                            pokerHand.getClass().getSimpleName() + ": " + (100 * count) / 74880 +
                            "%"
                        );
                        break;
                    case 6:
                        System.out.println(
                            pokerHand.getClass().getSimpleName() + ": " + (100 * count) / 449280 +
                            "%"
                        );
                        break;
                    case 5:
                        System.out.println(
                            pokerHand.getClass().getSimpleName() + ": " + (100 * count) / 617760 +
                            "%"
                        );
                        break;
                    case 4:
                        System.out.println(
                            pokerHand.getClass().getSimpleName() + ": " + (100 * count) / 1597440 +
                            "%"
                        );
                        break;
                    case 3:
                        System.out.println(
                            pokerHand.getClass().getSimpleName() + ": " + (100 * count) / 7038720 +
                            "%"
                        );
                        break;
                    case 2:
                        System.out.println(
                            pokerHand.getClass().getSimpleName() + ": " + (100 * count) / 15275520 +
                            "%"
                        );
                        break;
                    case 1:
                        System.out.println(
                            pokerHand.getClass().getSimpleName() + ": " +
                            (100 * count) / 147064320 + "%"
                        );
                        break;
                    case 0:
                        System.out.println(
                            pokerHand.getClass().getSimpleName() + ": " +
                            (100 * count) / 311875200 + "%"
                        );
                        break;
                }
            }
        }

        System.out.println();

        ArrayList<Card> excludeCards = new ArrayList<>();
        excludeCards.addAll(availableCards);
        {
            for (PokerHand pokerHand : pokerHands) {
                long count = CardsUtils.countCombinationsForAvailableCards(
                    cards, new ArrayList<Card>(), excludeCards, pokerHand
                );
                System.out.println(pokerHand.getClass().getSimpleName() + ": " + count);
            }
        }
    }

    private void testHibernate() {
        H2Manager h2Manager = new H2Manager();
        h2Manager.initialize();
        /*h2Manager.fillCards();
        h2Manager.fill();*/
        h2Manager.debugPrint();
    }
}
