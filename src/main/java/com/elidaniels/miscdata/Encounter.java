package com.elidaniels.miscdata;

import com.elidaniels.battledata.Battle;
import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.fighterdata.FighterType;
import com.elidaniels.fighterdata.enemydata.Enemy;
import com.elidaniels.fighterdata.enemydata.EnemyGenerator;
import com.elidaniels.fighterdata.playerdata.Player;

public class Encounter {

    Player player;
    
    public Encounter(Player player) {
        this.player = player;
    }

    public void randomEvent() {
        doBattle();
    }

    private void doBattle() {
        
        Enemy enemy = EnemyGenerator.generateEnemy(player.getLevel().getLv());

        Battle battle = new Battle(player, enemy);
        battle.startBattle();
        Fighter winner = battle.getResult();

        if (winner.getFighterType().equals(FighterType.PLAYER)) {
            player.getLevel().gainExp(100);
            player.getLevel().checkLevelUP();
        }
        else {
            System.out.println("YOU DIED");
            player.revivePlayer();
        }

    }

    
    
}
