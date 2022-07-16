import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {
    Scanner sc;
    int lastId;

    ArrayList<WiseSaying> wiseSayings = new ArrayList<>();

    public App(){
        sc = new Scanner(System.in);
        lastId = 0;
    }

    void run(){
        System.out.println("== 명언 SSG ==");


        outer:
        while (true){
            System.out.printf("명령) ");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd);

            switch (rq.getPath()){
                case "등록":
                    write();
                    break;

                case "목록":
                    list();
                    break;

                case "삭제":
                    remove(rq);
                    break;

                case "수정":
                    modify(rq);
                    break;

                case "종료":
                    break outer;

            }
        }
    }

    void write(){
        lastId++;
        System.out.printf("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가 : ");
        String author = sc.nextLine();

        WiseSaying addWiseSaying = new WiseSaying(lastId,content,author);
        wiseSayings.add(addWiseSaying);
        System.out.println(addWiseSaying);
    }
    void list(){
        System.out.println("===명언 목록===");
        System.out.println("번호 / 명언 / 작가");
        Stream<WiseSaying> wiseSayingStream = wiseSayings.stream();
        wiseSayingStream.forEach(element -> System.out.print(element));
    }

    private void remove(Rq rq){

        int id = rq.getIntParam("id",0);

        if(id==0){
            System.out.println("삭제할 id를 입력해주세요.");
            return;
        }

        wiseSayings.remove((id-1));

        lastId--;
        System.out.printf("%d번 명언을 삭제합니다. \n",(id));


    }

    void modify(Rq rq) {
        int id = rq.getIntParam("id",0);

        if(id==0){
            System.out.println("수정할 id를 입력해주세요.");
            return;
        }

        WiseSaying modifyWiseSaying = wiseSayings.get(id-1);

        System.out.printf("명언(기존) : %s\n",modifyWiseSaying.content);
        System.out.printf("명언 : ");
        String content = sc.nextLine();
        modifyWiseSaying.content = content;

        System.out.printf("작가(기존) : %s\n",modifyWiseSaying.author);
        System.out.printf("작가 : ");
        String author = sc.nextLine();
        modifyWiseSaying.author=author;

    }

}