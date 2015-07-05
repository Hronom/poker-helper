package org.bitbucket.hronom.game.cards.gui.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitbucket.hronom.game.cards.gui.utils.UTFResourceBundle;
import org.bitbucket.hronom.poker.helper.core.cards.Card;
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.*;

/**
 * Created by hronom on 04.07.15.
 */
public class CalculateButtonActionController implements ActionListener {
    private final Logger logger = LogManager.getLogger();

    private final ResourceBundle resourceBundle = UTFResourceBundle.getBundle("MessagesBundle");
    //NON-NLS

    private final JComboBox<Card> cardJComboBox1;
    private final JComboBox<Card> cardJComboBox2;
    private final JComboBox<Card> cardJComboBox3;
    private final JComboBox<Card> cardJComboBox4;
    private final JComboBox<Card> cardJComboBox5;
    private final JComboBox<Card> cardJComboBox6;
    private final JButton calculateButton;
    private final JTextArea outputTextArea;

    private final ArrayList<PokerHand> pokerHands = new ArrayList<>();

    public CalculateButtonActionController(
        JComboBox<Card> cardJComboBox1Arg,
        JComboBox<Card> cardJComboBox2Arg,
        JComboBox<Card> cardJComboBox3Arg,
        JComboBox<Card> cardJComboBox4Arg,
        JComboBox<Card> cardJComboBox5Arg,
        JComboBox<Card> cardJComboBox6Arg,
        JButton calculateButtonArg,
        JTextArea outputTextAreaArg
    ) {
        cardJComboBox1 = cardJComboBox1Arg;
        cardJComboBox2 = cardJComboBox2Arg;
        cardJComboBox3 = cardJComboBox3Arg;
        cardJComboBox4 = cardJComboBox4Arg;
        cardJComboBox5 = cardJComboBox5Arg;
        cardJComboBox6 = cardJComboBox6Arg;
        calculateButton = calculateButtonArg;
        calculateButton.addActionListener(this);
        outputTextArea = outputTextAreaArg;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        calculateButton.setEnabled(false);
        String previousText = calculateButton.getText();
        calculateButton.setText(
            resourceBundle.getString("app.gui.buttons.calculate.processing")
        );
        processAction();
        calculateButton.setEnabled(true);
        calculateButton.setText(previousText);
    }

    public void processAction() {
        try {
            outputTextArea.setText("");

            ArrayList<Card> availableCards = new ArrayList<>();
            if (cardJComboBox1.getSelectedIndex() != -1) {
                availableCards.add(cardJComboBox1.getItemAt(cardJComboBox1.getSelectedIndex()));
            }
            if (cardJComboBox2.getSelectedIndex() != -1) {
                availableCards.add(cardJComboBox2.getItemAt(cardJComboBox2.getSelectedIndex()));
            }
            if (cardJComboBox3.getSelectedIndex() != -1) {
                availableCards.add(cardJComboBox3.getItemAt(cardJComboBox3.getSelectedIndex()));
            }
            if (cardJComboBox4.getSelectedIndex() != -1) {
                availableCards.add(cardJComboBox4.getItemAt(cardJComboBox4.getSelectedIndex()));
            }
            if (cardJComboBox5.getSelectedIndex() != -1) {
                availableCards.add(cardJComboBox5.getItemAt(cardJComboBox5.getSelectedIndex()));
            }
            if (cardJComboBox6.getSelectedIndex() != -1) {
                availableCards.add(cardJComboBox6.getItemAt(cardJComboBox6.getSelectedIndex()));
            }

            ArrayList<Card> allCards = new ArrayList<>();
            allCards.addAll(PokerDeck.cards);
            allCards.removeAll(availableCards);

            switch (availableCards.size()) {
                case 2:
                    outputTextArea.append(resourceBundle.getString("app.gui.report.on.flop"));
                    outputTextArea.append("\n");
                    break;
                case 5:
                    outputTextArea.append(resourceBundle.getString("app.gui.report.on.turn"));
                    outputTextArea.append("\n");
                    break;
                case 6:
                    outputTextArea.append(resourceBundle.getString("app.gui.report.on.river"));
                    outputTextArea.append("\n");
                    break;
            }

            for (PokerHand pokerHand : pokerHands) {
                long outs = allCards.size();

                if (availableCards.size() == 2) {
                    long calculatedOuts = CardsUtils.countOutsCardsForPreflop(
                        PokerDeck.cards, availableCards, new ArrayList<Card>(), pokerHand
                    );

                    if (calculatedOuts < allCards.size()) {
                        outs = calculatedOuts;
                    }
                } else if (availableCards.size() == 5) {
                    Card[] combinations = new Card[5];
                    combinations = availableCards.toArray(combinations);

                    if (!pokerHand.isAcceptableCombination(combinations)) {
                        outs = CardsUtils.countOutsCardsForTurn(
                            PokerDeck.cards, availableCards, new ArrayList<Card>(), pokerHand
                        );
                    }
                } else if (availableCards.size() == 6) {
                    Card[] combinations = new Card[6];
                    combinations = availableCards.toArray(combinations);

                    if (!pokerHand.isAcceptableCombination(combinations)) {
                        outs = CardsUtils.countOutsCardsForRiver(
                            PokerDeck.cards, availableCards, new ArrayList<Card>(), pokerHand
                        );
                    }
                }

                // Calculate probability
                double probability = (double) outs / (double) allCards.size() * 100;
                // Calculate odds
                int odds;
                if (probability == 0.0) {
                    odds = allCards.size();
                } else {
                    odds = (100 / (int) probability) - 1;
                }

                outputTextArea.append(
                    getHandName(pokerHand) + "\t" +
                    resourceBundle.getString("app.gui.report.outs") + " " + outs + "\t" +
                    resourceBundle.getString("app.gui.report.deck") + " " + allCards.size() + "\t" +
                    resourceBundle.getString("app.gui.report.odds") + " " +
                    String.format("%.0f", probability) + "%" +
                    (probability != 0.0 ? " ~ " + odds + ":1" : "")
                );
                outputTextArea.append("\n");
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    private String getHandName(PokerHand pokerHand) {
        switch (pokerHand.getClass().getSimpleName()) {
            case "RoyalFlush": //NON-NLS
                return resourceBundle.getString("app.gui.report.hands.names.royalflush");
            case "StraightFlush": //NON-NLS
                return resourceBundle.getString("app.gui.report.hands.names.straightflush");
            case "FourOfKind": //NON-NLS
                return resourceBundle.getString("app.gui.report.hands.names.fourofkind");
            case "FullHouse": //NON-NLS
                return resourceBundle.getString("app.gui.report.hands.names.fullhouse");
            case "Flush": //NON-NLS
                return resourceBundle.getString("app.gui.report.hands.names.flush");
            case "Straight": //NON-NLS
                return resourceBundle.getString("app.gui.report.hands.names.straight");
            case "ThreeOfKind": //NON-NLS
                return resourceBundle.getString("app.gui.report.hands.names.threeofkind");
            case "TwoPair": //NON-NLS
                return resourceBundle.getString("app.gui.report.hands.names.twopair");
            case "OnePair": //NON-NLS
                return resourceBundle.getString("app.gui.report.hands.names.onepair");
            case "HighCard": //NON-NLS
                return resourceBundle.getString("app.gui.report.hands.names.highcard");
        }

        return null;
    }

    private String getFormatedValue(double value) {
        return String.format("%.0f", value * 100) + "%";
    }
}
