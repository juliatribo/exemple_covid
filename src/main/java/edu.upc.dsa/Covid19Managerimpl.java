package edu.upc.dsa;

import edu.upc.dsa.Classes.*;
import org.apache.log4j.Logger;

import java.util.*;

public class Covid19Managerimpl implements Covid19Manager {

    /*
    private Queue<Order> pendingOrder = new LinkedList<>();
    private List<Product> listProduct;
    private HashMap<String, User > hmUsers;

     */

    private ArrayList<Laboratorio> listLab;
    private HashMap<String, Persona > hmPersonas;

    final static Logger logger = Logger.getLogger(Covid19Managerimpl.class);
    private boolean dirty=false;

    private static Covid19Manager instance;

   private Covid19Managerimpl() {
       listLab = new ArrayList<>();
       hmPersonas = new HashMap<String,Persona>();
   }
    /*
   public void addProduct(Product p){
       logger.info("new Product " + p.getName());
       listProduct.add(p);
       logger.info("new Product added");
   }

   public void addUser(User user){
       logger.info("new user " + user.getId());
       hmUsers.put(user.getId(),user);
       logger.info("new user added");
   }

     */

    @Override
    public void dirty() {
        this.dirty = true;
    }

    public boolean isDirty(){
       return dirty;
    }

    @Override
    public void newPersona(Persona p) {
        logger.info("newPersona()"+p.getNombre()+" "+p.getApellido());
        hmPersonas.put(p.getNombre(),p);
        logger.info("persona added");
    }

    @Override
    public void extraerMuestra(Muestra muestra) {
        logger.info("extraerMuestra(Muestra muestra, Laboratorio l)");
        boolean labExists = false;
        for(int i = 0; i < listLab.size();i++)
        {
            if (muestra.getIdLab().equals(listLab.get(i).getId())){
                labExists = true;
                Persona persona = hmPersonas.get(muestra.getNombrePersona());
                persona.addMuestra(muestra.getId());
                listLab.get(i).sendMuestra(muestra);
                if (listLab.get(i).getMuestraQueue().size() == 0)
                {
                    logger.warn("queue empty: the aren't muestras");
                }
                else
                    logger.info("muestra añadida al lab " + listLab.get(i).getName());

            }

        }
        if (!labExists){
            logger.warn("this lab doesn't exist");
        }



    }

    @Override
    public void processMuestra(Laboratorio l,Informe informe) {
        logger.info("processMuestra()");
        boolean labExists = false;
        for(int i = 0; i < listLab.size();i++)
        {
            if (l == listLab.get(i)){
                labExists = true;
                if (listLab.get(i).getMuestraQueue().size() == 0)
                {
                    logger.warn("queue empty: the aren't muestras in the lab " +listLab.get(i).getName() );
                }
                Muestra muestra = listLab.get(i).removeMuestra();
                logger.info("a muestra has been processed" );
                muestra.setInforme(informe);
                logger.info("a muestra has an informe" );
            }

        }
        if (!labExists){
            logger.warn("this lab doesn't exist");
        }
    }

    @Override
    public List<String> getMuestrasByUser(String nombrePersona) {
        logger.info("getMuestrasByUser(String userId)");
        return hmPersonas.get(nombrePersona).getMuestrasPersona();
    }

    public void clear(){

       listLab.clear();
       hmPersonas.clear();

   }

    public void addLab(Laboratorio l){
        listLab.add(l);
    }

    public static Covid19Manager getInstance() {
        if (instance==null)
        {
            instance = new Covid19Managerimpl();
        }

        return instance;
    }

    public Persona getPersona(String personaId) {
        return hmPersonas.get(personaId);
    }

    public void setHmPersonas(HashMap<String, Persona> hmPersonas) {
        this.hmPersonas = hmPersonas;
    }




    /*



    @Override
    public User getUser(String userId) {
        return hmUsers.get(userId);
    }

    public List<Product> getListProduct(){return listProduct;}

    @Override
    public List<Product> getProductByPrize() {
        List<Product> p = listProduct;
        /*
        int cont = 0;
        Product product = new Product(" ",0);
        for (int i = 0; i < p.size()-1; i++){
            for (int j = i+1; j <p.size(); j++){
                if (p.get(i).getPrice()>p.get(j).getPrice()) {
                    product = p.get(i);
                    p.set(i,p.get(j));
                    p.set(j, product);
                }
            }
        }



        logger.info("getProductbyPrize()");
        Collections.sort(p, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
               // return (int)(o2.getPrice()-o1.getPrice());
                return Float.compare(o1.getPrice(),o2.getPrice());
            }
        });
        logger.info("the first product is: " + p.get(0).getName());
        return p;
    }
    @Override
    public List<Order> getOrdersByUser(String userId) {
        logger.info("getOrdersbyUser()");
        if (hmUsers.get(userId)==null)
        {
            logger.warn("user"+ userId + "not found ");
        }
        else if(hmUsers.get(userId).getListOrdersDone()==null){
            logger.warn("list empty: the user don't have made any order");
        }
        else if (hmUsers.get(userId).getListOrdersDone()!=null){
            logger.info("the first order is from: "+ hmUsers.get(userId).getListOrdersDone().get(0).getUserName());
        }
        else
            logger.warn("Ninguna de las opciones");

        return hmUsers.get(userId).getListOrdersDone();

    }

    @Override
    public void newOrder(Order o) {
        logger.info("newOrder()");
        User user = hmUsers.get(o.getUserName());
        //user.addOrder(o);
        pendingOrder.add(o);
        cont++;
        logger.info("order added");
    }
    @Override
    public Order processOrder() {
        logger.info("processOrder()");
        Order o = pendingOrder.remove();
        logger.info("an order has been processed" );
        User user = hmUsers.get(o.getUserName());
        user.addOrderDone(o);
        logger.info("the order has been added to " + o.getUserName() + " order list" );
        List<String> p = o.getProductNames();
        for (int i = 0 ; i < p.size(); i++){
            for (int j = 0 ; j < listProduct.size(); j++){
                if (p.get(i).equals(listProduct.get(j).getName())) {
                    listProduct.get(j).addSale();
                    logger.info("new " + listProduct.get(j).getName() + " added to sales list");
                }
            }
        }
        return o;
    }
    @Override
    public List<Product> getProductBySales() {
        List<Product> p = listProduct;
        logger.info("getProductBySale()");

        /*
        int cont = 0;
        Product product = new Product(" ",0);
        for (int i = 0; i < p.size()-1; i++){
            for (int j = i+1; j <p.size(); j++){
                if (p.get(i).getSales()<p.get(j).getSales()) {
                    product = p.get(i);
                    p.set(i,p.get(j));
                    p.set(j, product);
                }
            }
        }



        return p;


        Collections.sort(p, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getSales()-o1.getSales();
            }
        });
        logger.info("the first product is: " + p.get(0).getName());
        return p;
    }

     */

}
