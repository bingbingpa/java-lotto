package lotto.domain;

import lotto.domain.dto.LottoResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lottos {

    private final List<LottoNumbers> lottoNumbers;

    public Lottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumbers> getLottos() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public static Lottos of(int money) {
        LottoTickets buy = LottoTickets.of(money);
        return new Lottos(buy.getLottoTickets());
    }

    public Stream<LottoResult> mapToResult(WinningLotto winningLotto) {
        return lottoNumbers.stream()
                .map(winningLotto::toResult);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public void concat(Lottos lottos) {
        lottoNumbers.addAll(lottos.getLottos());
    }
}
