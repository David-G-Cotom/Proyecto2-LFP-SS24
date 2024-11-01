/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parser;

public abstract class AnalizadorSintactico {
    protected Data data;

    public AnalizadorSintactico(Data data) {
        this.data = data;
    }

    public abstract void analyze() ;

    protected void errorStatus(String descripcion) {
        data.addSyntaxError(descripcion);
    }

    public Data getData(){
        return data;
    }
}
