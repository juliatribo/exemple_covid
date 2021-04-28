package edu.upc.dsa;

import edu.upc.dsa.Classes.*;

import java.util.HashMap;
import java.util.List;


public interface Covid19Manager {

  /*
    public List<Product> getProductByPrize();
    public List<Order> getOrdersByUser(String userId);
    public void newOrder(Order o);
    public Order processOrder();
    public List<Product> getProductBySales();
    //public User getUser(String userId);
    public void addProduct(Product p);
    public void addUser(User user);

   */
    public void clear();
    public void dirty();
    public boolean isDirty();
    public void newPersona(Persona p);
    public void extraerMuestra(Muestra muestra);
    public void processMuestra(Laboratorio l,Informe informe);
    public Persona getPersona(String personaId);
    public List<String> getMuestrasByUser(String userName);
    public void addLab(Laboratorio l);


}
