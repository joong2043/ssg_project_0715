import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WiseSayingService {
    List<WiseSaying> wiseSayings;

    public WiseSayingService(){
        wiseSayings = new ArrayList<WiseSaying>();
    }

    void addFunction(WiseSaying wiseSaying){
        wiseSayings.add(wiseSaying);
    }

    void listFunction(){
        Stream<WiseSaying> wiseSayingStream = wiseSayings.stream();
        wiseSayingStream.forEach(element-> System.out.print(element));
    }

    void removeFunction(int id){
        wiseSayings.remove(id-1);
    }

    public void modifyFunction(int id, String content, String author){
        WiseSaying modifyWiseSaying = wiseSayings.get(id-1);
        modifyWiseSaying.content=content;
        modifyWiseSaying.author=author;
    }

    WiseSaying find(int id){
        WiseSaying foundWiseSaying = wiseSayings.get(id-1);

        return foundWiseSaying;
    }
}
