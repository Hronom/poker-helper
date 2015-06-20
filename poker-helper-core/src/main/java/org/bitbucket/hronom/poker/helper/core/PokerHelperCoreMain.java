package org.bitbucket.hronom.poker.helper.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.bitbucket.hronom.poker.helper.core.cards.utils.CardsUtils;

import java.util.ArrayList;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by hronom on 14.06.15.
 */
public class PokerHelperCoreMain {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String args[]) {
        ArrayList<Card> cards = new ArrayList<>();
        for (CardSuitType suitType : CardSuitType.values()) {
            for (CardDenominationType denominationType : CardDenominationType.values()) {
                cards.add(new Card(suitType, denominationType));
            }
        }

        for (Card card : cards) {
            System.out.println(card);
        }
//
//        Properties prop = new Properties();
//        prop.put("connection.driver_class", "org.h2.Driver");
//        prop.put("hibernate.connection.url", "jdbc:h2:./db/repository");
//        prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        prop.put("hibernate.hbm2ddl.auto", "create-drop");
//        prop.put("hibernate.show_sql", "true");

      /*  EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("thePersistenceUnit");
        EntityManager theManager = factory.createEntityManager();
        //assertNotNull(theManager);

        Card card = new Card(CardSuitType.CLUB, CardDenominationType.ACE);
        theManager.persist(card);
        System.out.println(card.toString());

        Card c = (Card) theManager.find(Card.class, 1);*/

        System.out.println(String.valueOf(CardsUtils.countCombinations(cards)));
    }
}
