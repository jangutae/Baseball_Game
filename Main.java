package week04.baseballgame.Baseball_Game;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // BaseballGame 객체 생성 및 게임 시작
        BaseballGame baseballgame = new BaseballGame();
        Scanner chooseNumber = new Scanner(System.in);

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        System.out.println("1. 게임시작하기 2. 게임 기록 보기 3. 종료하기");

        int inputNumber = chooseNumber.nextInt();

        // 숫자 입력시 if문, if~else문 실행됨
        if (inputNumber == 1) {
            System.out.println("게임 시작하기");
            System.out.println(baseballgame.play());
        } else if (inputNumber == 2) {
            System.out.println("게임 기록 보기");
        } else if (inputNumber == 3) {
            System.out.println("종료하기");
        }

    }

}










