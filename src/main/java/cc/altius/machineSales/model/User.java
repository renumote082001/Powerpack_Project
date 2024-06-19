/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.model;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author altius
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements UserDetails{
    
    @EqualsAndHashCode.Include
    private int userId;
    
    private String name;
    
    private String username;
    
    private String password;
    
    private IdAndLabel role;
    
    private List<GrantedAuthority> businessFunctionList;
    
    private boolean active;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        LinkedList <GrantedAuthority> authoritiesList = new LinkedList<>();
        authoritiesList.add(new SimpleGrantedAuthority(this.role.getId()));
        authoritiesList.addAll(this.getBusinessFunctionList());
        return authoritiesList;
    }

    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
       return this.active;
    }
    
    
    
}
