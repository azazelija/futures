package investing.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FuturesDto {
    String US30;
    String US500;
    String USTech100;
    String SmallCap2000;
    String SP500VIX;
    String DAX;
    String CAC40;
    String FTSE100;
    String EuroStoxx50;
    String FTSEMIB;
    String SMI;
    String IBEX35;
    String RTS;
    String WIG20;
    String AEX;
    String iBovespa;
    String Nikkei225;
    String TOPIX;
    String HangSeng;
    String ChinaHShares;
    String CSI300;
    String ChinaA50;
    String SPASX200;
    String SingaporeMSCI;
    String Nifty50;
    String BankNIFTY;
    String KOSPI200;
    String SGXFTSETaiwanF;
    String SouthAfrica40;
    String TecDAX;
                

    public void setPosition(int pos, String value) {
        switch (pos) {
            case 1: this.US30 = value;
                break;
            case 2: this.US500 = value;
                break;
            case 3: this.USTech100 = value;
                break;
            case 4: this.SmallCap2000 = value;
                break;
            case 5: this.SP500VIX = value;
                break;
            case 6: this.DAX = value;
                break;
            case 7: this.CAC40 = value;
                break;
            case 8: this.FTSE100 = value;
                break;
            case 9: this.EuroStoxx50 = value;
                break;
            case 10: this.FTSEMIB = value;
                break;
            case 11: this.SMI = value;
                break;
            case 12: this.IBEX35 = value;
                break;
            case 13: this.RTS = value;
                break;
            case 14: this.WIG20 = value;
                break;
            case 15: this.AEX = value;
                break;
            case 16: this.iBovespa = value;
                break;
            case 17: this.Nikkei225 = value;
                break;
            case 18: this.TOPIX = value;
                break;
            case 19: this.HangSeng = value;
                break;
            case 20: this.ChinaHShares = value;
                break;
            case 21: this.CSI300 = value;
                break;
            case 22: this.ChinaA50 = value;
                break;
            case 23: this.SPASX200 = value;
                break;
            case 24: this.SingaporeMSCI = value;
                break;
            case 25: this.Nifty50 = value;
                break;
            case 26: this.BankNIFTY = value;
                break;
            case 27: this.KOSPI200 = value;
                break;
            case 28: this.SGXFTSETaiwanF = value;
                break;
            case 29: this.SouthAfrica40 = value;
                break;
            case 30: this.TecDAX = value;
                break;
        }
    }
}
