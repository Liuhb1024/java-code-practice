package test_7_31;

/**
 * @author 刘浩彬
 * @date 2023/7/31
 */
public class Card {
    private String suit;//花色
    private  int rank; //扑克数字

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        /*return "Card{" +
                "suit='" + suit + '\'' +
                ", rank=" + rank +
                '}';
         */
        return suit+rank;
    }
}
