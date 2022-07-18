/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testing;

/**
 *
 * @author abban
 */
public class FindingASetOfString {
    public static void main(String[] args) {
        String find = "abc";
        String list = "abekedabc";
        boolean check = list.contains(find);
        if(check){
            System.out.println(find);
        }
    }
    
}
