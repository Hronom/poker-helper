package org.bitbucket.hronom.poker.helper.core.cards;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hronom on 20.06.15.
 */
@Entity
@Table(name = "Cards")
public class Card {
    @Id
    @GeneratedValue
    public Integer id;

    public CardSuitType suitType;
    public CardDenominationType denominationType;

    public Card() {
    }

    public Card(CardSuitType suitTypeArg, CardDenominationType denominationTypeArg) {
        suitType = suitTypeArg;
        denominationType = denominationTypeArg;
    }

    @Override
    public String toString() {
        return suitType.toString() + " " + denominationType.toString();
    }
}
