package org.bitbucket.hronom.game.cards.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class PokerHelperGuiMain {
    private static final Logger logger = LogManager.getLogger();

    //private final MainView mainView;
    private final String propertiesFileName = "game-cards-editor.properties";

    public PokerHelperGuiMain() {
        //mainView = new MainView();
    }

    public static void main(String args[]) {
        JTree tree = new JTree();
        TreeModel treeModel = new TreeModel() {
            @Override
            public Object getRoot() {
                return null;
            }

            @Override
            public Object getChild(Object parent, int index) {
                return null;
            }

            @Override
            public int getChildCount(Object parent) {
                return 0;
            }

            @Override
            public boolean isLeaf(Object node) {
                return false;
            }

            @Override
            public void valueForPathChanged(TreePath path, Object newValue) {

            }

            @Override
            public int getIndexOfChild(Object parent, Object child) {
                return 0;
            }

            @Override
            public void addTreeModelListener(TreeModelListener l) {
            }

            @Override
            public void removeTreeModelListener(TreeModelListener l) {

            }
        };

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            PokerHelperGuiMain pokerHelperGuiMain = new PokerHelperGuiMain();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
