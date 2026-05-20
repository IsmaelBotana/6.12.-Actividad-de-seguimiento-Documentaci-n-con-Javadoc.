/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut6asdocumentacion;

/**
 * @version 1.0
 * @author alumno
 */
public class Producto {
  private String nombre;
  private double precio;
  private int stock;

  public Producto(String nombre, double precio, int stock) {
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
  }

  public String getNombre() {
    return nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public int getStock() {
    return stock;
  }
  
  
  public boolean hayStock(int cantidad){ 
    return this.stock > cantidad;
  }
  
  public boolean venderUnidad(int unidad){
    boolean seVende = false;
    if (hayStock(unidad)) {
      this.stock -= unidad;
      seVende = true;
    }
    return seVende;
  }
  /**
   * El IVA está al 21% por lo que el calculo es precio * 1.21
   * @param unidad
   * @return 
   */
  public double calcularPrecioConIVA(int unidad){
    double precioIVA = -1;
    if (hayStock(unidad)) {
      precioIVA = (this.precio * unidad) * 1.21;
    }
    return precioIVA;
  }
}
