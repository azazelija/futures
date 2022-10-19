package investing.project.web;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.exception.ExceptionUtils;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ExcController {

    String message;

    String detail;

    public ExcController(Throwable ex) {
        this.message = ex.getMessage();
        this.detail = ExceptionUtils.getStackTrace(ex);
    }
}