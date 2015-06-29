package org.bitbucket.hronom.poker.helper.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.bitbucket.hronom.poker.helper.core.cards.PokerDeck;
import org.bitbucket.hronom.poker.helper.core.cards.utils.CardsUtils;
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
        testCombinationsForAvailableCards2();
    }

    private void testCombinationsForAvailableCards() {
        //long[][][][][] test = new long[311875200][][][][];
        System.out.println("test");

        ArrayList<Card> availableCards = new ArrayList<>();
        //        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D8));
        //        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D7));
        //        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.ACE));
        //        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D10));
        //        availableCards.add(PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D3));
        //        availableCards.add(new Card(CardSuitType.SPADE, CardDenominationType.KING));
        //        availableCards.add(new Card(CardSuitType.SPADE, CardDenominationType.ACE));
        {
            for (PokerHand pokerHand : pokerHands) {
                long count = CardsUtils.countCombinationsForAvailableCards3(
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
                long count = CardsUtils.countCombinationsForAvailableCards3(
                    PokerDeck.cards, new ArrayList<Card>(), excludeCards, pokerHand
                );
                System.out.println(pokerHand.getClass().getSimpleName() + ": " + count);
            }
        }
    }

    private void testCombinationsForAvailableCards2() {
        ArrayList<Card> availableCards = new ArrayList<>();
        /*availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D8));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D7));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.ACE));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D10));
        availableCards.add(PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D3));*/

        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.ACE));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.KING));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.QUEEN));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.JACK));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D10));

        ArrayList<Card> allCards = new ArrayList<>();
        allCards.addAll(PokerDeck.cards);
        allCards.removeAll(availableCards);

        for (PokerHand pokerHand : pokerHands) {
            long outs = allCards.size();
            Card[] combinations = new Card[5];
            combinations = availableCards.toArray(combinations);
            if (!pokerHand.isAcceptableCombination(combinations)) {
                outs = CardsUtils.countOutsCardsForTurn(
                    PokerDeck.cards, availableCards, new ArrayList<Card>(), pokerHand
                );
            }

            System.out.println(
                pokerHand.getClass().getSimpleName() + ", outs: " + outs + ", deck: " +
                allCards.size() + ", result: " +
                ((double) outs / (double) allCards.size())
            );
        }
    }
}