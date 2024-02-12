public class Balls {
    private int pos;

    public Balls() {
        this.pos = 0;
    }

    public int moverNVeces(int n) {
        for (int i = 0; i < n; i++) {
            this.fifty();
        }
        return pos;
    }

    private void fifty() {
        //System.out.println(getRandomNumber(0, 2));
        if(getRandomNumber(0, 2) == 0) {
            pos = pos - 1;
        } else {
            pos = pos + 1;
        }
    }

    public void restartPos() {
        pos = 0;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
