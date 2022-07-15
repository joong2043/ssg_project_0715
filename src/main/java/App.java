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
            String[] cmdBits = cmd.split("//?",2);
            String path = cmdBits[0];
            String queryStr = cmdBits.length==2?cmdBits[1] : null;

            switch (path){
                case "등록":
                    write();
                    break;

                case "목록":
                    list();
                    break;

                case "삭제":
                    remove(queryStr);
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

    void remove(String queryStr){
        System.out.println("명언을 삭제한다. ");

        lastId--;

    }
}
