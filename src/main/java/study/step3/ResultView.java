package study.step3;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.util.stream.Collectors.joining;

class ResultView {
    private final Map<String, List<Boolean>> records;
    private final Set<String> winners;

    public ResultView(Map<String, List<Boolean>> records, Set<String> winners) {
        this.records = records;
        this.winners = winners;
    }

    public ResultView(CarRacing carRacing) {
        this(carRacing.getRecords(), carRacing.getWinners());
    }

    public void report() {
        print("실행결과");
        printRaceHistory();
        printWinners();
    }

    void printRaceHistory() {
        int laps = records.values().iterator().next().size();
        for (int i = 0; i < laps; i++) {
            printNewline();
            printRecord(i);
        }
    }

    void printWinners() {
        String names = winners.stream() //
                .sorted() //
                .map(name -> "'" + name + "'")
                .collect(joining(", "));
        print("우승자는 " + names + " 입니다.");
    }

    private void printRecord(int lastLap) {
        new TreeMap<>(records).forEach((name, record) -> {
            printNameAndRecord(name, record.subList(0, lastLap + 1));
            printNewline();
        });
    }

    private void printNameAndRecord(String name, List<Boolean> recoard) {
        //@formatter:off
        print(nameWithSpace(name) + ": " +
                recoard.stream()
                        .map(moved -> moved ? "-" : "")
                        .collect(joining())
        );
        //@formatter:on
    }

    public static String nameWithSpace(String name) {
        return String.format("%-5s", name);
    }

    protected void print(String content) {
        System.out.print(content);
    }

    private void printNewline() {
        print(System.lineSeparator());
    }
}
