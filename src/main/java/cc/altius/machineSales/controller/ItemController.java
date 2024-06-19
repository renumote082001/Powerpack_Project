/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.controller;

import cc.altius.machineSales.model.Item;
import cc.altius.machineSales.service.ItemService;
import ch.qos.logback.core.CoreConstants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author altius
 */
@Controller
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
        @RequestMapping(value="/itemList.htm" ,method = RequestMethod.GET)
        public String listItem(ModelMap model){
        System.out.println("iside controller");
        List<Item> itemList = this.itemService.getItemList(); 
        model.addAttribute("itemList", itemList);
        return "itemList";
        }
        
        @RequestMapping(value="/itemByLevel.htm", method=RequestMethod.GET)
        public String getItemByLevel(@RequestParam(value = "level", required = false, defaultValue = "0") int level, ModelMap model) {
        List<Item> items = itemService.getItemByLevel(level);
        model.addAttribute("items", items);
        return "itemDetails"; 
}
}

