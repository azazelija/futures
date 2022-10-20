package investing.project.service;

import investing.project.callable.InvestingAllCallable;
import investing.project.callable.InvestingCallable;
import investing.project.dto.ShortFuturesDto;
import investing.project.dto.FuturesEnum;
import investing.project.exc.FutureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
@Slf4j
public class FuturesService {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public String getInvestingIndex(String futureName) {
        FuturesEnum futuresEnum = FuturesEnum.valueOf(FuturesEnum.class, futureName.toUpperCase());
        String value = getInvestingIndex(futuresEnum);

        return value;
    }

    public ShortFuturesDto getAllInvestingIndexes() {
        log.info("Получение данных всех фьючерсов");
        //Асинхронный вызов на investing
        Future<ShortFuturesDto> futureTask = executorService.submit(new InvestingAllCallable(FuturesEnum.ALL));
        try {
            ShortFuturesDto value = futureTask.get(2, TimeUnit.SECONDS);
            return value;
        } catch (Exception e) {
            log.error("Ошибка получения данных фьючерсов ", e);
            throw new FutureException(e);
        }
    }

    public String getInvestingIndex(FuturesEnum futuresEnum) {
        log.info("Получение данных фьючерса {}", futuresEnum.name());
        //Асинхронный вызов на investing
        Future<String> futureTask = executorService.submit(new InvestingCallable(futuresEnum));
        try {
            String value = futureTask.get(2, TimeUnit.SECONDS);
            return value;
        } catch (Exception e) {
            log.error("Ошибка получения данных фьючерса {} ", futuresEnum.name(), e);
            throw new FutureException(e);
        }
    }
}
