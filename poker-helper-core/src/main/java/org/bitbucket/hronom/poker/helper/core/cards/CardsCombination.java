package org.bitbucket.hronom.poker.helper.core.cards;

/**
 * Created by hronom on 20.06.15.
 */
public class CardsCombination {
    public final Card a;
    public final Card b;
    public final Card c;
    public final Card d;
    public final Card e;

    public CardsCombination(Card a, Card b, Card c, Card d, Card e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    @Override
    public String toString() {
        return a + " " + b + " " + c + " " + d + " " + e;
    }
}
