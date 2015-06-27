package org.bitbucket.hronom.poker.helper.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.bitbucket.hronom.poker.helper.core.cards.PokerDeck;
import org.bitbucket.hronom.poker.helper.core.cards.utils.CardsUtils;
import org.bitbucket.hronom.poker.helper.core.managers.CardsCombinationsManager;
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
import java.util.concurrent.atomic.AtomicLong;

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
    }

    private void testCardsGeneration() {
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
                PokerDeck.cards,
                new FullHouse(),
                Paths.get("full_house_combinations.txt"),
                Charset.forName("UTF-8")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testCombinationsForAvailableCards() {
        CardsCombinationsManager cardsCombinationsManager = new CardsCombinationsManager();

        ArrayList<Card> availableCards = new ArrayList<>();
        availableCards.add(PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.ACE));
        availableCards.add(PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.KING));
        availableCards.add(PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.KING));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.KING));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.ACE));
        //        availableCards.add(new Card(CardSuitType.SPADE, CardDenominationType.KING));
        //        availableCards.add(new Card(CardSuitType.SPADE, CardDenominationType.ACE));
        {
            for (PokerHand pokerHand : pokerHands) {
                AtomicLong count = cardsCombinationsManager.countCombinationsForAvailableCards(
                    PokerDeck.cards, availableCards, new ArrayList<Card>(), pokerHand
                );
                System.out.println(pokerHand.getClass().getSimpleName() + ": " + count);
            }
        }

        System.out.println();

        ArrayList<Card> excludeCards = new ArrayList<>();
        excludeCards.addAll(availableCards);
        {
            for (PokerHand pokerHand : pokerHands) {
                AtomicLong count = cardsCombinationsManager.countCombinationsForAvailableCards(
                    PokerDeck.cards, new ArrayList<Card>(), excludeCards, pokerHand
                );
                System.out.println(pokerHand.getClass().getSimpleName() + ": " + count);
            }
        }
    }
}
