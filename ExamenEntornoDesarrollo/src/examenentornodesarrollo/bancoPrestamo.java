/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenentornodesarrollo;

/**
 *
 * @author Fran
 */
public class bancoPrestamo {
    private int capital;
    private int anios;
    private double interes;

    public bancoPrestamo(int capital, int anios, double interes) {
        this.capital = capital;
        this.anios = anios;
        this.interes = interes;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }
    
    
    
}
