package investing.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShortFuturesDto {

    String sp500;
    String nsdq;
    String russell;

    public void setPosition(int pos, String value) {
        switch (pos) {
            case 2:
                this.sp500 = value;
                break;
            case 3:
                this.nsdq = value;
                break;
            case 4:
                this.russell = value;
                break;
        }
    }
}
