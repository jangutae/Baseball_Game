package week04.baseballgame.Baseball_Game;

import java.util.*;

public class BaseballGame {
    HashSet<Integer> setNumber = new HashSet<>();
    Random random = new Random();
    List<Integer> afterShuffle = new ArrayList<>(GenerateNumber());
    List<Integer> inputLists = new ArrayList<>(GenerateNumber());
    Scanner sc = new Scanner(System.in);
    BaseballGameDisplay strikeAndBall = new BaseballGameDisplay();
    String inputValue;
    int attempt = 0;

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame() {
        GenerateNumber();
    }

    public int play() {
        while (true) {
            System.out.println("숫자를 입력하세요");
            // String 타입으로 숫자 및 문자 입력
            inputValue = sc.nextLine();

            try {
                // 세자리 숫자인지 확인
                if (inputValue.length() != 3 || !inputValue.matches("\\d+")) {
                    throw new IllegalArgumentException("올바르지 않은 입력값입니다");
                }
                // 0을 포함하는지 확인
                if (inputValue.contains("0")) {
                    throw new IllegalArgumentException("올바르지 않은 입력값입니다");
                }
                // 중복된 숫자 확인
                if (inputValue.charAt(0) == inputValue.charAt(1) ||
                        inputValue.charAt(0) == inputValue.charAt(2) ||
                        inputValue.charAt(1) == inputValue.charAt(2)) {
                    throw new IllegalArgumentException("올바르지 않은 입력값입니다");
                }
                // try문 안에 if문 조건에 맞으면 catch문을 실행
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return play();
            }

            // String 타입을 int 타입으로 변환
            Integer number = Integer.valueOf(inputValue);
            int inputNumber = number;
            System.out.println(inputNumber);

            // int 타입을 나눗셈과 나머지를 이용하여 List에 저장
            for (int i = 0; i < 3; i++) {
                int digit = inputNumber % 10;
                inputLists.add(digit);
                inputNumber /= 10;
            }
            // 역순으로 다시 정렬함
            Collections.reverse(inputLists);

            // 3 스트라이크 경우 정답입니다. 출력
            if (countStrike("스트라이크") == 3) {
                System.out.println("정답입니다.!");
                break;
            }

            // 아웃의 경우와 스트라이크 갯수 볼 갯수 출력
            if (countStrike("스트라이크") == 0 && countBall("볼") == 0) {
                System.out.println("아웃");
            } else {
                System.out.println(countStrike("스트라이크") + "스트라이크 "
                        + countBall("볼") + "볼");
            }
            // 숫자 입력 이후 칸 띄우기
            System.out.println();

            attempt++;
        }
        // 게임 진행횟수 반환
        return attempt;
    }
    // 기능 구현 실패
    private boolean validateInput(String input) {
        boolean result = false;

        return result;
    }

    // Strike 갯수 int 반환
    private int countStrike(String input) {
        int strike = 0;
        for (int i = 0; i < afterShuffle.size(); i++) {
            if (afterShuffle.get(i) == inputLists.get(i)) {
                strike++;
            }
        }
        return strike;
    }
    // getter 생성 (기능 구현 실패)
    public int getStrike() {
        return countStrike("스트라이크");
    }

    // ball 갯수 int 반환
    private int countBall(String input) {
        int ball = 0;
        for (int i = 0; i < afterShuffle.size(); i++) {
            if (afterShuffle.get(i) == inputLists.get(i)) {
                continue;
            } else if (afterShuffle.contains(inputLists.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    // getter 생성 (기능 구현 실패)
    public int getBall() {
        return countBall("볼");
    }

    // 랜덤 숫자 생성
    public List<Integer> GenerateNumber() {
        while (setNumber.size() < 3) {
            int randomNumber = random.nextInt(9) + 1;
            setNumber.add(randomNumber);
        }
        List<Integer> beforeShuffle = new ArrayList<>(setNumber);
        Collections.shuffle(beforeShuffle);

        return beforeShuffle;
    }


}




