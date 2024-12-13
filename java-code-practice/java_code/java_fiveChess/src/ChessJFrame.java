/**
 * @author 刘浩彬
 * @date 2023/5/28
 */
import com.sun.jmx.snmp.SnmpUnknownAccContrModelException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.multi.MultiButtonUI;

public class ChessJFrame extends JFrame{
    // 声明一条棋盘对象
    private ChessBord chessBord;
    // 声明一个面板对象
    private Panel tool;
    // 声明开始按钮
    private Button StartButton;
    // 声明悔棋按钮
    private Button BackButton;
    // 声明退出按钮
    private Button exitButton;

    public ChessJFrame(){
        //设置标题
        setTitle("乞丐版五子棋");
        //按钮事件处理对象
        MyButtonLister mb = new MyButtonLister();
        //面板对象
        tool = new Panel();
        //棋盘对象
        chessBord = new ChessBord();
        //设置开始按钮
        StartButton = new Button("开始");
        //设置悔棋按钮
        BackButton = new Button("悔棋");
        //设置退出按钮
        exitButton = new Button("退出");
        //流式布局
        tool.setLayout(new FlowLayout(FlowLayout.CENTER));
        //置放三个按钮
        tool.add(StartButton);
        tool.add(BackButton);
        tool.add(exitButton);
        //监听三个按钮
        StartButton.addActionListener(mb);
        BackButton.addActionListener(mb);
        exitButton.addActionListener(mb);
        //设置按钮位置
        add(tool,BorderLayout.SOUTH);
        //添加棋盘对象
        add(chessBord);
        //设置关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //自适应
        pack();
    }

    private class MyButtonLister implements ActionListener{
        @Override
        //按钮处理事件类
        public void actionPerformed(ActionEvent e){
            //TODO Auto-generated method stub
            //获取事件源头
            Object obj = e.getSource();

            if(obj == StartButton){
                System.out.println("重新开始");
                chessBord.restartGame();
            }
            else if(obj == BackButton){
                System.out.println("悔棋");
                chessBord.goback();
            }
            else if(obj == exitButton){
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        //声明框架
        ChessJFrame jf = new ChessJFrame();
        //居中显示
        jf.setLocationRelativeTo(null);
        //可见
        jf.setVisible(true);
    }
}
