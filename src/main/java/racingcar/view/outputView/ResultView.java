package racingcar.view.outputView;

import racingcar.domain.record.RacingRecord;
import racingcar.domain.game.RacingGame;

import static racingcar.domain.game.utils.Constants.*;
import static racingcar.domain.game.utils.StringUtils.repeat;

public class ResultView{

    private static OutputChannel outputChannel = new SystemOut();

    public static void printGameResult(RacingGame racingGame) {
        printStartResult();
        racingGame.getRacingRecordList()
                .forEach(ResultView::printRacingRecord);
        printWinners(racingGame);

    }

    private static void printStartResult() {
        outputChannel.printLine("\n"+SAY_VIEW_RESULT);
    }

    private static void printRacingRecord(RacingRecord racingRecord) {
        racingRecord.getRacingRecord().forEach(
                (key, value) -> outputChannel.printLine(printCars(key, value))
        );
        printEmptyLine();
    }

    private static String printCars(String key, Integer value) {
        return String.format(PRINT_FORMAT, key, repeat(PRINT_GO, value));
    }

    private static void printEmptyLine() {outputChannel.printLine("");}
    private static void printWinners(RacingGame racingGame) {outputChannel.printLine(racingGame.findWinners() + SAY_WINNER_CARS_NAMES); }


}