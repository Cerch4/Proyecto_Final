/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectof;
public class Escala {
        private static Escala instancia = new Escala();
        private Escala(){}
        private static int escala;
        public static Escala getInstancia(){
            return instancia;
        }
        public static int getescala(){
            return escala;
        }
        public static void setescala(int scale){
            escala = scale;
        }
}

