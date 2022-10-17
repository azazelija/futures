package investing.project.dto;

public enum FuturesEnum {
    ALL("https://ru.investing.com/indices/indices-futures"),
    NQ_100("https://ru.investing.com/indices/nq-100-futures-chart?cid=1175151"),
    SPX_500("https://ru.investing.com/indices/us-spx-500-futures-chart?cid=1175153"),
    SML_CAP("https://ru.investing.com/indices/smallcap-2000-futures-chart?cid=1174944");

    private final String url;

    FuturesEnum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
