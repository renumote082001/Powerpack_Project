/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.model;

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

public class Item {
    
    private int itemId;
    private int level;
    private String code;
    private String itemDescription;
    private Integer nextLevel;
}
