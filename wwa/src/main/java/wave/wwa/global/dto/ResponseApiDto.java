package wave.wwa.global.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ResponseApiDto<T> {

    private int status;

    private String message;

    private T data;

    public ResponseApiDto(int status, String message) {
        this.status = status;
        this.message = message;
    }
    //반환 데이터 필요 없을때
    public static ResponseApiDto<?> of(HttpStatus httpStatus, String message) {
        int status = Optional.ofNullable(httpStatus)
                .orElse(HttpStatus.OK)
                .value();
        return new ResponseApiDto<>(status, message);
    }
    //반환 데이터 포함해서 보낼때
    public static <T> ResponseApiDto<T> of(HttpStatus httpStatus, String message, T data) {
        int statusCode = Optional.ofNullable(httpStatus)
                .orElse(HttpStatus.OK)
                .value();
        return new ResponseApiDto<>(statusCode,message,data);
    }
    //실패
    public static ResponseApiDto<?> fail(HttpStatus httpStatus, String message) {
        return new ResponseApiDto<>(httpStatus.value(), message, null);
    }
}