package com.elidaniels.miscdata;

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
        Enemy enemy;
        if (player.getLevel().getLv() >= 5) {
            enemy = generateHighEnemy();
        }
        else {
            enemy = generateLowEnemy(); 
        }

        Battle battle = new Battle(player, enemy);
        Fighter winner = battle.startBattle();

        if (winner.isPlayer()) {
            player.getLevel().gainExp(100);
            player.getLevel().checkLevelUP();
        }
        else {
            System.out.println("YOU DIED");
            player.revivePlayer();
        }

    }

    private Enemy generateLowEnemy() {
        Random rand = new Random();
        int x = rand.nextInt(100);
         
        if (x >= 80) {
            return new Enemy("Goblin Grunt", 60, 15);
        } else if (x >= 65) {
            return new Enemy("Swamp Slime", 90, 12);
        } else if (x >= 50) {
            return new Enemy("Skeleton Warrior", 50, 22);
        } else if (x >= 35) {
            return new Enemy("White Viper", 40, 25);
        } else if (x >= 20) {
            return new Enemy("Venomdread Tarantula", 45, 24);
        } else if (x >= 10) {
            return new Enemy("Dimension Shifter", 90, 27);
        } else {
            return new Enemy("Moonlit Direwolf", 80, 30);
        }
    }

    private Enemy generateHighEnemy() {
        Random rand = new Random();
        int x = rand.nextInt(100);
         
        if (x >= 80) {
            return new Enemy("Aetheric Warlock", 90, 75); //Jaden
        } else if (x >= 65) {
            return new Enemy("Stardust Elf", 110, 66); //Lilike
        } else if (x >= 50) {
            return new Enemy("Obsidian Dragon", 100, 70); //Kelton
        } else if (x >= 35) {
            return new Enemy("Skyshroud Lurker", 105, 69); //Aidan
        } else if (x >= 20) {
            return new Enemy("Sylvan Huntress", 70, 82); //Nichola
        } else if (x >= 10) {
            return new Enemy("Crimson Phoenix", 140, 85); //
        } else {
            return new Enemy("Centurion Vanguard", 125, 90); //JJ
        }
    }

    
}
