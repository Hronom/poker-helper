package org.bitbucket.hronom.game.cards.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitbucket.hronom.game.cards.gui.controllers.CalculateButtonController;
import org.bitbucket.hronom.game.cards.gui.models.CardsComboBoxModel;
import org.bitbucket.hronom.game.cards.gui.models.CardsComboBoxRenderer;
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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.*;

public class PokerHelperGuiMain {
    private static final Logger logger = LogManager.getLogger();
    private static final ResourceBundle resourceBundle = UTFResourceBundle
        .getBundle("MessagesBundle");//NON-NLS
    //private final MainView mainView;
    private static final String propertiesFileName = "poker-helper-gui-app.properties"; //NON-NLS

    private static final String appName = resourceBundle.getString("app.name");

    private final ArrayList<PokerHand> pokerHands = new ArrayList<>();

    private final JTextArea outputTextArea;
    private final JComboBox<Card> cardJComboBox1;
    private final JComboBox<Card> cardJComboBox2;
    private final JComboBox<Card> cardJComboBox3;
    private final JComboBox<Card> cardJComboBox4;
    private final JComboBox<Card> cardJComboBox5;
    private final JComboBox<Card> cardJComboBox6;
    private final JButton calculateButton;

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

        {
            JLabel jLabel = new JLabel(resourceBundle.getString("app.gui.labels.hand"));

            constraint.weightx = 0;
            constraint.weighty = 0;
            constraint.gridx = 0;
            constraint.gridy = 0;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(jLabel, constraint);
        }

        // JComboBox 1
        {
            cardJComboBox1 = new JComboBox<>();
            cardJComboBox1.setRenderer(new CardsComboBoxRenderer());
            cardJComboBox1.setModel(new CardsComboBoxModel());

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 1;
            constraint.gridy = 0;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(cardJComboBox1, constraint);
        }

        // JComboBox 2
        {
            cardJComboBox2 = new JComboBox<>();
            cardJComboBox2.setRenderer(new CardsComboBoxRenderer());
            cardJComboBox2.setModel(new CardsComboBoxModel());

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 2;
            constraint.gridy = 0;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(cardJComboBox2, constraint);
        }

        {
            JLabel jLabel = new JLabel(resourceBundle.getString("app.gui.labels.flop"));

            constraint.weightx = 0;
            constraint.weighty = 0;
            constraint.gridx = 0;
            constraint.gridy = 1;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(jLabel, constraint);
        }

        // JComboBox 3
        {
            cardJComboBox3 = new JComboBox<>();
            cardJComboBox3.setRenderer(new CardsComboBoxRenderer());
            cardJComboBox3.setModel(new CardsComboBoxModel());

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 1;
            constraint.gridy = 1;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(cardJComboBox3, constraint);
        }

        // JComboBox 4
        {
            cardJComboBox4 = new JComboBox<>();
            cardJComboBox4.setRenderer(new CardsComboBoxRenderer());
            cardJComboBox4.setModel(new CardsComboBoxModel());

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 2;
            constraint.gridy = 1;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(cardJComboBox4, constraint);
        }

        // JComboBox 5
        {
            cardJComboBox5 = new JComboBox<>();
            cardJComboBox5.setRenderer(new CardsComboBoxRenderer());
            cardJComboBox5.setModel(new CardsComboBoxModel());

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 3;
            constraint.gridy = 1;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(cardJComboBox5, constraint);
        }

        {
            JLabel jLabel = new JLabel(resourceBundle.getString("app.gui.labels.turn"));

            constraint.weightx = 0;
            constraint.weighty = 0;
            constraint.gridx = 0;
            constraint.gridy = 2;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(jLabel, constraint);
        }

        // JComboBox 6
        {
            cardJComboBox6 = new JComboBox<>();
            cardJComboBox6.setRenderer(new CardsComboBoxRenderer());
            cardJComboBox6.setModel(new CardsComboBoxModel());

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 1;
            constraint.gridy = 2;
            constraint.gridwidth = 1;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(cardJComboBox6, constraint);
        }

        // Button reset cards
        {
            JButton resetCardsButton = new JButton();
            resetCardsButton.setText(resourceBundle.getString("app.gui.buttons.resetcards.text"));
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardJComboBox1.setSelectedIndex(-1);
                    cardJComboBox2.setSelectedIndex(-1);
                    cardJComboBox3.setSelectedIndex(-1);
                    cardJComboBox4.setSelectedIndex(-1);
                    cardJComboBox5.setSelectedIndex(-1);
                    cardJComboBox6.setSelectedIndex(-1);
                }
            };
            resetCardsButton.addActionListener(actionListener);

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 0;
            constraint.gridy = 3;
            constraint.gridwidth = 5;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.HORIZONTAL;
            constraint.anchor = GridBagConstraints.BELOW_BASELINE;
            mainPanel.add(resetCardsButton, constraint);
        }

        // Button calculate
        {
            calculateButton = new JButton();
            calculateButton.setEnabled(false);
            calculateButton.setText(resourceBundle.getString("app.gui.buttons.calculate.disabled"));
            ActionListener actionListener = new ActionListener() {
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
            };
            calculateButton.addActionListener(actionListener);

            constraint.weightx = 1;
            constraint.weighty = 0;
            constraint.gridx = 0;
            constraint.gridy = 4;
            constraint.gridwidth = 5;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.HORIZONTAL;
            constraint.anchor = GridBagConstraints.BELOW_BASELINE;
            mainPanel.add(calculateButton, constraint);
        }

        {
            CalculateButtonController calculateButtonController = new CalculateButtonController(
                cardJComboBox1,
                cardJComboBox2,
                cardJComboBox3,
                cardJComboBox4,
                cardJComboBox5,
                cardJComboBox6,
                calculateButton
            );
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
            constraint.gridy = 5;
            constraint.gridwidth = 5;
            constraint.gridheight = 1;
            constraint.fill = GridBagConstraints.BOTH;
            mainPanel.add(scrollPane, constraint);
        }

        ArrayList<Image> images = new ArrayList<>();
        images.add(getImage("1435621016_cards.ico"));

        JFrame frame = new JFrame(appName);
        frame.setIconImages(images);
        frame.setContentPane(mainPanel);
        frame.setPreferredSize(new Dimension(640, 540));
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
            Card[] combinations = new Card[5];
            combinations = availableCards.toArray(combinations);

            if (availableCards.size() == 2) {
                long calculatedOuts = CardsUtils.countOutsCardsForPreflop(
                    PokerDeck.cards, availableCards, new ArrayList<Card>(), pokerHand
                );

                if (calculatedOuts < allCards.size()) {
                    outs = calculatedOuts;
                }
            } else if (availableCards.size() == 5) {
                if (!pokerHand.isAcceptableCombination(combinations)) {
                    outs = CardsUtils.countOutsCardsForTurn(
                        PokerDeck.cards, availableCards, new ArrayList<Card>(), pokerHand
                    );
                }
            } else if (availableCards.size() == 6) {
                if (!pokerHand.isAcceptableCombination(combinations)) {
                    outs = CardsUtils.countOutsCardsForRiver(
                        PokerDeck.cards, availableCards, new ArrayList<Card>(), pokerHand
                    );
                }
            }

            outputTextArea.append(
                getHandName(pokerHand) + "\t" +
                resourceBundle.getString("app.gui.report.outs") + " " + outs + "\t" +
                resourceBundle.getString("app.gui.report.deck") + " " + allCards.size() + "\t" +
                resourceBundle.getString("app.gui.report.result") + " " +
                getFormatedValue((double) outs / (double) allCards.size())
            );
            outputTextArea.append("\n");
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
        //return String.valueOf((1 - value) * 100);
        return String.format("%." + 0 + "f", value * 100) + "%";
    }

    private Image getImage(String fileName) {
        URL url = this.getClass().getClassLoader().getResource(
            "org/bitbucket/hronom/game/cards/gui/" + fileName
        );
        ImageIcon imageIcon = new ImageIcon(url);
        return imageIcon.getImage();
    }
}
