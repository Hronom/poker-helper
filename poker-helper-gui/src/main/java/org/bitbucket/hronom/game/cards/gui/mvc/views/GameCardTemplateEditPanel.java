package org.bitbucket.hronom.game.cards.gui.mvc.views;

import org.bitbucket.hronom.game.cards.gui.mvc.views.old.DraggableImageComponent;
import org.bitbucket.hronom.game.cards.gui.mvc.views.old.JResizer;
import org.bitbucket.hronom.game.cards.gui.mvc.views.old.PopClickListener;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Created by hronom on 19.04.15.
 */
public class GameCardTemplateEditPanel {
    public final JPanel album;

    public GameCardTemplateEditPanel() {
        album = new JPanel();
        album.setBackground(Color.darkGray);
        album.setLayout(null);

        /*Is good create a Thread to manipulate Forms and Files. In this particular
         * case an <b>invokeLater</b> is needed becaouse all Forms graphics operations
         * needs to be elaborated after pending events are processed
         */
        java.awt.EventQueue.invokeLater(
            new Runnable() {

                public void run() {
                    loadPhotos();
                }
            }
        );
    }

    /**
     * Generate names of files
     */
    public void loadPhotos() {
        album.removeAll();
        for (int i = 1; i <= 8; i++) {
            String fileName = String.valueOf(i) + ".jpg";
            addNewPhoto(fileName);
        }
        album.repaint();
    }

    public void addNewPhoto(String fileName) {
        //Get resources from Directory or Jar file
        Image img = Toolkit.getDefaultToolkit().createImage("images/" + fileName);

        //Creates a draggableImageComponent and adds loaded image
        DraggableImageComponent photo = new DraggableImageComponent();

        photo.setImage(img);//Sets image
        photo.setAutoSize(true);//The component get ratio w/h of source image
        //photo.setOverbearing(true);//On click ,this panel gains lowest z-buffer
        photo.setBorder(new LineBorder(Color.black, 1));

        //A small randomization of object size/position
        int delta = album.getWidth() / 4;
        int randomGrow = getRandom(getRandom(delta * 2));
        int cx = album.getWidth() / 2;
        int cy = album.getHeight() / 2;
        photo.setSize(delta + randomGrow, delta + randomGrow);
        photo.setLocation(
            cx + getRandom(delta / 2) - photo.getWidth() / 2,
            cy + getRandom(delta / 2) - photo.getHeight() / 2
        );

        JResizer resizer = new JResizer(photo);
        resizer.setBounds(0, 0, 100, 100);
        resizer.addMouseListener(new PopClickListener(album, resizer));
        album.add(resizer);//Adds this component to main container

        album.repaint();
    }

    public static int getRandom(int range) {
        int r = (int) (Math.random() * range) - range;
        return r;
    }
}
