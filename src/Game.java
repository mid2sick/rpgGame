package src;

public class Game {
    private boolean running;
    public Window window;
    public Game() {
        window = new Window("Game");
    }

    public void start() {
        new Thread(this::gameLoop).start();
    }

    private void gameLoop() {
        running = true;
        while (running) {
            window.update();
            delay(15);
        }
    }


    private void delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
