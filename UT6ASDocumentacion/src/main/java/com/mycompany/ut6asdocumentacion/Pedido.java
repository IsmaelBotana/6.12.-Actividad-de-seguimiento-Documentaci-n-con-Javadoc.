/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut6asdocumentacion;

/**
 * @version 1.0
 * @author alumno
 */
public class Pedido {
  /**
   * Cliente = el nombre del cliente
   * Carrito = un array de productos que el cliente quiere comprar
   * CantidadProducto = array que cada posición hace referencia a Carrito, sobre la cantidad que se desea comprar
   * MAX_PRODUCTOS = maxima de productos distintos que se puede añadir al carrito
   * numProductos = numero de productos distintos que se han metido al Carrito
   */
  private final int MAX_PRODUCTOS = 20;
  private String cliente;
  private Producto[] carrito;
  private int[] cantidadProductos; 
  private int numProductos;

  /**
   * Constructor de la clase Pedido, donde se inicializan
   * los atributos de un nuevo atributo de la clase Pedido
   * @param cliente Se debe introducir el nombre del cliente
   */
  public Pedido(String cliente) {
    this.cliente = cliente;
    this.carrito = new Producto[MAX_PRODUCTOS];
    this.cantidadProductos = new int[MAX_PRODUCTOS];
  }

  /**
   * Devuelve el nombre del cliente
   * @return String de el nombre del cliente
   */
  public String getCliente() {
    return cliente;
  }

  /**
   * Devuelve la cantidad de productos en el carrito
   * @return int la suma de la cantidad de cada producto en el carrito
   */
  public int getCantidadProductos() {
    int cantidadDevuelve = 0;
    for (int i = 0; i < numProductos; i++) {
      cantidadDevuelve += cantidadProductos[i];
    }
    return cantidadDevuelve;
  }

  /**
   * Agrega un producto al carrito junto a su respectiva cantidad,
   * la cantidad agregada se elimina del stock de la tienda
   * (En la clase producto)
   * @param cant Cantidad del producto que se quiere añadir al carrito
   * @param prod Producto que se desea añadir al carrito
   * @return true si se agrega, false si no se agrega
   */
  public boolean agregarProducto(int cant, Producto prod) {
    boolean agregado = false;
    if (prod != null && cant > 0 && prod.hayStock(cant)) {

      for (int i = 0; i < numProductos; i++) {
        if (carrito[i].getNombre().equals(prod.getNombre())) {
          cantidadProductos[i] += cant; 
          prod.venderUnidad(cant);
          agregado = true;
        }
      }
      if (!agregado && numProductos < MAX_PRODUCTOS) {
        carrito[numProductos] = prod;
        cantidadProductos[numProductos++] = cant;
        prod.venderUnidad(cant);
        agregado = true;
      }
    }
    return agregado;
  }
  
  /**
   * calcula el precio de todo lo que hay en el carrito,
   * aplicandole el IVA a cada conjunto de productos
   * @return El sumatorio del sumatorio con IVA con cantidad de producto de los productos en el carrito
   */
  public double calcularTotal(){
    double total = 0;
    for (int i = 0; i < numProductos; i++) {
      total += carrito[i].calcularPrecioConIVA(cantidadProductos[i]);
    }
    return total;
  }

}
