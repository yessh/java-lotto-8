package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int count) {

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.makeRandomLotto());
        }
        this.lottos = Collections.unmodifiableList(lottos);
    }


    public List<Lotto> getLottos() {
        return lottos;
    }


}
