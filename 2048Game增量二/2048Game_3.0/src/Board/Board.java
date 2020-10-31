package Board;

public class Board {

    private Position[][] board_2048;
    private static int num_max = 128;
    private static int coin = 5;
    private static int dimensions;

    public Board(){
        board_2048 = new Position[dimensions][dimensions];
        init_position(dimensions);
    }

    public static void setDimensions(int num){
        dimensions = num;
    }

    public void setNum_max(int num){
        num_max = num;
    }

    public void setCoin(int num){
        coin = num;
    }

    public int getDimensions(){
        return dimensions;
    }

    public int getNum_max(){
        return num_max;
    }

    public int getCoin(){
        return coin;
    }

    public void init(){
        num_max = 128;
        coin = 5;
    }

    public void init_position(int num){
        for (int i = 0; i < num; i++){
            for (int j = 0; j < num; j++){
                board_2048[i][j] = new Position(i, j);
            }
        }
    }

    public Position getPosition(int x, int y){
        return board_2048[x][y];
    }

}
