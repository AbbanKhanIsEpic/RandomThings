/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GamewithMethods;

/**
 *
 * @author abban
 */
public class Game {
    public static void MainGame(int number) {
        for(int level = 1; level <= 10; level++){
            System.out.println("Level: " + level);
            RNG(1,3,0);
            int bosshealth = 50 + level*10*number;
        }

    }
    static void RNG(double low, double high, int bosshealth){
        high++;
        int number = (int)(Math.random()*high+low);
        MainGame(number);
        Attack(bosshealth,number);
    }
    static void Attack(int bosshealth, int number){
        RNG(1,5,bosshealth);
        int totaldamage = 0;
        for(int i = 1; i <= 4; i++){
            RNG(1,5,bosshealth);
            if(number == 1){
                System.out.println("Attack: " + i + "\tAttack type: MISS " + "\t Attack Damage: 0");
                totaldamage += 0;
        }
        else if(number == 5){
            System.out.println("Attack: " + i + "\tAttack type: CRITICAL" + "\t Attack Damage: " + bosshealth/2);
            totaldamage += bosshealth/2;
        }
        else{
            System.out.println("Attack: " + i + "\tAttack type: MISS " + "\t Attack Damage: " + number*15);
            totaldamage += number*15;
        }
            
        }
    }
}
