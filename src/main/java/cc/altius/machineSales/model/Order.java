/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author altius
 */

@Data

@NoArgsConstructor

@AllArgsConstructor
public class Order {
    
    private int orderId;
    
    private IdAndLabel user;
    
    private String code;
    
    private IdAndLabel orderStatus;
    
    private Date orderDate;
   
    
}
