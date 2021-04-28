package edu.upc.dsa.services;


import edu.upc.dsa.Classes.*;
import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19Managerimpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Api(value = "/covid", description = "Endpoint to Covid Service")
@Path("/covid")
public class OrdersService {

    private Covid19Manager pm;

    public OrdersService() {

        this.pm = Covid19Managerimpl.getInstance();
        if (!this.pm.isDirty() ) {

            Persona persona1 = new Persona("1","Julia","Tribo",22, "A");
            Persona persona2 = new Persona("2","Juan","sja",22, "A");

            pm.newPersona(persona1);
            pm.newPersona(persona2);

            Laboratorio lab1 = new Laboratorio("lab1");
            Laboratorio lab2 = new Laboratorio("lab2");
            pm.addLab(lab1);
            pm.addLab(lab2);

            pm.dirty();
        }


    }

    @POST
    @ApiOperation(value = "create a new person", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Persona.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/person")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPerson(Persona persona) {
        if (persona.getId()==null)  return Response.status(500).entity(persona).build();
        this.pm.newPersona(persona);
        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "create a new muestra", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Muestra.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/muestra")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response extractMuestra(Muestra muestra) {
        if (muestra.getId()==null)  return Response.status(500).entity(muestra).build();
        this.pm.extraerMuestra(muestra);
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "Get muestras by Persona", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Persona.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMuestrasByUser(@PathParam("Nombre persona") String nombrePersona) {

        List<String> listMuestras = this.pm.getMuestrasByUser(nombrePersona);

        GenericEntity<List<String>> entity = new GenericEntity<List<String>>(listMuestras) {};
        return Response.status(201).entity(entity).build();

    }


/*
    @GET
    @ApiOperation(value = "Get muestras by Persona", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Persona.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMuestrasByUser(@PathParam("Persona id") String userID) {

        List<Muestra> listMuestras = this.pm.getMuestrasByUser(userID);

        GenericEntity<List<Muestra>> entity = new GenericEntity<List<Muestra>>(listMuestras) {};
        return Response.status(201).entity(entity).build();

    }

    @GET
    @ApiOperation(value = "get products by sales", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/sales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsSales() {

        List<Product> productList = this.pm.getProductBySales();

        GenericEntity<List<Product>> entity2 = new GenericEntity<List<Product>>(productList) {};
        return Response.status(201).entity(entity2).build();

    }

    @DELETE
    @ApiOperation(value = "process order", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "No orders to process!!")
    })
    @Path("/")
    public Response ProcessOrder() {
        Order o = this.pm.processOrder();
        if (o == null) return Response.status(404).build();
        else return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "get orders by user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Order.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/user/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderByUser(@PathParam("name") String id) {
        List<Order> listOrder = pm.getOrdersByUser(id);

        if (listOrder == null) return Response.status(404).build();
        else {
            GenericEntity<List<Order>> entity = new GenericEntity<List<Order>>(listOrder) {};
            return Response.status(201).entity(entity).build();
        }
    }


    @POST
    @ApiOperation(value = "create a new order", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Order.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newOrder(Order o) {
        if (o.getUserName()==null)  return Response.status(500).entity(o).build();
        this.pm.newOrder(o);
        return Response.status(201).build();
    }

 */


}