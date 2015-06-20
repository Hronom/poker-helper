package org.bitbucket.hronom.game.cards.gui.mvc.views.old;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class JResizer extends JComponent {
    public JResizer(Component comp) {
        this(comp, new DefaultResizableBorder(6));
    }

    public JResizer(Component comp, ResizableBorder border) {
        setLayout(new BorderLayout());
        add(comp);
        setBorder(border);
    }

    public void setBorder(Border border) {
        removeMouseListener(resizeListener);
        removeMouseMotionListener(resizeListener);
        if (border instanceof ResizableBorder) {
            addMouseListener(resizeListener);
            addMouseMotionListener(resizeListener);
        }
        super.setBorder(border);
    }

    private void didResized() {
        if (getParent() != null) {
            getParent().repaint();
            invalidate();
            ((JComponent) getParent()).revalidate();
        }
    }

    MouseInputListener resizeListener = new MouseInputAdapter() {
        public void mouseMoved(MouseEvent me) {
            ResizableBorder border = (ResizableBorder) getBorder();
            setCursor(Cursor.getPredefinedCursor(border.getResizeCursor(me)));
        }

        public void mouseExited(MouseEvent mouseEvent) {
            setCursor(Cursor.getDefaultCursor());
        }

        private int cursor;
        private Point startPos = null;

        public void mousePressed(MouseEvent me) {
            ResizableBorder border = (ResizableBorder) getBorder();
            cursor = border.getResizeCursor(me);
            startPos = me.getPoint();
        }

        public void mouseDragged(MouseEvent me) {
            if (startPos != null) {
                int dx = me.getX() - startPos.x;
                int dy = me.getY() - startPos.y;
                switch (cursor) {
                    case Cursor.N_RESIZE_CURSOR:
                        setBounds(getX(), getY() + dy, getWidth(), getHeight() - dy);
                        didResized();
                        break;
                    case Cursor.S_RESIZE_CURSOR:
                        setBounds(getX(), getY(), getWidth(), getHeight() + dy);
                        startPos = me.getPoint();
                        didResized();
                        break;
                    case Cursor.W_RESIZE_CURSOR:
                        setBounds(getX() + dx, getY(), getWidth() - dx, getHeight());
                        didResized();
                        break;
                    case Cursor.E_RESIZE_CURSOR:
                        setBounds(getX(), getY(), getWidth() + dx, getHeight());
                        startPos = me.getPoint();
                        didResized();
                        break;
                    case Cursor.NW_RESIZE_CURSOR:
                        setBounds(getX() + dx, getY() + dy, getWidth() - dx, getHeight() - dy);
                        didResized();
                        break;
                    case Cursor.NE_RESIZE_CURSOR:
                        setBounds(getX(), getY() + dy, getWidth() + dx, getHeight() - dy);
                        startPos = new Point(me.getX(), startPos.y);
                        didResized();
                        break;
                    case Cursor.SW_RESIZE_CURSOR:
                        setBounds(getX() + dx, getY(), getWidth() - dx, getHeight() + dy);
                        startPos = new Point(startPos.x, me.getY());
                        didResized();
                        break;
                    case Cursor.SE_RESIZE_CURSOR:
                        setBounds(getX(), getY(), getWidth() + dx, getHeight() + dy);
                        startPos = me.getPoint();
                        didResized();
                        break;
                    case Cursor.MOVE_CURSOR:
                        Rectangle bounds = getBounds();
                        bounds.translate(dx, dy);
                        setBounds(bounds);
                        didResized();
                }

                // cursor shouldn't change while dragging
                setCursor(Cursor.getPredefinedCursor(cursor));
            }
        }

        public void mouseReleased(MouseEvent mouseEvent) {
            startPos = null;
        }
    };
}

