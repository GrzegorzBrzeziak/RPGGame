package pl.sda.view.core;

import pl.sda.model.*;

public class GameViewService {


    public GameViewService() {
    }

    public void printPlayerStats(Player player) {
        System.out.println("Masz teraz: " + player.getMinAttack() + " - " + player.getMaxAttack() + " ataku, " + player.getAccuracy() + " celności, " + player.getCriticalChance() + "% szansy na krytyczne uderzenie o wartości: x" + player.getCriticalMultiplayer() + "\n" + player.getHp() + " HP, " + player.getArmor() + " pancerza, " + player.getMaxHp() + " maksymalnego HP, " + player.getDodge() + " uników i\n" + player.getXp() + " XP.\n");
    }

    public void youLose() {
        System.out.println("Przegrałeś!! Spróbuj jeszcze raz.");
    }

    public void printPlayerHp(Player player) {
        System.out.println("Gracz ma: " + player.getHp() + " HP\n");
    }
    public void printPlayerXp(Player player) {
        System.out.println("Gracz ma: " + player.getXp() + " XP");
    }

    public void printMonsterHp(Monster monster) {
        System.out.println("Potwór: " + monster.getName() + " ma " + monster.getHp() + " HP");
    }

    public void printMonsterAttack(Monster monster, int monsterDmg) {
        System.out.println("Potwór: " + monster.getName() + " atakuje Ciebie za " + monsterDmg + " DMG.");
    }

    public void printPlayerAttack(int playerDmg) {
        System.out.println("Atakujesz potwora za: " + playerDmg + " DMG.");
    }

    public void printCriticalDamage(int damage) {
        System.out.println("CRITICAL! " + damage + " DMG.");
    }

    public void printMissedPlayerAttack(Player player) {
        System.out.println("Pudłujesz!");
    }

    public void printMissedMonsterAttack(Monster monster) {
        System.out.println("Potwór: " + monster.getName() + " pudłuje!");
    }

    public void printAttackingMonsterName(Monster monster) {
        System.out.println("Atakuje Ciebie Potwór: " + monster.getName());
    }

    public void printFoundTreasure(Treasure treasure) {
        System.out.println("Znajdujesz skarb: " + treasure.getName());
    }

    public void printFoundTreasureGetHp(Treasure treasure) {
        System.out.println("Zdobywasz: " + treasure.getHp() + " HP");
    }

    public void printFoundTreasureGetAttack(Treasure treasure) {
        System.out.println("Zdobywasz: " + treasure.getAttack() + " ataku");
    }

    public void printFoundTreasureGetArmor(Treasure treasure) {
        System.out.println("Zdobywasz: " + treasure.getArmor() + " pancerza");
    }

    public void printFoundTreasureGetMaxHP(Treasure treasure) {
        System.out.println("Zdobywasz: " + treasure.getMaxhp() + " do max HP");
    }


    public void printEncounterName(Encounter encounter) {
        System.out.println("Spotykasz się z: " + encounter.getName() + "em");
    }

    public void printEncounterId1(Encounter encounter) {
        System.out.println("Uzdrowiciel przywraca Ciebie do pełni sił.");
    }

    public void printEncounterGetHp(Encounter encounter) {
        System.out.println("Masz: " + encounter.getHp() + " do HP");
    }

    public void printEncounterGetAttack(Encounter encounter) {
        System.out.println("Masz: " + encounter.getArmor() + " do pancerza");
    }

    public void printEncounterGetArmor(Encounter encounter) {
        System.out.println("Masz: " + encounter.getAttack() + " do ataku");
    }

    public void youHaveGainedALevel(Player player){
        System.out.println("Zdobywasz poziom: " + player.getPlayerLevel() + "!\n" + "Wybierz który atrybut podwyższasz: \n1.Witalność: +10 do HP i max HP.\n2.Siła: +3 do min i max ataku.\n3.Zręczność: +5 do uników i do celności.\n4.Szczęście: +2 do max ataku i +2% szansy na trafienie krytyczne.");
    }
    public void nothingHappens(){
        System.out.println("Nie natrafiasz na nic niezwykłego.");
    }

}
