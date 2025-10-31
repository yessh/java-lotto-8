package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottos, int count) {

        for (int i = 0; i < count; i++) {
            Lotto randomLotto = Lotto.makeRandomLotto();
            lottos.add(randomLotto);
        }
    }



}
