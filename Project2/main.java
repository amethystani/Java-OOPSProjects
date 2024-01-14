 interface Game {
    String startGame();
    String processKey(char key);
}

class FlightSimple implements Game {
    private int speed = 0;
    private int altitude = 0;

    public String startGame() {
        speed = 0;
        altitude = 0;
        return "FlightSimple game started";
    }

    public String processKey(char key) {
        switch (key) {
            case 'R':
                speed++;
                break;
            case 'L':
                if (--speed < 0)
                    return "Lost";
                break;
            case 'U':
                if (speed > 2)
                    altitude++;
                break;
            case 'D':
                if (--altitude < 0)
                    return "Lost";
                break;
        }
        if (altitude == 0 && speed == 0)
            return "Won";
        else
            return "In progress";
    }
}

class RandomWalk implements Game {
    private int positionX = 10;
    private int positionY = 10;

    public String startGame() {
        positionX = 10;
        positionY = 10;
        return "RandomWalk game started";
    }

    public String processKey(char key) {
        switch (key) {
            case 'R':
                if (++positionX > 19)
                    return "Lost";
                break;
            case 'L':
                if (positionX == 0) {
                    // Don't decrement positionX if we're at the left limit.
                } else {
                    positionX--;
                }
                break;
            case 'U':
                if (++positionY > 19)
                    return "Lost";
                break;
            case 'D':
                if (--positionY < 0)
                    return "Won";
                break;
        }
        return "In progress";
    }
}
import java.util.Scanner;//this is working perfectly fine on IDES giving error on gdb pls check on an ide 

public class Main {
    public static void main(String[] args) {
        FlightSimple flightSimple = new FlightSimple();
        RandomWalk randomWalk = new RandomWalk();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String gameName = scanner.next();

            if (gameName.equals("End")) {
                break;
            }

            int maxKeystrokes = scanner.nextInt();

            Game currentGame;

            if (gameName.equals("FlightSimple")) {
                currentGame = flightSimple;
            } else if (gameName.equals("RandomWalk")) {
                currentGame = randomWalk;
            } else {
                continue;
            }

            System.out.println(currentGame.startGame());

            String result = "";

            for (int i = 0; i < maxKeystrokes; i++) {
                char key = scanner.next().charAt(0);

                result = currentGame.processKey(key);

                if (!result.equals("In progress")) {
                    System.out.println(gameName + ": " + result);
                    break;
                }
            }

            if (result.equals("In progress")) {
                System.out.println(gameName + ": Game Over");
            }
        }

        scanner.close();
    }
}
