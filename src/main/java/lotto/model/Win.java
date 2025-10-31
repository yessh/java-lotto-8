package lotto.model;

import java.util.List;

public enum Win {

    WIN_NUMBERS;

    private List<Integer> value;

    public void setValue(List<Integer> value) {
        this.value = value;
    }

    public List<Integer> getValue() {
        return value;
    }

}
