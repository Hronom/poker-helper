package org.bitbucket.hronom.game.cards.gui.mvc.views.old;

import java.awt.event.MouseEvent;

import javax.swing.border.Border;

public interface ResizableBorder extends Border {
    int getResizeCursor(MouseEvent me);
}
