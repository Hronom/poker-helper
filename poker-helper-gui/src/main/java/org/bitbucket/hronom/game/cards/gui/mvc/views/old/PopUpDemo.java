package org.bitbucket.hronom.game.cards.gui.mvc.views.old;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PopUpDemo extends JPopupMenu {
    public PopUpDemo(final JPanel panel, final JComponent component) {
        {
            JMenuItem item;
            item = new JMenuItem("Bring to Front");
            item.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //undoManager.undo();
                        panel.setComponentZOrder(component, 0);
                        component.repaint();
                    }
                }
            );
            add(item);
        }
        {
            JMenuItem item;
            item = new JMenuItem("Send to Back");
            item.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        int lowZ = 0;
                        for (Component currentComponent : panel.getComponents()) {
                            int componentZ = panel.getComponentZOrder(currentComponent);
                            if (lowZ < componentZ) {
                                lowZ = componentZ;
                            }
                        }

                        panel.setComponentZOrder(component, lowZ);
                        component.repaint();
                    }
                }
            );
            add(item);
        }
    }
}
