package org.bitbucket.hronom.game.cards.gui.mvc.models;

import org.bitbucket.hronom.game.cards.gui.mvc.TestGameCardSet;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * Created by hronom on 05.05.15.
 */
public class CardsSetTreeModel implements TreeModel {
    private DefaultMutableTreeNode rootTreeNode = new DefaultMutableTreeNode();

    public CardsSetTreeModel() {
        rootTreeNode.setUserObject(TestGameCardSet.get());
    }

    @Override
    public Object getRoot() {
        return rootTreeNode;
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
}
