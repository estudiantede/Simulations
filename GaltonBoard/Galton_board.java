import java.util.ArrayList;

public class Galton_board {
    int size;
    int nBall;
    int[] num;
    Balls ball;

    public Galton_board(int size, int nBall) {
        this.size = size * 2 + 1;
        this.num = new int[this.size];

        for(int i = 0; i < this.size; i++) {
            this.num[i] = 0;
        }
        this.nBall = nBall;
        ball = new Balls();
    }

    public void startGaltonBoard() {
        for(int i = 0; i < this.nBall; i++) {
            //ball.moverNVeces(this.size / 2);
            int n = ball.moverNVeces(this.size / 2 - 1);

            this.num[n + this.size / 2] += 1;
            ball.restartPos();
        }
        ArrayList<Integer> array = groupArray(this.num);
        this.showBoard(array);
    }

    public ArrayList<Integer> groupArray(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int j : array) {
            if (j != 0) {
                arrayList.add(j);
            }
        }
        return arrayList;
    }

    private void showBoard(ArrayList<Integer> arrayList) {
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
    }
}
