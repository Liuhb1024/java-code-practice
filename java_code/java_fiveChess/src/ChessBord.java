/**
 * @author 刘浩彬
 * @date 2023/5/28
 */
/**
 * @author 刘浩彬
 * @date 2023/5/28
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//继承面板类和鼠标事件接口
public class ChessBord extends JPanel implements MouseListener{
    //定义边距
    public static int MARGIN=30;
    //定义行数
    public static int ROWS=15;
    //定义列数
    public static int COLS=15;
    //网格间距
    public static int GRID_SPAN=35;
    //定义一个棋子数组
    Chess[] chessList=new Chess[(ROWS + 1) * (COLS + 1)];
    //声明一个字符串数组，用来判断输赢
    String[][] board=new String[MARGIN*2+GRID_SPAN*COLS][MARGIN*2+GRID_SPAN*COLS];
    //棋子数目
    int chessCount;
    //棋子的坐标索引
    int xindex,yindex;
    //开始默认黑子先下
    boolean start=true;
    //定义是否游戏结束
    boolean GameOver=false;

    //棋盘类构造函数
    public ChessBord() {
        //设置背景颜色
        setBackground(Color.lightGray);
        //将棋盘类添加到鼠标事件监听器
        addMouseListener(this);

        //匿名内部类
        addMouseMotionListener(new MouseMotionListener() {
            //根据鼠标的移动所在的坐标来设置鼠标光标形状
            @Override
            public void mouseMoved(MouseEvent e) {
                //对鼠标光标的x坐标进行转换
                int x1=(e.getX()-MARGIN+GRID_SPAN/2)/GRID_SPAN;
                //对鼠标光标的y坐标进行转换
                int y1=(e.getY()-MARGIN+GRID_SPAN/2)/GRID_SPAN;
                if(x1<0||x1>ROWS||y1<0||y1>COLS||GameOver||findchess(x1, y1)) {
                    //设置鼠标光标为默认形状
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }else {
                    //设置鼠标光标为手型
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }
            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });
        //对board[][]赋初值
        for(int i=0;i<MARGIN*2+GRID_SPAN*COLS;i++) {
            for (int j = 0; j < MARGIN*2+GRID_SPAN*COLS; j++) {
                board[i][j]="0";
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    //鼠标点击事件
    public void mousePressed(MouseEvent e) {
        //游戏结束，不能按
        if(GameOver)
            return ;
        //判断是什么颜色的棋子
        String colorName=start?"黑棋":"白棋";
        //得到棋子x坐标
        xindex=(e.getX()-MARGIN+GRID_SPAN/2)/GRID_SPAN;
        //得到棋子y坐标
        yindex=(e.getY()-MARGIN+GRID_SPAN/2)/GRID_SPAN;
        //以棋子x坐标y坐标做索引将棋子的颜色添加到board中
        board[xindex][yindex]=colorName;
        //棋子在棋盘外不能下，
        if(xindex<0||xindex>ROWS||yindex<0||yindex>COLS) {
            return ;
        }
        //所下位置已有棋子，不能下
        else if(findchess( xindex, yindex)) {
            return ;
        }
        //对棋子对象进行初始化
        Chess po=new Chess(xindex,yindex,start?Color.black:Color.WHITE);
        //将棋子对象添加到棋子数组中
        chessList[chessCount++]=po;
        //重画图型
        repaint();
        //判断是否胜利
        if(win( xindex,yindex,start)) {
            String msg=String.format("恭喜 %s赢了",colorName);
            JOptionPane.showMessageDialog(this, msg);
            //gameOver=true;
            GameOver=true;
        }
        //判断是否全部下满
        else if(chessCount==(COLS+1)*(ROWS+1)) {
            String msg=String.format("恭喜 %s赢了",colorName);
            JOptionPane.showMessageDialog(this, msg);
            GameOver=true;
        }
        //改变棋子先下棋状态
        start=!start;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    //画棋盘和棋子
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //画横线
        for(int i=0;i<=ROWS;i++) {
            g.drawLine(MARGIN, MARGIN+i*GRID_SPAN,
                    MARGIN+COLS*GRID_SPAN,
                    MARGIN+i*GRID_SPAN);
        }
        //画竖线
        for(int j=0;j<=COLS;j++) {
            g.drawLine(MARGIN+j*GRID_SPAN,
                    MARGIN,
                    MARGIN+j*GRID_SPAN,
                    MARGIN+ROWS*GRID_SPAN);
        }
        //画棋子
        for(int i=0;i<chessCount;i++) {
            //得到棋子x坐标
            int xpos=chessList[i].getX()*GRID_SPAN+MARGIN;
            //得到棋子y坐标
            int ypos=chessList[i].getY()*GRID_SPAN+MARGIN;
            //设置棋子颜色
            g.setColor(chessList[i].getColor());
            g.fillOval(xpos-Chess.DIAMETER/2,
                    ypos-Chess.DIAMETER/2,
                    Chess.DIAMETER,
                    Chess.DIAMETER);//画棋子

            if(i==chessCount-1){
                //标记最后一个棋子为红色
                g.setColor(Color.red);
                g.drawRect(xpos-Chess.DIAMETER/2,
                        ypos-Chess.DIAMETER/2,
                        Chess.DIAMETER,
                        Chess.DIAMETER);
            }
        }
    }
    //查找所在位置是否有棋子
    private boolean findchess(int index,int yindex) {
        for (Chess c : chessList) {
            if(c!=null&&c.getX()==xindex&&c.getY()==yindex)
                return true;
        }
        return false;
    }
    //对棋子输赢的判断
    private boolean win(int x,int y,boolean start) {
        String str=start?"黑棋":"白棋";
        //棋子所在行和列是否有五子相连的情况
        for(int i=0;i<16;i++){
            if((board[x][i].equals(str)
                    &&board[x][i+1].equals(str)
                    &&board[x][i+2].equals(str)
                    &&board[x][i+3].equals(str)
                    &&board[x][i+4].equals(str))
                    ||(board[i][y].equals(str)
                    &&board[i+1][y].equals(str)
                    &&board[i+2][y].equals(str)
                    &&board[i+3][y].equals(str)
                    &&board[i+4][y].equals(str)))
                return true;
        }
        //棋子所在撇行是否有五子相连的情况
        if(x+y>=4&&x+y<=30){
            int i=(x+y<=19)?x+y:x+y-20;
            if(x+y<=19){
                for(int k=0;k<=i-4;k++){
                    if(board[k][i-k].equals(str)&&board[k+1][i-k-1].equals(str)&&board[k+2][i-k-2].equals(str)&&board[k+3][i-k-3].equals(str)&&board[k+4][i-k-4].equals(str))
                        return true;
                }
            }else{
                for(int k=i;k<=15;k++){
                    if(board[k][20-k].equals(str)&&board[k+1][20-k-1].equals(str)&&board[k+2][20-k-2].equals(str)&&board[k+3][20-k-3].equals(str)&&board[k+4][20-k-4].equals(str))
                        return true;
                }
            }
        }
        //棋子所在捺行是否有五子相连的情况
        if(y-x<=15&&x-y<=15){
            int i=(x<y)?y-x:x-y;
            if(x<y){
                for(int k=0;k<=19-4-i;k++){
                    if(board[k][i+k].equals(str)&&board[k+1][i+k+1].equals(str)&&board[k+2][i+k+2].equals(str)&&board[k+3][i+k+3].equals(str)&&board[k+4][i+k+4].equals(str))
                        return true;
                }
            }else{
                for(int k=i;k<=15;k++){
                    if(board[k][i+k].equals(str)&&board[k+1][i+k+1].equals(str)&&board[k+2][i+k+2].equals(str)&&board[k+3][i+k+3].equals(str)&&board[k+4][i+k+4].equals(str))
                        return true;
                }
            }
        }
        return false;
    }
    //悔棋函数
    public void goback() {
        if(chessCount==0) {
            return ;
        }
        chessList[chessCount-1]=null;
        chessCount--;
        if(chessCount>0) {
            xindex=chessList[chessCount-1].getX();
            yindex=chessList[chessCount-1].getY();
        }
        start=!start;
        repaint();
    }
    //重新开始函数
    public void restartGame() {
        //设置为初始状态
        for(int i = 0;i<chessList.length;i++)
            chessList[i]=null;
        for(int i=0;i<MARGIN*2+GRID_SPAN*COLS;i++) {
            for (int j = 0; j < MARGIN*2+GRID_SPAN*COLS; j++) {
                board[i][j]="0";
            }
        }
        start=true;
        GameOver=false;
        chessCount=0;
        repaint();
    }
    //画矩形
    public Dimension getPreferredSize(){
        return new Dimension(MARGIN*2+GRID_SPAN*COLS,MARGIN*2+GRID_SPAN*ROWS);
    }

}