package adapter;

public class AdaptadorGameCubeToUSB implements USBController {
    private final OriginalGameCubeController gameCubeController;

    public AdaptadorGameCubeToUSB (OriginalGameCubeController gameCubeController){
        this.gameCubeController = gameCubeController;
    }

    @Override
    public void conectarConUSB() {
        System.out.println("Conectado con USB");
        gameCubeController.conectarConGameCubeport();

    }

    @Override
    public void jugar() {
        gameCubeController.jugar();

    }
}
