package main;

public class MineSweeper {
    public void intermediate() {
        Utils utils = new Utils();
        try {
            utils.setup();
            utils.play();
        } finally {
            utils.teardown();
        }
    }
}
