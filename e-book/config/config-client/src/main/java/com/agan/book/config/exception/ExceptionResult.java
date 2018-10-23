package com.agan.book.config.exception;


import com.agan.book.config.exception.enums.base.IErrorEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * smart-spring-boot-web
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/11/12
 * @time: 下午12:36
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/11/12 下午12:36
 */
public class ExceptionResult {
    /******* Fields Area *******/

    private Integer code;
    private String message;
    private List<Error> errors = new ArrayList<>();


    /******* Construction Area *******/
    public ExceptionResult() {
    }

    public ExceptionResult(IErrorEnum errorEnum) {
        this.message = errorEnum.getMessage();
        this.code = (Integer) errorEnum.getCode();
        errors.add(new Error().setReason(errorEnum.getReason()).setMessage(errorEnum.getMessage()));
    }

    /******* GetSet Area ******/

    public Integer getCode() {
        return code;
    }

    public ExceptionResult setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ExceptionResult setMessage(String message) {
        this.message = message == null ? null : message.trim();
        return this;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public ExceptionResult setErrors(List<Error> errors) {
        this.errors = errors;
        return this;
    }

    /******* Method Area *******/


    public void addError(String reason, String message) {
        this.errors.add(new Error().setReason(reason).setMessage(message));
    }

    public static class Error {
        private String domain;
        private String reason;
        private String message;

        public String getDomain() {
            return domain;
        }

        public Error setDomain(String domain) {
            this.domain = domain == null ? null : domain.trim();
            return this;
        }

        public String getReason() {
            return reason;
        }

        public Error setReason(String reason) {
            this.reason = reason == null ? null : reason.trim();
            return this;
        }

        public String getMessage() {
            return message;
        }

        public Error setMessage(String message) {
            this.message = message == null ? null : message.trim();
            return this;
        }
    }


}
