package com.github.hronom.game.cards.gui.controllers;

import com.github.hronom.game.cards.gui.utils.UTFResourceBundle;
import com.github.hronom.poker.helper.core.cards.Card;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.*;

/**
 * Created by hronom on 04.07.15.
 */
public class CalculateButtonTextController implements ActionListener {
    private final ResourceBundle resourceBundle = UTFResourceBundle.getBundle("MessagesBundle");
    //NON-NLS
    private final JComboBox<Card> cardJComboBox1;
    private final JComboBox<Card> cardJComboBox2;
    private final JComboBox<Card> cardJComboBox3;
    private final JComboBox<Card> cardJComboBox4;
    private final JComboBox<Card> cardJComboBox5;
    private final JComboBox<Card> cardJComboBox6;
    private final JButton calculateButton;

    public CalculateButtonTextController(
        JComboBox<Card> cardJComboBox1Arg,
        JComboBox<Card> cardJComboBox2Arg,
        JComboBox<Card> cardJComboBox3Arg,
        JComboBox<Card> cardJComboBox4Arg,
        JComboBox<Card> cardJComboBox5Arg,
        JComboBox<Card> cardJComboBox6Arg,
        JButton calculateButtonArg
    ) {
        cardJComboBox1 = cardJComboBox1Arg;
        cardJComboBox1.addActionListener(this);
        cardJComboBox2 = cardJComboBox2Arg;
        cardJComboBox2.addActionListener(this);
        cardJComboBox3 = cardJComboBox3Arg;
        cardJComboBox3.addActionListener(this);
        cardJComboBox4 = cardJComboBox4Arg;
        cardJComboBox4.addActionListener(this);
        cardJComboBox5 = cardJComboBox5Arg;
        cardJComboBox5.addActionListener(this);
        cardJComboBox6 = cardJComboBox6Arg;
        cardJComboBox6.addActionListener(this);
        calculateButton = calculateButtonArg;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cardJComboBox1.getSelectedIndex() > 0 &&
            cardJComboBox2.getSelectedIndex() > 0 &&
            cardJComboBox3.getSelectedIndex() > 0 &&
            cardJComboBox4.getSelectedIndex() > 0 &&
            cardJComboBox5.getSelectedIndex() > 0 &&
            cardJComboBox6.getSelectedIndex() > 0) {
            calculateButton.setText(resourceBundle.getString("app.gui.buttons.calculate.river"));
            calculateButton.setEnabled(true);
        } else if (cardJComboBox1.getSelectedIndex() > 0 &&
                   cardJComboBox2.getSelectedIndex() > 0 &&
                   cardJComboBox3.getSelectedIndex() > 0 &&
                   cardJComboBox4.getSelectedIndex() > 0 &&
                   cardJComboBox5.getSelectedIndex() > 0 &&
                   cardJComboBox6.getSelectedIndex() == -1) {
            calculateButton.setText(resourceBundle.getString("app.gui.buttons.calculate.turn"));
            calculateButton.setEnabled(true);
        } else {
            calculateButton.setText(resourceBundle.getString("app.gui.buttons.calculate.disabled"));
            calculateButton.setEnabled(false);
        }
    }
}
