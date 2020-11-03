package Game;

import Action.Action;
import Board.*;
import Square.Square;

import java.util.Random;

public class Game {

    private Board board;
    private Action action;
    private int dimensions;

    public Game(int num){
        Board.setDimensions(num);
        board = new Board();
        action = new Action();
        dimensions = num;
    }

    public int getDimensions(){
        return dimensions;
    }

    public Board getBoard() {
        return board;
    }

    /**
     * 将所有方块都向上移动
     */
    public boolean upSquare(){
        flagClearZero();
        int count = 0;
        for (int i = 0; i < dimensions; i++){
            for(int j = dimensions-2; j >= 0; j--){
                for(int k = 1; k <= dimensions-1-j; k++){
                    if(board.getPosition(i, j+k).getSquare() != null){
                        if(!action.moveSquare(board.getPosition(i, j), board.getPosition(i, j+k))) {
                            if (k - 1 != 0) {
                                if (action.moveSquare(board.getPosition(i, j), board.getPosition(i, j + k - 1))) {
                                    count++;
                                }
                            }
                        }
                        else{
                            count++;
                        }
                        break;
                    }
                    else {
                        if(k == dimensions-1-j)
                            if(action.moveSquare(board.getPosition(i, j), board.getPosition(i, j+k)))
                                count++;
                    }
                }
            }
        }
        return count != 0;
    }

    /**
     * 将所有方块都向下移动
     */
    public boolean downSquare(){
        flagClearZero();
        int count = 0;
        for(int i = 0; i < dimensions; i++){
            for(int j = 1; j < dimensions; j++){
                for (int k = 1; k <= j; k++){
                    if(board.getPosition(i, j-k).getSquare() != null) {
                        if(!action.moveSquare(board.getPosition(i, j), board.getPosition(i, j-k))) {
                            if (k - 1 != 0) {
                                if (action.moveSquare(board.getPosition(i, j), board.getPosition(i, j - k + 1))) {
                                    count++;
                                }
                            }
                        }
                        else {
                            count++;
                        }
                        break;
                    }
                    else {
                        if(k == j)
                            if(action.moveSquare(board.getPosition(i, j), board.getPosition(i, j-k)))
                                count++;
                    }
                }
            }
        }
        return count != 0;
    }

    /**
     * 将所有方块都向左移动
     */
    public boolean leftSquare(){
        flagClearZero();
        int count = 0;
        for(int j = 0; j < dimensions; j++){
            for(int i = 1; i < dimensions; i++){
                for(int k = 1; k <= i; k++) {
                    if(board.getPosition(i-k, j).getSquare() != null) {
                        if(!action.moveSquare(board.getPosition(i, j), board.getPosition(i-k, j))) {
                            if (k - 1 != 0) {
                                if(action.moveSquare(board.getPosition(i, j), board.getPosition(i - k + 1, j))){
                                    count++;
                                }
                            }
                        }
                        else {
                            count++;
                        }
                        break;
                    }
                    else {
                        if(k == i)
                            if(action.moveSquare(board.getPosition(i, j), board.getPosition(i-k, j)))
                                count++;
                    }
                }
            }
        }
        return count != 0;
    }

    /**
     * 将所有方块都向右移动
     */
    public boolean rightSquare(){
        flagClearZero();
        int count = 0;
        for(int j = 0; j < dimensions; j++){
            for(int i = dimensions-2; i >= 0; i--){
                for(int k = 1; k <= dimensions-1-i; k++) {
                    if(board.getPosition(i+k, j).getSquare() != null){
                        if(!action.moveSquare(board.getPosition(i, j), board.getPosition(i+k, j))) {
                            if (k - 1 != 0) {
                                if(action.moveSquare(board.getPosition(i, j), board.getPosition(i + k - 1, j))){
                                    count++;
                                }
                            }
                        }
                        else {
                            count++;
                        }
                        break;
                    }
                    else {
                        if(k == dimensions-1-i)
                            if(action.moveSquare(board.getPosition(i, j), board.getPosition(i+k, j)))
                                count++;
                    }

                }
            }
        }
        return count != 0;
    }

    public void refreshSquare(){
        int num = 0;
        Random rand = new Random();
        int temp = rand.nextInt(95)%6;
        if(temp == 0){
            num = 4;
        }
        else{
            num = 2;
        }
        Square square = new Square(num);
        while(true){
            int row = rand.nextInt(99)%dimensions;
            int col = rand.nextInt(99)%dimensions;
            if(board.getPosition(row, col).getSquare() == null){
                board.getPosition(row, col).setSquare(square);
                break;
            }
        }
    }

    public boolean checkGameOver(){
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                if(board.getPosition(i ,j).getSquare() == null)
                    return false;
            }
        }
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                if(checkAroundSquareSame(board.getPosition(i, j)))
                    return false;
            }
        }
        return true;
    }

    public void flagClearZero(){
        for (int i = 0; i < dimensions; i++){
            for (int j = 0; j < dimensions; j++){
                if(board.getPosition(i, j).getSquare() != null){
                    board.getPosition(i, j).getSquare().cleanFlag();
                }
            }
        }
    }

    public boolean checkAroundSquareSame(Position position){
        int x = position.getX();
        int y = position.getY();
        int num = position.getSquare().getNum();
        if(x == 0){
            if(y == 0){
                if (num == board.getPosition(x, y+1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x+1, y).getSquare().getNum())
                    return true;
            }
            else if (y == dimensions-1){
                if (num == board.getPosition(x, y-1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x+1, y).getSquare().getNum())
                    return true;
            }
            else {
                if (num == board.getPosition(x, y+1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x, y-1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x+1, y).getSquare().getNum())
                    return true;
            }
        }
        else if (x == dimensions-1){
            if(y == 0){
                if (num == board.getPosition(x, y+1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x-1, y).getSquare().getNum())
                    return true;
            }
            else if (y == dimensions-1){
                if (num == board.getPosition(x, y-1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x-1, y).getSquare().getNum())
                    return true;
            }
            else {
                if (num == board.getPosition(x, y+1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x, y-1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x-1, y).getSquare().getNum())
                    return true;
            }
        }
        else {
            if (y == 0){
                if (num == board.getPosition(x, y+1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x-1, y).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x+1, y).getSquare().getNum())
                    return true;
            }
            else if (y == dimensions-1){
                if (num == board.getPosition(x, y-1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x+1, y).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x-1, y).getSquare().getNum())
                    return true;
            }
            else {
                if (num == board.getPosition(x, y+1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x, y-1).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x+1, y).getSquare().getNum())
                    return true;
                if (num == board.getPosition(x-1, y).getSquare().getNum())
                    return true;
            }
        }
        return false;
    }

}
