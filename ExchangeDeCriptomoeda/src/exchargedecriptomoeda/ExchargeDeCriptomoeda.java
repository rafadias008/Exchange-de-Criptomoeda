/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exchargedecriptomoeda;

import View.CadastroCripto;
import View.CadastroInvest;
import View.Login;

/**
 *
 * @author rafae
 */
public class ExchargeDeCriptomoeda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login();
        
        login.setVisible(true);
        
        CadastroInvest cp = new CadastroInvest();
        
        cp.setVisible(true);
    }
    
}
