package adapter;

public class ProController implements USBController {
    private boolean conectado;

    @Override
    public void conectarConUSB() {
        conectado = true;
        System.out.println("Conectado con UBS");

    }

    @Override
    public void jugar() {
        if (conectado){
            System.out.println("Jugando");
        }else {
            System.out.println("El control no se encuetra conectado");
        }

    }
}
