package org.bitbucket.hronom.poker.helper.core.cards;

/**
 * Created by hronom on 20.06.15.
 */
public class Card {
    public final CardSuitType suitType;
    public final CardDenominationType denominationType;

    Card(CardSuitType suitTypeArg, CardDenominationType denominationTypeArg) {
        suitType = suitTypeArg;
        denominationType = denominationTypeArg;
    }

    @Override
    public String toString() {
        return suitType.toString() + " " + denominationType.toString();
    }
}
