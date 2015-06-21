package org.bitbucket.hronom.poker.helper.core.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.bitbucket.hronom.poker.helper.core.db.entities.Combination;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

/**
 * Created by hronom on 21.06.15.
 */
public class H2Manager {
    private final Logger logger = LogManager.getLogger();
    private Session session;

    public boolean initialize() {
        SessionFactory sessionFactory = null;

        if (sessionFactory == null) {
            final Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Card.class);
            configuration.addAnnotatedClass(Combination.class);

            sessionFactory = configuration
                .buildSessionFactory(new StandardServiceRegistryBuilder().build());
        }

        session = sessionFactory.openSession();

        return true;
    }

    public boolean fillCards() {
        ArrayList<Card> cards = new ArrayList<>();
        for (CardSuitType suitType : CardSuitType.values()) {
            for (CardDenominationType denominationType : CardDenominationType.values()) {
                cards.add(new Card(suitType, denominationType));
            }
        }

        session.getTransaction().begin();
        for (Card card : cards) {
            session.persist(card);
        }
        session.getTransaction().commit();

        return true;
    }

    public boolean fill() {
        ArrayList<Card> cards = new ArrayList<>();
        for (CardSuitType suitType : CardSuitType.values()) {
            for (CardDenominationType denominationType : CardDenominationType.values()) {
                cards.add(new Card(suitType, denominationType));
            }
        }

        int categoriesSize = cards.size();
        int categoriesProcessed = 0;
        int percentCompleted = -1;

        session.getTransaction().begin();

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
                                            /*Card combination[] = new Card[5];
                                            combination[0] = cards.get(index1);
                                            combination[1] = cards.get(index2);
                                            combination[2] = cards.get(index3);
                                            combination[3] = cards.get(index4);
                                            combination[4] = cards.get(index5);*/
                                            Combination combination = new Combination();
                                            combination.cardA = cards.get(index1);
                                            combination.cardB = cards.get(index2);
                                            combination.cardC = cards.get(index3);
                                            combination.cardD = cards.get(index4);
                                            combination.cardE = cards.get(index5);
                                            session.persist(combination);
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

        session.getTransaction().commit();

        return true;
    }

    public void debugPrint() {
        session.getTransaction().begin();
        System.out.println(session.createCriteria(Combination.class).list());
        session.getTransaction().commit();
    }
}
