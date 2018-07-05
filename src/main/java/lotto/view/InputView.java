package lotto.view;

import lotto.domain.LottoNo;

import java.util.*;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public Set<LottoNo> inputWinNumbers() {
        System.out.println("\n 지난 주 당첨 번호를 입력해 주세요.");
        return parse(scanner.nextLine().split(", "));
    }

    String[] splitInputString(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException();

        return input.split(", ");
    }

    public Set<LottoNo> parse(String[] values) {
        Set<LottoNo> result = new HashSet<>();
        for (String value : values) {
            result.add(new LottoNo(parseInteger(value)));
        }
        return result;
    }

    private int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 주지 말아요.");
        }
    }
}
