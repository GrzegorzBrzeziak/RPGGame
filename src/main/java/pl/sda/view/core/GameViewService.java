package pl.sda.view.core;

import pl.sda.model.Encounter;
import pl.sda.model.Monster;
import pl.sda.model.Player;
import pl.sda.model.Treasure;

public class GameViewService {


    public GameViewService() {
    }

    public void printPlayerStats(Player player){
        System.out.println("Masz teraz: " + player.getHp() + " HP, " + player.getMinAttack() + " - " + player.getMaxAttack() + " ataku, " + player.getArmor() + " pancerza, " + player.getMaxHp() + " maksymalnego HP.");

    }

    public void youLose(){
        System.out.println("Przegrałeś!! Spróbuj jeszcze raz.");
    }

    public void printPlayerHp(Player player){
        System.out.println("Gracz ma: " + player.getHp() + " HP");
    }

    public void printMonsterHp(Monster monster){
        System.out.println("Potwór: " + monster.getName() + " ma " + monster.getHp() + " HP");
    }

    public void printMonsterAttack(Monster monster, int monsterDmg){
        System.out.println("Potwór: " + monster.getName() + " atakuje Ciebie za " + monsterDmg + " DMG.");
    }

    public void printPlayerAttack(int playerDmg){
        System.out.println("Atakujesz potwora za: " + playerDmg + " DMG.");
    }

    public void printAttackingMonsterName(Monster monster){
        System.out.println("Atakuje Ciebie Potwór: " + monster.getName());
    }

    public void printFoundTreasure(Treasure treasure){
        System.out.println("Znajdujesz skarb: " + treasure.getName());
    }
    public void printFoundTreasureGetHp(Treasure treasure){
        System.out.println("Zdobywasz: " + treasure.getHp() + " HP");
    }
    public void printFoundTreasureGetAttack(Treasure treasure){
        System.out.println("Zdobywasz: " + treasure.getArmor() + " pancerza");
    }
    public void printFoundTreasureGetArmor(Treasure treasure){
        System.out.println("Zdobywasz: " + treasure.getAttack() + " ataku");
    }
    public void printFoundTreasureGetMaxHP(Treasure treasure){
        System.out.println("Zdobywasz: " + treasure.getMaxhp() + " do max HP");
    }


    public void printEncounterName(Encounter encounter){
        System.out.println("Spotykasz się z: " + encounter.getName() + "em");
    }
    public void printEncounterId1(Encounter encounter){
        System.out.println("Uzdrowiciel przywraca Ciebie do pełni sił.");
    }

    public void printEncounterGetHp(Encounter encounter){
        System.out.println("Masz: " + encounter.getHp() + " do HP");
    }
    public void printEncounterGetAttack(Encounter encounter){
        System.out.println("Masz: " + encounter.getArmor() + " do pancerza");
    }
    public void printEncounterGetArmor(Encounter encounter){
        System.out.println("Masz: " + encounter.getAttack() + " do ataku");
    }





}
