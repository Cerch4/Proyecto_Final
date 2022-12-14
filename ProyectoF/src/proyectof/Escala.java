package proyectof;
/**Clase Escala Singleton-Proxy que sirve como almacenamiento y distribucion del a Varible escala a Todas las demas clases*/
public class Escala {
        private static Escala instancia = new Escala();
        private Escala(){}
        /**int para almacenar la escala que s e utilizara por todas las clases*/
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

