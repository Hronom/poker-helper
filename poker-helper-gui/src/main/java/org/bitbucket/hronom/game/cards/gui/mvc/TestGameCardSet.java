package org.bitbucket.hronom.game.cards.gui.mvc;

import org.bitbucket.hronom.game.cards.core.elements.GameCard;
import org.bitbucket.hronom.game.cards.core.elements.GameCardElementText;
import org.bitbucket.hronom.game.cards.core.elements.GameCardsGroup;
import org.bitbucket.hronom.game.cards.core.elements.GameCardsSet;
import org.bitbucket.hronom.game.cards.core.elements.GameCardsTemplate;
import org.bitbucket.hronom.game.cards.core.elements.GameCardsUtils;

/**
 * Created by hronom on 05.05.15.
 */
public class TestGameCardSet {
    private TestGameCardSet() {

    }

    public static GameCardsSet get() {
        GameCardsSet gameCardsSet = new GameCardsSet();

        {
            GameCardsGroup gameCardsGroup = new GameCardsGroup();

            {
                GameCardsTemplate gameCardsTemplate = new GameCardsTemplate();
                {
                    GameCardElementText gameCardElement = new GameCardElementText();
                    gameCardsTemplate.gameCardElements.add(gameCardElement);
                }

                {
                    GameCard gameCard = GameCardsUtils
                        .createGameCardFromTemplate(gameCardsTemplate);
                    gameCardsGroup.gameCards.add(gameCard);
                }

                {
                    GameCard gameCard = GameCardsUtils
                        .createGameCardFromTemplate(gameCardsTemplate);
                    gameCardsGroup.gameCards.add(gameCard);
                }

                {
                    GameCard gameCard = GameCardsUtils
                        .createGameCardFromTemplate(gameCardsTemplate);
                    gameCardsGroup.gameCards.add(gameCard);
                }
            }

            gameCardsSet.addGameCardsGroups(gameCardsGroup);
        }

        return gameCardsSet;
    }
}
