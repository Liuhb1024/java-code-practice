package test_7_31;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 刘浩彬
 * @date 2023/7/31
 */
public class CardList {

    private static final String[] SUITS = {"♦","♥","♠","♣"};

    public static List<Card> buyCards(){
        List<Card> list = new ArrayList<>();
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 1; j <= 13; j++) {
                /**String suit = SUITS[i];
                int rank = j;
                Card card = new Card(suit,rank);
                 */
                Card card = new Card(SUITS[i],j);
                list.add(card);
            }
        }
        return list;
    }

    public static void shuffle(List<Card>list){
        Random random = new Random();
        for (int i = list.size() - 1; i > 0 ; i--) {
            int index = random.nextInt(i);
            swap(list,i,index);
        }
    }

    private static void swap(List<Card>list,int i, int j){
        Card tmp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,tmp);
    }


    public static void main(String[] args) {
        List<Card>list = buyCards();
        System.out.println(list);

        shuffle(list);
        System.out.println(list);

        List<List<Card>>hand = new ArrayList<>();

        List<Card>hand1 = new ArrayList<>();
        List<Card>hand2 = new ArrayList<>();
        List<Card>hand3 = new ArrayList<>();

        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);

        //i 控制次数
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                //接牌逻辑
                Card card = list.remove(0);
                hand.get(j).add(card);
            }
        }
        System.out.println("第一个人的牌："+hand.get(0));
        System.out.println("第二个人的牌："+hand.get(1));
        System.out.println("第三个人的牌"+hand.get(2));
        System.out.println("剩下的牌："+list);
        /*for (int i = 0; i < 3; i++) {
            System.out.println(hand.get(i));
        }*/

    }

}
