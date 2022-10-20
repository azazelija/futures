package investing.project.callable;

import investing.project.dto.FuturesEnum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.concurrent.Callable;

public class InvestingCallable implements Callable<String> {

    private final FuturesEnum futuresEnum;

    public InvestingCallable(FuturesEnum futuresEnum) {
        this.futuresEnum = futuresEnum;
    }

    @Override
    public String call() throws Exception {
        Document doc = Jsoup.connect(futuresEnum.getUrl()).get();
        String data = doc.select(".arial_26.inlineblock").text();

        if (data.isEmpty())
            throw new IllegalArgumentException("Запрос не вернул данные по фьючерсу " + futuresEnum.name());

        return data;
    }
}
