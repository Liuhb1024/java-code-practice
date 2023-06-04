package book;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 * @description： 书架
 */
public class BookList {

    private Book[] books = new Book[10];

    private int usedSize; //计数器 来记录 当前实际放的书的数目

    //定义一个数组来存储书
    public BookList(){
        //构造方法 来初始化成员
        this.books[0]= new Book("三国演义","罗贯中",10,"小说");
        this.books[1]= new Book("西游记","吴承恩",23,"小说");;
        this.books[2]= new Book("红楼梦","曹雪芹",8,"小说");;
        this.usedSize = 3;
    }

    public Book getBook(int pos){
        return books[pos];
    }

    public void setBooks(int pos, Book book){
        books[pos] = book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
