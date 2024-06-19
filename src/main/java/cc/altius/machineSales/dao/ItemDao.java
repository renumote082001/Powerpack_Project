/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cc.altius.machineSales.dao;

import cc.altius.machineSales.model.Item;
import java.util.List;

/**
 *
 * @author altius
 */
public interface ItemDao {
    
    public List<Item> getItemList();
    
    public List<Item> getItemByLevel(int level);
}
