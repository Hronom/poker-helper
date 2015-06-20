package org.bitbucket.hronom.game.cards.gui.mvc.controllers;

import org.bitbucket.hronom.game.cards.core.AbstractModel;
import org.bitbucket.hronom.game.cards.gui.mvc.views.AbstractView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by hronom on 04.05.15.
 */
public abstract class AbstractController implements PropertyChangeListener {

    private ArrayList<AbstractView> registeredViews;
    private ArrayList<AbstractModel> registeredModels;

    public AbstractController() {
        registeredViews = new ArrayList<>();
        registeredModels = new ArrayList<>();
    }

    public void addModel(AbstractModel model) {
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
    }

    public void removeModel(AbstractModel model) {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }

    public void addView(AbstractView view) {
        registeredViews.add(view);
    }

    public void removeView(AbstractView view) {
        registeredViews.remove(view);
    }

    /**
     * Use this to observe property changes from registered models and propagate them on to all the
     * views.
     *
     * @param evt event.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        for (AbstractView view : registeredViews) {
            view.modelPropertyChange(evt);
        }
    }

    /**
     * This is a convenience method that subclasses can call upon
     * to fire property changes back to the models. This method
     * uses reflection to inspect each of the model classes
     * to determine whether it is the owner of the property
     * in question. If it isn't, a NoSuchMethodException is thrown,
     * which the method ignores.
     *
     * @param propertyName = The name of the property.
     * @param newValue     = An object that represents the new value
     *                     of the property.
     */
    protected void setModelProperty(String propertyName, Object newValue) {

        for (AbstractModel model : registeredModels) {
            try {
                Method method = model.getClass().getMethod(
                    "set" + propertyName, newValue.getClass()
                );
                method.invoke(model, newValue);
            } catch (Exception ex) {
                //  Handle exception.
            }
        }
    }
}
