import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WiseSayingRepository {
    List<WiseSaying> wiseSayings;

    public WiseSayingRepository(){
        wiseSayings = new ArrayList<WiseSaying>();
    }

    public void add(WiseSaying wiseSaying){
        wiseSayings.add(wiseSaying);
    }

    public void list(){
        Stream<WiseSaying> wiseSayingStream = wiseSayings.stream();
        wiseSayingStream.forEach(element -> System.out.print(element));
    }

    public void remove(int id){
        wiseSayings.remove(id-1);
    }

    public void modify(int id, String content, String author){
        WiseSaying modifyWiseSaying = wiseSayings.get(id-1);
        modifyWiseSaying.content=content;
        modifyWiseSaying.author=author;
    }

    WiseSaying find(int id){
        WiseSaying foundWiseSaying = wiseSayings.get(id-1);

        return foundWiseSaying;
    }

}
