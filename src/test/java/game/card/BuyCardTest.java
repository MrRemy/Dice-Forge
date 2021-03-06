package game.card;

import bot.AbstractBot;
import bot.SimpleBot;
import game.ScoreCounter;
import game.dice.BuyDiceCard;
import game.dice.Dice;
import game.dice.DiceCard;
import game.dice.Resource;
import org.junit.Assert;
import org.junit.Test;

import static game.card.BuyCard.buyCard;

public class BuyCardTest {

    @Test
    public void BuyCardTest() {

        BuyDiceCard.resetBotLog();
        BuyCard.resetBotLog();

        Dice d1 = new Dice();
        d1.solarDiceInit();
        Dice d2 = new Dice();
        d2.lunarDiceInit();
        ScoreCounter score = new ScoreCounter();

        Islands islands = new Islands(2);
        SimpleBot bot =  new SimpleBot(d1, d2, "Bot1","\033[0m");
        Inventory inventory = new Inventory(new AbstractBot[]{bot});
        AbstractCard card = new RegularCard(AbstractCard.Name.LE_PASSEUR, AbstractCard.Type.INSTANT, 12, 0,4);

        score.updateScore(bot, new DiceCard[]{new DiceCard(2, Resource.LUNAR), new DiceCard(2, Resource.LUNAR)});
        Assert.assertEquals(true, buyCard(bot, islands, card,inventory));
        Assert.assertEquals(0, bot.getBotScore().getSolar());
        Assert.assertEquals(12, bot.getBotScore().getVictory());

        Assert.assertEquals(false, buyCard(bot, islands, card,inventory));
    }
}
