package Square;

/**
 * 2048中每个方块的类，记录方块上的值
 */
public class Square {

    private int num;
    private int flag;

    public Square(int aNum){
        num = aNum;
        flag = 0;
    }

    /**
     * 得到方块数字
     * @return  数字
     */
    public int getNum(){
        return num;
    }

    /**
     * 得到方块标志位
     * @return 标志位
     */
    public int getFlag(){
        return flag;
    }

    /**
     * 方块的数值变化
     */
    public void squareChange(){
        num = num * 2;
        setFlag();
    }

    /**
     * 设置标志位
     */
    public void setFlag(){
        flag = 1;
    }

    /**
     * 标志位清零
     */
    public void cleanFlag(){
        flag = 0;
    }

}
