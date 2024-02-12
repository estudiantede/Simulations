public class Stats {
    int trials;
    boolean[] result;
    float posibility;

    public Stats(int trials) {
        this.trials = trials;
        this.result = new boolean[trials];
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            System.out.println("Se muestra esto");
            return true;
        } catch(NumberFormatException e){
            System.out.println("Se muestra esto");
            return false;
        }
    }
    public void runSimulations() {
        for(int i = 0; i < this.trials; i++) {
            Simulations simulacion = new Simulations();
            result[i] = simulacion.startSimulation();
        }
    }

    public void getMean() {
        float cant_true = 0;
        for(int i = 0; i < this.trials; i++) {
            if (result[i]) {
                cant_true += 1;
                //System.out.println("Es true");
            } else {
                //System.out.println("Es false");
            }
        }
        this.posibility = cant_true / this.trials;
    }

    public void showResults() {
        System.out.print("El resultado de la posibilidad en el caso de " + this.trials + " es de " + this.posibility);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Number of args incorrect. It must have 1 argument, the number of simulation to run");
            return;
        }
        System.out.println(Stats.isNumeric(args[0]));
        if (!Stats.isNumeric(args[0])) {
            return;
        } else {
            Stats stadistics = new Stats(Integer.parseInt(args[0]));
            stadistics.runSimulations();
            stadistics.getMean();
            stadistics.showResults();
        }



    }


}
