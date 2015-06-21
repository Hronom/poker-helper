package org.bitbucket.hronom.poker.helper.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.bitbucket.hronom.poker.helper.core.cards.utils.CardsUtils;
import org.bitbucket.hronom.poker.helper.core.db.H2Manager;
import org.bitbucket.hronom.poker.helper.core.poker.hands.FullHouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by hronom on 14.06.15.
 */
public class PokerHelperCoreMain {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String args[]) {
        //testCardsGeneration();
        testHibernate();
    }

    private static void testCardsGeneration() {
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

    private static void testHibernate() {
        H2Manager h2Manager = new H2Manager();
        h2Manager.initialize();
        /*h2Manager.fillCards();
        h2Manager.fill();*/
        h2Manager.debugPrint();
    }
}
