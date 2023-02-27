/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import java.util.List;

/**
 *
 * @author user
 */
public interface IServiceUser extends IService<User>{
    public String login(String email,String password);
    public void forgetPassword(String email);
    public User findByUserId(int id);
    public User findByEmail(String email);
    public List<User> find(String nom,String prenom,String numTel,String role,String email,Boolean desactive);
    public void acrivateDesactivateUSer(int userId,Boolean activate);
    public void modifiersansMotdePasse(User u);
    public void extractUsers();
    
}
