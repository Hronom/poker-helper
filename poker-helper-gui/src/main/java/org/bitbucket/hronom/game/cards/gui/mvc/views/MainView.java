package org.bitbucket.hronom.game.cards.gui.mvc.views;

import org.bitbucket.hronom.game.cards.gui.mvc.models.CardsSetTreeModel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/**
 * Created by hronom on 19.04.15.
 */
public class MainView {
    private final JFrame frame;
    private JTree tree1;
    private JButton button1;

    public MainView() {
        frame = new JFrame("Photo Album");
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLayout(new GridBagLayout());

        frame.addWindowListener(
            new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        {
            {
                final JSplitPane splitPane1 = new JSplitPane();
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.gridwidth = 2;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                gbc.fill = GridBagConstraints.BOTH;

                {
                    tree1 = new JTree(new CardsSetTreeModel());
                    splitPane1.setLeftComponent(tree1);
                }

                {
                    final JPanel panel2 = new JPanel();
                    panel2.setLayout(new GridBagLayout());

                    {
                        final GameCardTemplateEditPanel
                            gameCardTemplateEditPanel
                            = new GameCardTemplateEditPanel();
                        // !! IMPORTANT !! you have to set a free layout at least ( FREE, ABSOLUTE, NULL is best)
                        panel2.add(gameCardTemplateEditPanel.album, gbc);

        /* Is good create a Thread to manipulate Forms and Files. In this particular
         * case an <b>invokeLater</b> is needed becaouse all Forms graphics operations
         * needs to be elaborated after pending events are processed
         */
                        java.awt.EventQueue.invokeLater(
                            new Runnable() {
                                public void run() {
                                    gameCardTemplateEditPanel.loadPhotos();
                                }
                            }
                        );
                    }

                    splitPane1.setRightComponent(panel2);
                }

                frame.add(splitPane1, gbc);
            }

            {
                final JToolBar toolBar1 = new JToolBar();
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.fill = GridBagConstraints.HORIZONTAL;

                {
                    button1 = new JButton();
                    button1.setText("Button");
                    toolBar1.add(button1);
                }

                frame.add(toolBar1, gbc);
            }
        }
    }

    private void processAction() {

    }
}
