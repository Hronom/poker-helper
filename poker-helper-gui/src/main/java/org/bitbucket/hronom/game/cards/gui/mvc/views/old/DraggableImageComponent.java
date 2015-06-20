package org.bitbucket.hronom.game.cards.gui.mvc.views.old;

/*
 *  Copyright 2010 De Gregorio Daniele.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

import java.awt.*;
import java.awt.image.ImageObserver;

import javax.swing.*;

/**
 * This is an extension of Draggable Component with a custom Image for backgraound
 * setting it by <b>setImage</b> method. You can use it as simple Image Panel with
 * <b>setDraggable(false)</b>.
 * It implements  ImageObserver for Image loading problems. it repaints itself after
 * image is full loaded.
 */
public class DraggableImageComponent extends JComponent implements ImageObserver {

    protected Image image;
    private boolean autoSize = false;
    private Dimension autoSizeDimension = new Dimension(0, 0);

    public DraggableImageComponent() {
        super();
        setLayout(null);
        setBackground(Color.black);
    }

    /**
     * This overrided method paints image on Component if any. Else it paints a Background color.
     * If <b>autoSize</b> is TRUE , it paints image with original ration, on a Background Color box
     * if opaque.
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, getWidth(), getHeight());
        if (image != null) {
            setAutoSizeDimension();
            g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);

            g.setColor(Color.BLUE);
            g.fillRect(0, 0, 3, 3);
        } else {
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.BLUE);
            //g.fillRect(0, 0, 10, 10);
        }
    }

    /**
     * It is a simple tecnique to retrieve dimensions of Image, preserving ratio w/h of image
     * and make a best matching on the parent box.
     */
    private Dimension adaptDimension(Dimension source, Dimension dest) {
        int sW = source.width;
        int sH = source.height;
        int dW = dest.width;
        int dH = dest.height;
        double ratio = ((double) sW) / ((double) sH);
        if (sW >= sH) {
            sW = dW;
            sH = (int) (sW / ratio);
        } else {
            sH = dH;
            sW = (int) (sH * ratio);
        }
        return new Dimension(sW, sH);
    }

    /**
     * Checks if image is full loaded.
     *
     * @param img       target image
     * @param infoflags is equal to <b>>ALLBITS</b> when loading is finished
     * @param x         x position
     * @param y         y position
     * @param w         width
     * @param h         height
     * @return TRUE if image can generates events, FALSE otherwise
     */
    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int w, int h) {
        if (infoflags == ALLBITS) {
            repaint();
            setAutoSizeDimension();
            return false;
        }
        return true;
    }

    /**
     * This method is used to resize component considering w/h ratio of image.
     */
    private void setAutoSizeDimension() {
        if (!autoSize) {
            return;
        }
        if (image != null) {
            if (image.getHeight(null) == 0 || getHeight() == 0) {
                return;
            }
            if ((getWidth() / getHeight()) == (image.getWidth(null) / (image.getHeight(null)))) {
                return;
            }
            autoSizeDimension = adaptDimension(
                new Dimension(
                    image.getWidth(null),
                    image.getHeight(null)
                ), this.getSize()
            );
            setSize(autoSizeDimension.width, autoSizeDimension.height);
        }
    }

    /**
     * It is used to Resize component when it has an AutoSize value setted on TRUE
     */
    public void grow(int pixels) {
        double ratio = getWidth() / getHeight();
        setSize(getSize().width + pixels, (int) (getSize().height + (pixels / ratio)));
    }

    /**
     * Get the value of autoSize
     *
     * @return the value of autoSize
     */
    public boolean isAutoSize() {
        return autoSize;
    }

    /**
     * Set the value of autoSize
     *
     * @param autoSize new value of autoSize
     */
    public void setAutoSize(boolean autoSize) {
        this.autoSize = autoSize;
    }

    /**
     * Get the value of image
     *
     * @return the value of image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Set the value of image by String name. Use ToolKit to create image from file.
     * use setImage(Image image) if you just have an image.
     *
     * @param image fileName of image
     */
    public void setImage(String image) {
        setImage(Toolkit.getDefaultToolkit().getImage(image));
    }

    /**
     * Set the value of image
     *
     * @param image new value of image
     */
    public void setImage(Image image) {
        this.image = image;
        repaint();
        setAutoSizeDimension();
    }
}
