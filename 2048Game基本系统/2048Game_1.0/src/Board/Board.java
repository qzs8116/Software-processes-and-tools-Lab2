package Board;

public class Board {

    private Position[][] board_2048 = new Position[4][4];   //游戏区域

    public Board(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                board_2048[i][j] = new Position(i, j);
            }
        }
    }

    /**
     * 得到区域相应位置
     * @param x
     * @param y
     * @return 相应位置信息
     */
    public Position getPosition(int x, int y){
        return board_2048[x][y];
    }

}
