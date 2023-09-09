/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *///
package BLL;

import DAL.HibernateUtils;
import org.hibernate.Session;

public class OpenSession {

    public OpenSession() {
        Session session = HibernateUtils.getSessionFactory().openSession();
    }
    
}
