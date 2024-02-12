public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            return;
        }
        Galton_board gb = new Galton_board(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        gb.startGaltonBoard();
    }
}
