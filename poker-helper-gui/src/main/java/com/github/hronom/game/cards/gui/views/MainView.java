package com.github.hronom.game.cards.gui.views;

import com.github.hronom.game.cards.gui.controllers.CalculateButtonActionController;
import com.github.hronom.game.cards.gui.controllers.CalculateButtonTextController;
import com.github.hronom.game.cards.gui.models.CardsComboBoxModel;
import com.github.hronom.game.cards.gui.models.CardsComboBoxRenderer;
import com.github.hronom.game.cards.gui.utils.UTFResourceBundle;
import com.github.hronom.poker.helper.core.cards.Card;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.*;

/**
 * Created by hronom on 25.07.15.
 */
public class MainView {
    private static final ResourceBundle resourceBundle = UTFResourceBundle
        .getBundle("MessagesBundle");//NON-NLS

    private static final String appName = resourceBundle.getString("app.name");

    private final JComboBox<Card> cardJComboBox1;
    private final JComboBox<Card> cardJComboBox2;
    private final JComboBox<Card> cardJComboBox3;
    private final JComboBox<Card> cardJComboBox4;
    private final JComboBox<Card> cardJComboBox5;
    private final JComboBox<Card> cardJComboBox6;
    private final JButton calculateButton;
    private final JTextArea outputTextArea;

    public MainView() {
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

        {
            CalculateButtonTextController
                calculateButtonTextController
                = new CalculateButtonTextController(
                cardJComboBox1,
                cardJComboBox2,
                cardJComboBox3,
                cardJComboBox4,
                cardJComboBox5,
                cardJComboBox6,
                calculateButton
            );
        }

        {
            CalculateButtonActionController
                calculateButtonActionController
                = new CalculateButtonActionController(
                cardJComboBox1,
                cardJComboBox2,
                cardJComboBox3,
                cardJComboBox4,
                cardJComboBox5,
                cardJComboBox6,
                calculateButton,
                outputTextArea
            );
        }

        ArrayList<Image> images = new ArrayList<>();
        images.add(getImage("1436133329_cards.png"));
        images.add(getImage("1436133363_cards.png"));
        images.add(getImage("1436133367_cards.png"));
        images.add(getImage("1436133371_cards.png"));
        images.add(getImage("1436133374_cards.png"));
        images.add(getImage("1436133378_cards.png"));
        images.add(getImage("1436133381_cards.png"));

        Properties properties = new Properties();
        try {
        properties.load(this.getClass().getResourceAsStream("/poker-helper-gui.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame(appName + " v" + properties.getProperty("app.version") + "/" + properties.getProperty("app.buildNumber"));
        frame.setIconImages(images);
        frame.setContentPane(mainPanel);
        frame.setPreferredSize(new Dimension(640, 540));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private Image getImage(String fileName) {
        URL url = this.getClass().getResource(fileName);
        ImageIcon imageIcon = new ImageIcon(url);
        return imageIcon.getImage();
    }
}
