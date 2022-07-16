import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {
    Scanner sc;

    String command;
    public App(){
        this.sc = new Scanner(System.in);
    }


    void run(){
        System.out.println("== 명언 SSG ==");

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        outer:
        while (true){
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq= new Rq(cmd);

            switch (rq.getPath()){
                case "등록":
                    wiseSayingController.write();
                    break;

                case "목록":
                    wiseSayingController.list();
                    break;

                case "삭제":
                    wiseSayingController.remove(rq);
                    break;

                case "수정":
                    wiseSayingController.modify(rq);
                    break;

                case "종료":
                    break outer;

            }
        }
    }



}