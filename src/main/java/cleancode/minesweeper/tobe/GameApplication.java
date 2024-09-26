package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.Beginner;
import cleancode.minesweeper.tobe.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Beginner();

        Minesweeper minesweeper = new Minesweeper(gameLevel, new ConsoleInputHandler(), new ConsoleOutputHandler());
        minesweeper.initialize();
        minesweeper.run();
    }

    /**
     * DIP (Dependency Inversion Principle)
     * 고수준 모듈과 저수준 모듈이 추상화에 의존해야 한다.
     * DI (Dependency Injection)
     * 의존성 주입 (필요한 의존성을 외부에서 주입) - "3" 제 3자가 의존성 주입
     * IoC (Inversion of Control)
     * 제어의 역전 (프로그램의 흐름을 개발자가 아닌 프레임워크 제어)
     *
     */
}
