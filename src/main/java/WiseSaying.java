public class WiseSaying {
    int id;
    String content;
    String author;

    WiseSaying(int id, String content, String author){
        this.id = id;
        this.content = content;
        this.author=author;
    }

    @Override
    public String toString() {
        return id+" / " + content + " / "+author+"\n";
    }
}
