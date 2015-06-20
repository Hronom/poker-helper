package org.bitbucket.hronom.game.cards.gui.mvc.views.old;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class PopClickListener extends MouseAdapter {
    private final JPanel panel;
    private final JComponent component;

    public PopClickListener(JPanel panelArg, JComponent componentArg) {
        panel = panelArg;
        component = componentArg;
    }

    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) {
            doPop(e);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            doPop(e);
        }
    }

    private void doPop(MouseEvent e) {
        PopUpDemo menu = new PopUpDemo(panel, component);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}