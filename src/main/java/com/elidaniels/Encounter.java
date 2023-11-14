package com.elidaniels;

import java.util.Random;

import com.elidaniels.battledata.Battle;
import com.elidaniels.fighterdata.Enemy;
import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.fighterdata.Player;

public class Encounter {

    Player player;
    
    public Encounter(Player player) {
        this.player = player;
    }

    public void randomEvent() {
        doBattle();
    }

    private void doBattle() {
        Enemy enemy = generateEnemy();
        Battle battle = new Battle(player, enemy);
        Fighter winner = battle.startBattle();

        if (winner.isPlayer()) {
            player.getLevel().gainExp(100);
            player.getLevel().checkLevelUP();
        }
        else {
            System.out.println("YOU DIED");
            // player.revivePlayer();
        }

    }

    private Enemy generateEnemy() {
        Random rand = new Random();
        int x = rand.nextInt(3);

        if (x == 0) {
            return new Enemy("Goblin", 50, 11);
        } else if (x == 1) {
            return new Enemy("Zombie", 70, 30);
        } else {
            return new Enemy("Wolf", 70, 20);
        }
    }

    
}
