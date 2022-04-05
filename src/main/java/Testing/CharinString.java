/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testing;
import javax.swing.*;
/**
 *
 * @author abban
 */
public class CharinString {
    public static void main(String[] args) {
        String word = JOptionPane.showInputDialog("Give me a number");
        String reword = word.charAt(0) + "";
        for(int i = 1; i < word.length();i++){
            reword = reword + word.charAt(i);
            int rewordint = Integer.parseInt(reword);
            System.out.println(rewordint);
            
        }
        word = JOptionPane.showInputDialog("Give me a equation");
        String find_divide = "";
        String find_multiply = "";
        String find_plus = "";
        String find_minus = "";
        char divide = '/';
        char multiply = '*';
        char minus = '-';
        char plus = '+';
        double term1 = 0;
        double term2 = 0;
        String term1Str = "";
        String term2Str = "";
        int termdivider = 0;
        int sepetor = 0;
        for(int i = 0;i < word.length();i++){
            char find = word.charAt(i);
            if(find == divide){
                find_divide = find_divide + i + " ";
                System.out.println("The divide symbol position is: " + find_divide);
            }
            if(find == multiply){
                find_multiply = find_multiply + i + " ";
                System.out.println("The multiply symbol position is: " + find_multiply);
            }
            if(find == plus){
                find_plus = find_plus + i + " ";
                System.out.println("The plus symbol position is: " + find_plus);
                termdivider += 1;
            }
            if(find == minus){
                find_minus = find_minus + i + " ";
                System.out.println("The minus symbol position is: " + find_minus);
                termdivider +=1;
            }
        }
        System.out.println(termdivider);
    }
}
