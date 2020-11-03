package Start;

import Game.Game;
import UI.GameUI;

public class Control {
    private final Game game;
    private final GameUI gu;
    private boolean t = true;

    public Control(){
        game = new Game();
        gu = new GameUI(4, this);
    }

    /**
     * 运行
     */
    public void run() {
        gu.showButton();
        game.refreshSquare();
        gu.changeButton(game.getBoard());
    }


    /**
     * 上移
     */
    public void upControl(){
        t = game.upSquare();
        if(t)
            game.refreshSquare();
        gu.changeButton(game.getBoard());
        if(game.checkGameOver()){
            gu.showMessage("Game Over");
            System.exit(0);
        }
    }

    /**
     * 下移
     */
    public void downControl(){
        t = game.downSquare();
        if(t)
            game.refreshSquare();
        gu.changeButton(game.getBoard());
        if(game.checkGameOver()){
            gu.showMessage("Game Over");
            System.exit(0);
        }
    }

    /**
     * 左移
     */
    public void lfetControl(){
        t = game.leftSquare();
        if(t)
            game.refreshSquare();
        gu.changeButton(game.getBoard());
        if(game.checkGameOver()){
            gu.showMessage("Game Over");
            System.exit(0);
        }
    }

    /**
     * 右移
     */
    public void rightControl(){
        t = game.rightSquare();
        if(t)
            game.refreshSquare();
        gu.changeButton(game.getBoard());
        if(game.checkGameOver()){
            gu.showMessage("Game Over");
            System.exit(0);
        }
    }

}
