package org.bitbucket.hronom.poker.helper.core.cards;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hronom on 20.06.15.
 */
@Entity
@Table(name = "cards", catalog = "catalog_name")
@DynamicUpdate
public class Card {
    @Id
    @GeneratedValue
    private Integer id;

    public final CardSuitType suitType;
    public final CardDenominationType denominationType;

    public Card(CardSuitType suitTypeArg, CardDenominationType denominationTypeArg) {
        suitType = suitTypeArg;
        denominationType = denominationTypeArg;
    }

    @Override
    public String toString() {
        return id + " " + suitType.toString() + " " + denominationType.toString();
    }
}
