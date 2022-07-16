import java.util.List;
import java.util.stream.Stream;

public class WiseSayingService {
    List<WiseSaying> wiseSayings;

    public WiseSayingService(List<WiseSaying> wiseSayings){
        this.wiseSayings = wiseSayings;
    }

    void addFunction(WiseSaying wiseSaying){
        wiseSayings.add(wiseSaying);
    }

    void listFunction(List<WiseSaying> wiseSayings){
        Stream<WiseSaying> wiseSayingStream = wiseSayings.stream();
        wiseSayingStream.forEach(element-> System.out.print(element));
    }

    void removeFunction(){

    }

    void modifyFunction(){

    }
}
