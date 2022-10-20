package investing.project.futures;

import investing.project.dto.FuturesDto;
import investing.project.dto.FuturesEnum;
import investing.project.exc.FutureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
@Slf4j
public class FuturesService {

//    private static final String NQ_100 = "https://ru.investing.com/indices/nq-100-futures-chart?cid=1175151";
//    private static final String SPX_500 = "https://ru.investing.com/indices/us-spx-500-futures-chart?cid=1175153";
//    private static final String SML_CAP = "https://ru.investing.com/indices/smallcap-2000-futures-chart?cid=1174944";

    ExecutorService executorService = Executors.newCachedThreadPool();

//    public String putFutureValue(String futureName) {
//        FuturesEnum futuresEnum = FuturesEnum.valueOf(FuturesEnum.class, futureName.toUpperCase());
//        FuturesDto futuresDto = new FuturesDto();
//        futuresDto.setNq_100();
//    }

    public String getInvestingIndex(String futureName) {
        FuturesEnum futuresEnum = FuturesEnum.valueOf(FuturesEnum.class, futureName.toUpperCase());
        String value = getInvestingIndex(futuresEnum);

        return value;
    }

    public FuturesDto getAllInvestingIndexes() {
        log.info("Получение данных всех фьючерсов");
        //Асинхронный вызов на investing
        Future<FuturesDto> futureTask = executorService.submit(new InvestingAllCallable(FuturesEnum.ALL));
        try {
            FuturesDto value = futureTask.get(1, TimeUnit.SECONDS);

            return value;
        } catch (Exception e) {
            log.error("Ошибка получения данных фьючерсов ", e);
//            log.info("Попытка получить данные повторно");
            throw new FutureException(e);
        }
    }

    public String getInvestingIndex(FuturesEnum futuresEnum) {
        log.info("Получение данных фьючерса {}", futuresEnum.name());
        //Асинхронный вызов на investing
        Future<String> futureTask = executorService.submit(new InvestingCallable(futuresEnum));
        try {
            String value = futureTask.get(1, TimeUnit.SECONDS);

            return value;
        } catch (Exception e) {
            log.error("Ошибка получения данных фьючерса {} ", futuresEnum.name(), e);
//            log.info("Попытка получить данные повторно");
            throw new FutureException(e);
        }
    }
}
