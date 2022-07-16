import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class WiseSayingController {
    // 등록, 목록, 삭제, 수정 기능 여기에 일단 다 넣기

    int lastId;
    List<WiseSaying> wiseSayings;

    Scanner sc;
    public WiseSayingController(Scanner sc){
        lastId=0;
        wiseSayings = new ArrayList<WiseSaying>();
        this.sc = sc;
    }

    WiseSayingService wiseSayingService = new WiseSayingService();


    void write(){
        lastId++;
        System.out.printf("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가 : ");
        String author = sc.nextLine();


        WiseSaying addWiseSaying = new WiseSaying(lastId,content,author);

        wiseSayingService.addFunction(addWiseSaying);
        System.out.println(addWiseSaying);
    }

    void list() {
        System.out.println("===명언 목록===");
        System.out.println("번호 / 명언 / 작가");
        wiseSayingService.listFunction();

    }

    public void remove(Rq rq){

        int id = rq.getIntParam("id",0);

        if(id==0){
            System.out.println("삭제할 id를 입력해주세요.");
            return;
        }

        wiseSayingService.removeFunction((id));

        lastId--;
        System.out.printf("%d번 명언을 삭제합니다. \n",(id));


    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id",0);

        if(id==0){
            System.out.println("수정할 id를 입력해주세요.");
            return;
        }

        WiseSaying modifyWiseSaying = wiseSayingService.find(id);

        System.out.printf("명언(기존) : %s\n",modifyWiseSaying.content);
        System.out.printf("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가(기존) : %s\n",modifyWiseSaying.author);
        System.out.printf("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modifyFunction(id,content,author);

    }

}
