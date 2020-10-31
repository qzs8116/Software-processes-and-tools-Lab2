package Start;

import Game.Game;
import GoldCoin.Goldcoin;
import Score.Score;
import UI.GameUI;

public class Control {
    private final Game game;
    private final Score score;
    private final Goldcoin goldCoin;
    private final GameUI gu;
    private static int dimensions;
    private boolean t = true;

    public Control(){
        game = new Game(dimensions);
        score = new Score();
        goldCoin = new Goldcoin();
        gu = new GameUI(dimensions,this);
    }

    public Control(Game game, Score score, Goldcoin goldCoin){
        this.game = game;
        this.score = score;
        this.goldCoin = goldCoin;
        gu = new GameUI(dimensions, this);
    }

    public GameUI getGu(){
        return gu;
    }

    public int getDimensions(){
        return dimensions;
    }

    public Game getGame(){
        return game;
    }

    public void run() {
        gu.showButton(score.getSco(), goldCoin.getNum(), score.getScore_max());
        game.refreshSquare();
        gu.changeButton(game.getBoard());
    }

    public void upControl(){
        t = game.upSquare();
        runStep();
    }

    public void downControl(){
        t = game.downSquare();
        runStep();
    }

    public void lfetControl(){
        t = game.leftSquare();
        runStep();
    }

    public void rightControl(){
        t = game.rightSquare();
        runStep();
    }

    public void runStep(){
        if(score.getSco() > score.getScore_max()){
            score.setScore_max(score.getSco());
            gu.changMaxScore(score.getScore_max());
            gu.changMaxScore(score.getSco());
        }
        gu.changScore(score.getSco());
        if(goldCoin.getPer_num() != goldCoin.getNum()){
            gu.Prompt("获得金币：" + (goldCoin.getNum()-goldCoin.getPer_num()));
            goldCoin.setPer_num(goldCoin.getNum());
            gu.changCoin(goldCoin.getNum());
        }
        if(t)
            game.refreshSquare();
        gu.changeButton(game.getBoard());
        if(game.checkGameOver()){
            gu.showMessage("Game Over");
        }
    }

    public void restart(){
        game.getBoard().init();
        game.getBoard().init_position(dimensions);
        score.init_Score();
        Control rc = new Control(game, score, goldCoin);
        rc.run();
    }

    public int removeSquare(int num){
        int flag = 0;
        if(goldCoin.getNum() < 10*num)
            return 1;
        for(int i = 0; i < dimensions; i ++){
            for(int j = 0; j < dimensions; j++){
                if(game.getBoard().getPosition(i, j).getSquare() != null){
                    if(game.getBoard().getPosition(i, j).getSquare().getNum() == num){
                        game.getBoard().getPosition(i, j).removeSquare();
                        flag++;
                    }
                }
            }
        }
        if(flag == 0)
            return 0;
        goldCoin.minusNum(10*num);
        goldCoin.setPer_num(goldCoin.getNum());
        gu.changCoin(goldCoin.getNum());
        gu.changeButton(game.getBoard());
        return 2;
    }

    public static void setDimensions(int num){
        dimensions = num;
    }

}
