/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cc.altius.machineSales.dao;

import cc.altius.machineSales.model.Order;
import java.util.List;

/**
 *
 * @author altius
 */
public interface OrderDao {
    
    public int addOrder(Order order);
    
    public List <Order> getOrderList();
    
    public Order getOrderById(int orderId);
    
    public int updateOrder(Order order);
    
    
}
