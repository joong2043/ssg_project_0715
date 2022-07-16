import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WiseSayingService {

    public WiseSayingService(){

    }
    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();




    void addFunction(WiseSaying wiseSaying){
        wiseSayingRepository.add(wiseSaying);
    }

    void listFunction(){
        wiseSayingRepository.list();
    }

    void removeFunction(int id){
        wiseSayingRepository.remove(id);
    }

    public void modifyFunction(int id, String content, String author){
        wiseSayingRepository.modify(id,content,author);
    }

    WiseSaying find(int id){
        WiseSaying wiseSaying = wiseSayingRepository.find(id);
        return wiseSaying;
    }
}
