/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.service;

import cc.altius.machineSales.model.Item;
import java.util.List;

/**
 *
 * @author altius
 */
public interface ItemService {

public List<Item> getItemList();

public List<Item> getItemByLevel(int level);   
}
