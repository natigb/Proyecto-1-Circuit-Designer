package adapter;

public class OriginalGameCubeController implements GameCubeController {
    private boolean conectado;

    @Override
    public void conectarConGameCubeport() {
        conectado = true;
        System.out.println("Conectado con GameCubePort");
    }

    @Override
    public void jugar() {
        if (conectado){
            System.out.println("Jugando");
        }else{
            System.out.println("El control no se encuetra conectado");
        }
    }
}
