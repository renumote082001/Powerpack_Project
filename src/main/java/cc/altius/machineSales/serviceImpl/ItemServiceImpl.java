/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.serviceImpl;

import cc.altius.machineSales.dao.ItemDao;
import cc.altius.machineSales.model.Item;
import cc.altius.machineSales.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author altius
 */
@Service
public class ItemServiceImpl implements ItemService{
    
    @Autowired
    private ItemDao itemDao;

    

    @Override
    public List<Item> getItemList() {
        return this.itemDao.getItemList();
    }

    @Override
    public List<Item> getItemByLevel(int level) {
        return this.itemDao.getItemByLevel(level);
    }
   
    
  
    
}
