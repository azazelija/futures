package investing.project.callable;

import investing.project.dto.ShortFuturesDto;
import investing.project.dto.FuturesEnum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.Callable;

public class InvestingAllCallable implements Callable<ShortFuturesDto> {

    FuturesEnum futuresEnum;

    public InvestingAllCallable(FuturesEnum futuresEnum) {
        this.futuresEnum = futuresEnum;
    }

    @Override
    public ShortFuturesDto call() throws Exception {
        Document doc = Jsoup.connect(futuresEnum.getUrl()).get();

        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

        String sp500 = rows.get(3).select("td").get(3).text();
        String nsdq = rows.get(4).select("td").get(3).text();
        String russel = rows.get(5).select("td").get(3).text();

        ShortFuturesDto shortFuturesDto = new ShortFuturesDto();
        shortFuturesDto.setSp500(sp500);
        shortFuturesDto.setNsdq(nsdq);
        shortFuturesDto.setRussell(russel);

        return shortFuturesDto;
    }
}
