
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testing;

/**
 *
 * @author abban
 */
import javax.swing.JOptionPane;
public class Arrays {
    public static void main(String[] args) {
        int number = Integer.parseInt(JOptionPane.showInputDialog("number"));
        String[] friends = new String[number];
        String list = "";
        for(int i = 0; i < number;i++){
            friends[i] = JOptionPane.showInputDialog("word");
        }
        for(int i = 0; i < number;i++){
            if(i  == number - 1){
                friends[i] = " pratice." + friends[i];
            }
            else{
            friends[i] = " pratice." + friends[i] + " AND";
            }
            list = list + friends[i]; 
        }
        System.out.println(list);
        
    }
}
