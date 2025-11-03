package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Input input;
    private final Output output;

    public LottoController() {
        this.input = new Input();
        this.output = new Output();
    }

    public void run() {
        int money = input.inputMoney();
        int count = money / 1000;

        Lottos userLottos = new Lottos(count);

        output.printLottoCount(count);
        output.printLottos(userLottos);

        Lotto winningNumbers = input.inputNumbers();

        WinningLotto winningLotto = createWinningLottoWithValidation(winningNumbers);

        Statistics statistics = new Statistics(userLottos, winningLotto, money);

        output.printStatistics(statistics);
        output.printProfitability(statistics.getProfitability());
    }

    private WinningLotto createWinningLottoWithValidation(Lotto winningNumbers) {
        while (true) {
            try {
                int bonusNumber = input.inputBonusNumber();
                return new WinningLotto(winningNumbers, bonusNumber);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
