package game;

import game.dice.Dice;
import game.dice.DiceCard;
import game.dice.Resource;
import org.junit.Assert;
import org.junit.Test;
import static game.DiceRoll.roll;

public class DiceRollTest {

    @Test
    public void rollTest(){
        Dice d1 = new Dice();
        d1.solarDiceInit();
        Dice d2 = new Dice();
        d2.lunarDiceInit();

        for (int i = 0; i < 1000; i++) {
            DiceCard[] roll = new DiceCard[]{roll(d1), roll(d2)};

            Assert.assertTrue((roll[0].equals(new DiceCard(1, Resource.SOLAR)))|| (roll[0].equals(new DiceCard(1, Resource.GOLD))));
            Assert.assertTrue((roll[1].equals(new DiceCard(1, Resource.LUNAR)))|| (roll[1].equals(new DiceCard(1, Resource.GOLD)))|| (roll[1].equals(new DiceCard(2, Resource.VICTORY))));
        }

    }
}