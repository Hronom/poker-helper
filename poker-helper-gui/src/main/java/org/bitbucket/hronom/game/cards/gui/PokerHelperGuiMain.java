package org.bitbucket.hronom.game.cards.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitbucket.hronom.game.cards.gui.models.CardsComboBoxModel;
import org.bitbucket.hronom.game.cards.gui.models.CardsComboBoxRenderer;
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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class PokerHelperGuiMain {
    private static final Logger logger = LogManager.getLogger();

    //private final MainView mainView;
    private final String propertiesFileName = "game-cards-editor.properties";

    private static final String appName = "Poker Helper";

    private final ArrayList<PokerHand> pokerHands = new ArrayList<>();

    private final JTextArea outputTextArea;
    private final JComboBox<Card> cardJComboBox1;
    private final JComboBox<Card> cardJComboBox2;
    private final JComboBox<Card> cardJComboBox3;
    private final JComboBox<Card> cardJComboBox4;
    private final JComboBox<Card> cardJComboBox5;

    public PokerHelperGuiMain() {
        // Create UI
        JPanel mainPanel = new JPanel();
        mainPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        GridBagLayout layout = new GridBagLayout();
        mainPanel.setLayout(layout);

        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(3, 3, 3, 3);
        constraint.weightx = 1;
        constraint.weighty = 0;
        constraint.gridwidth = 1;
        constraint.anchor = GridBagConstraints.CENTER;

        // JComboBox 1
        {
            cardJComboBox1 = new JComboBox<>();
            cardJComboBox1.setModel(new CardsComboBoxModel());
            cardJComboBox1.setRenderer(new CardsComboBoxRenderer());
            //cardJComboBox1.setSelectedIndex(0);

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 0;
            constraint.gridy = 0;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(cardJComboBox1, constraint);
        }

        // JComboBox 2
        {
            cardJComboBox2 = new JComboBox<>();
            cardJComboBox2.setModel(new CardsComboBoxModel());
            cardJComboBox2.setRenderer(new CardsComboBoxRenderer());
            cardJComboBox2.setSelectedIndex(0);

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 1;
            constraint.gridy = 0;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(cardJComboBox2, constraint);
        }

        // JComboBox 3
        {
            cardJComboBox3 = new JComboBox<>();
            cardJComboBox3.setModel(new CardsComboBoxModel());
            cardJComboBox3.setRenderer(new CardsComboBoxRenderer());
            cardJComboBox3.setSelectedIndex(0);

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 0;
            constraint.gridy = 1;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(cardJComboBox3, constraint);
        }

        // JComboBox 4
        {
            cardJComboBox4 = new JComboBox<>();
            cardJComboBox4.setModel(new CardsComboBoxModel());
            cardJComboBox4.setRenderer(new CardsComboBoxRenderer());
            cardJComboBox4.setSelectedIndex(0);

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 1;
            constraint.gridy = 1;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(cardJComboBox4, constraint);
        }

        // JComboBox 5
        {
            cardJComboBox5 = new JComboBox<>();
            cardJComboBox5.setModel(new CardsComboBoxModel());
            cardJComboBox5.setRenderer(new CardsComboBoxRenderer());
            cardJComboBox5.setSelectedIndex(0);

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 2;
            constraint.gridy = 1;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(cardJComboBox5, constraint);
        }

        // Button for start extracting
        {
            final String buttonName = "Calculate";
            final JButton processButton = new JButton(buttonName);
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    processAction();
                }
            };
            processButton.addActionListener(actionListener);

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 0;
            constraint.gridy = 2;
            constraint.gridwidth = 5;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.HORIZONTAL;
            constraint.anchor = GridBagConstraints.BELOW_BASELINE;
            mainPanel.add(processButton, constraint);
        }

        // JTextArea for output before
        {
            outputTextArea = new JTextArea();
            outputTextArea.setWrapStyleWord(true);
            outputTextArea.setAutoscrolls(true);

            JScrollPane scrollPane = new JScrollPane(outputTextArea);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

            constraint.weightx = 1;
            constraint.weighty = 1;
            constraint.gridx = 0;
            constraint.gridy = 3;
            constraint.gridwidth = 5;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(scrollPane, constraint);
        }

        JFrame frame = new JFrame(appName);
        frame.setContentPane(mainPanel);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
        frame.setLocationRelativeTo(null);

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

        frame.setVisible(true);
    }

    public static void main(String args[]) {
        PokerHelperGuiMain app = new PokerHelperGuiMain();
    }

    public void processAction() {
        outputTextArea.setText("");

        ArrayList<Card> availableCards = new ArrayList<>();
        availableCards.add(cardJComboBox1.getItemAt(cardJComboBox1.getSelectedIndex()));
        availableCards.add(cardJComboBox2.getItemAt(cardJComboBox2.getSelectedIndex()));
        availableCards.add(cardJComboBox3.getItemAt(cardJComboBox3.getSelectedIndex()));
        availableCards.add(cardJComboBox4.getItemAt(cardJComboBox4.getSelectedIndex()));
        availableCards.add(cardJComboBox5.getItemAt(cardJComboBox5.getSelectedIndex()));

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

            outputTextArea.append(
                pokerHand.getClass().getSimpleName() + ", outs: " + outs + ", deck: " +
                allCards.size() + ", result: " + getFormatedValue(
                    (double) outs / (double) allCards.size()
                )
            );
            outputTextArea.append("\n");
        }
    }

    private String getFormatedValue(double value) {
        //return String.valueOf((1 - value) * 100);
        return String.format("%." + 0 + "f", value * 100) + "%";
    }
}
