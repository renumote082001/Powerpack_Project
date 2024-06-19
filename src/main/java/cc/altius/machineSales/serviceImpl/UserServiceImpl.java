/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.serviceImpl;

import cc.altius.machineSales.dao.UserDao;
import cc.altius.machineSales.model.User;
import cc.altius.machineSales.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author altius
 */
@Service
public class UserServiceImpl implements UserService,UserDetailsService{
    
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return this.userDao.getUserList();
    }

    @Override
    public int addUser(User user) {
        return this.userDao.addUser(user);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException{
         User user = this.userDao.loadUserByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }else{
            return user;
        }
        
    }

    @Override
    public User getUserById(int userId) {
        return this.userDao.getUserById(userId);
    }

    @Override
    public int editUser(User user) {
        return this.userDao.editUser(user);
    }
    
    
    }
    
    
    
    
    
