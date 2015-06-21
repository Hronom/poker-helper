package org.bitbucket.hronom.poker.helper.core.db.entities;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by hronom on 21.06.15.
 */
@Entity
@Table(name = "Combinations")
public class Combination {
    @Id
    @GeneratedValue
    public Integer id;

    @ManyToOne
    public Card cardA;
    @ManyToOne
    public Card cardB;
    @ManyToOne
    public Card cardC;
    @ManyToOne
    public Card cardD;
    @ManyToOne
    public Card cardE;
}
