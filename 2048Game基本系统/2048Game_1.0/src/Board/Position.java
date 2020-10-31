package Board;

import Square.Square;

public class Position {

    private final int x;    //横坐标
    private final int y;    //纵坐标
    private Square square;  //方块信息

    public Position(int aX, int aY){
        x = aX;
        y = aY;
    }

    /**
     * 设置方块
     * @param aSquare 方块信息
     */
    public void setSquare(Square aSquare){
        square = aSquare;
    }

    /**
     * 得到横坐
     * @return  x
     */
    public int getX(){
        return x;
    }

    /**
     * 得到纵坐标
     * @return  y
     */
    public int getY(){
        return y;
    }

    /**
     * 得到方块信息
     * @return  方块信息
     */
    public Square getSquare(){
        return square;
    }

    /**
     * 删除方块
     */
    public void removeSquare(){
        square = null;
    }

}
