package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.minesweeper.Minesweeper;
import cleancode.minesweeper.tobe.minesweeper.config.GameConfig;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.Beginner;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {

        GameConfig gameConfig = new GameConfig(
                new Beginner(),
                new ConsoleInputHandler(),
                new ConsoleOutputHandler()
        );

        Minesweeper minesweeper = new Minesweeper(gameConfig);
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
