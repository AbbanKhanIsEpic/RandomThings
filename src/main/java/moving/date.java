/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moving;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author abban
 */
public class date {
    public static void main(String[] args) {
        while(true){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String time = dtf.format(now);
        System.out.println(time);
        }
    }
}
