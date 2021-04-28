package edu.upc.dsa;

import edu.upc.dsa.Classes.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class Covid19ManagerTest {

    Covid19Manager pm = Covid19Managerimpl.getInstance();
    private Muestra muestra;
    private Persona persona;
    private Informe informe;
    private Laboratorio lab1;
    private Laboratorio lab2;


    @Before
    public void init(){

        persona = new Persona("1","Julia","Tribo",22,"A");
        Clinico clinico = new Clinico("Juan");
        lab1 = new Laboratorio("lab1");
        lab2 = new Laboratorio("lab2");
        pm.addLab(lab1);
        pm.addLab(lab2);
        Date fecha = new Date("December 17, 2022 03:24:00");
        muestra = new Muestra("1",clinico.getId(), persona.getNombre(),fecha,lab1.getId());

        informe = new Informe(false,"Negativo en coronavirus, positivo en ser un maquina");

        pm.newPersona(persona);

    }

    @After
    public void reset(){
        pm.clear();
    }

    @Test
    public void test1(){

        Assert.assertEquals(persona, pm.getPersona(persona.getNombre()));
    }

    @Test
    public void test2(){
        pm.extraerMuestra(muestra);
        Assert.assertEquals(1,lab1.getMuestraQueue().size());
        pm.processMuestra(lab1, informe);
        Assert.assertEquals(informe, muestra.getInforme());
    }

/*
    @Test
    public void test1(){
        List<Product> orden = pm.getProductByPrize();
        Assert.assertEquals("pan", orden.get(0).getName());
    }
    @Test
    public void test2(){
        //User maria = pm.getUser("Maria");
        //Assert.assertNotNull(maria);
        List<Product> orden = pm.getProductBySales();
        Assert.assertEquals("coca", orden.get(0).getName());
    }
    @Test
    public void test3() {
        Order o4 = pm.processOrder();
        Assert.assertEquals(o1.getProductNames(), o4.getProductNames());
    }
    @Test
    public void test4(){
        pm.processOrder();
        pm.processOrder();
        pm.processOrder();
        List<Product> orden = pm.getProductBySales();
        Assert.assertEquals("pan",orden.get(1).getName());
    }
    @Test
    public void test5(){
        pm.processOrder();
        Order o5 = pm.processOrder();
        pm.processOrder();
        List<Order> order = pm.getOrdersByUser("Juan");
        Assert.assertEquals(order.get(0).getProductNames(),o5.getProductNames());
        Assert.assertEquals(2,order.size());
    }

 */
}
