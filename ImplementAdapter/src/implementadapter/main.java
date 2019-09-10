package adapter;

public class main {

    static void jugarConGameCubeController(GameCubeController control) {
        control.conectarConGameCubeport();
        control.jugar();
    }

    static void jugarConUSBController(USBController control) {
        control.conectarConUSB();
        control.jugar();
    }

    public static void main(String[] args) {
        OriginalGameCubeController controlGris = new OriginalGameCubeController();
        ProController proControlNegro = new ProController();

        System.out.println("Jugar en Pc con control USB");
        jugarConUSBController(proControlNegro);

        System.out.println("Jugar en Gamecube con control de Gamecube");
        jugarConGameCubeController(controlGris);

        System.out.println("Jugar en PC con control de Gamecube");
        jugarConUSBController(new AdaptadorGameCubeToUSB(controlGris));

    }

}


