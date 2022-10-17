package investing.project.futures;

import investing.project.dto.FuturesDto;
import investing.project.dto.FuturesEnum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.Callable;

public class InvestingAllCallable implements Callable<FuturesDto> {

    FuturesEnum futuresEnum;

    public InvestingAllCallable(FuturesEnum futuresEnum) {
        this.futuresEnum = futuresEnum;
    }

    @Override
    public FuturesDto call() throws Exception {
        Document doc = Jsoup.connect(futuresEnum.getUrl()).get();

        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

        String spx_500 = rows.get(3).select("td").get(3).text();
        String nq_100 = rows.get(4).select("td").get(3).text();
        String sml_cap = rows.get(5).select("td").get(3).text();

        FuturesDto futuresDto = new FuturesDto();
        futuresDto.setSpx_500(spx_500);
        futuresDto.setNq_100(nq_100);
        futuresDto.setSml_cap(sml_cap);

        return futuresDto;
    }
}
