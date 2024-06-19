/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cc.altius.machineSales.service;

import cc.altius.machineSales.model.User;
import java.util.List;

/**
 *
 * @author altius
 */
public interface UserService {
    
    public List <User> getUserList();
    
    public int addUser(User user);
    
    public User getUserById(int userId);
    
    public int editUser(User user);
    
    public User loadUserByUsername(String username);
}
