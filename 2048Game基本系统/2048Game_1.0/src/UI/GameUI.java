package UI;

import Board.Board;
import Start.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameUI {
    private Control c;

    private final JFrame frame = new JFrame();
    private final JButton[][] jb;
    private final JButton up = new JButton();
    private final JButton down = new JButton();
    private final JButton left = new JButton();
    private final JButton right = new JButton();

    public GameUI(int num, Control aC){
        jb = new JButton[num][num];
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                jb[i][j] = new JButton();
                jb[i][j].setEnabled(false);
            }
        }
        c = aC;
    }

    /**
     * 显示界面布局
     */
    public void showButton(){
        for (int i = 0; i < jb.length; i++){
            for (int j = 0; j < jb.length; j++){
                jb[i][j].setBounds(100*i, 100*j, 100, 100);
                frame.add(jb[i][j]);
            }
        }

        up.setBounds(170, 425, 60, 60);
        down.setBounds(170, 565, 60, 60);
        left.setBounds(100, 495, 60, 60);
        right.setBounds(240, 495, 60, 60);

        up.setText("上");
        down.setText("下");
        left.setText("左");
        right.setText("右");

        frame.add(up);
        frame.add(down);
        frame.add(left);
        frame.add(right);

        up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.upControl();
            }
        });

        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.downControl();
            }
        });

        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.lfetControl();
            }
        });

        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.rightControl();
            }
        });

        frame.setSize(400, 680);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });



    }

    /**
     * 游戏结束提示
     * @param message 提示语
     */
    public void showMessage(String message) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel(message);
        JScrollPane scrollPane = new JScrollPane(label);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    /**
     * 更新界面方块颜色和数字
     * @param board
     */
    public void changeButton(Board board){
        for (int i = 0; i <jb.length; i++){
            for (int j = 0; j < jb.length; j++){
                jb[i][j].setText("");
                jb[i][j].setBackground(new Color(246, 213, 133));
                if(board.getPosition(i, jb.length-j-1).getSquare() != null) {
                    switch (board.getPosition(i, jb.length-j-1).getSquare().getNum()){
                        case 2: jb[i][j].setText("2");
                                jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                jb[i][j].setBackground(new Color(246, 241, 241));
                                jb[i][j].setForeground(new Color(9, 1, 1, 248));
                                break;

                        case 4: jb[i][j].setText("4");
                                jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                jb[i][j].setBackground(new Color(243, 194, 8));
                                jb[i][j].setForeground(new Color(12, 0, 0));
                                break;

                        case 8: jb[i][j].setText("8");
                                jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                jb[i][j].setBackground(new Color(245, 153, 5));
                                jb[i][j].setForeground(new Color(255, 254, 254));
                                break;

                        case 16: jb[i][j].setText("16");
                                 jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                 jb[i][j].setBackground(new Color(239, 97, 30));
                                 jb[i][j].setForeground(new Color(255, 254, 254));
                                 break;

                        case 32: jb[i][j].setText("32");
                                 jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                 jb[i][j].setBackground(new Color(252, 3, 3));
                                 jb[i][j].setForeground(new Color(255, 254, 254));
                                 break;

                        case 64: jb[i][j].setText("64");
                                 jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                 jb[i][j].setBackground(new Color(168, 2, 24));
                                 jb[i][j].setForeground(new Color(255, 254, 254));
                                 break;

                        case 128: jb[i][j].setText("128");
                                  jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                  jb[i][j].setBackground(Color.yellow);
                                  jb[i][j].setForeground(new Color(255, 254, 254));
                                  break;

                        case 256: jb[i][j].setText("256");
                                  jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                  jb[i][j].setBackground(new Color(191, 138, 4));
                                  jb[i][j].setForeground(new Color(255, 254, 254));
                                  break;

                        case 512: jb[i][j].setText("512");
                                  jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                  jb[i][j].setBackground(new Color(172, 125, 6));
                                  jb[i][j].setForeground(new Color(255, 254, 254));
                                  break;

                        case 1024: jb[i][j].setText("1024");
                                   jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                   jb[i][j].setBackground(new Color(125, 92, 9));
                                   jb[i][j].setForeground(new Color(255, 254, 254));
                                   break;

                        case 2048: jb[i][j].setText("2048");
                                   jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                   jb[i][j].setBackground(new Color(95, 69, 3));
                                   jb[i][j].setForeground(new Color(255, 254, 254));
                                   break;

                        case 4096: jb[i][j].setText("4096");
                                   jb[i][j].setFont(new Font("宋体", Font.BOLD, 40));
                                   jb[i][j].setBackground(new Color(14, 10, 0));
                                   jb[i][j].setForeground(new Color(255, 254, 254));
                                   break;
                    }
                }
            }
        }
    }

}
