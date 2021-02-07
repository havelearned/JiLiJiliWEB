package com.yinghua.application.util;

/**
 * @ClassName Resp
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-22-17:05-20
 * @Version 1.0
 */
public class Resp<E> {
    private String code;
    private String message;
    private E body;

    public Resp() {
    }

    public Resp(String code, String message, E body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getBody() {
        return body;
    }

    public void setBody(E body) {
        this.body = body;
    }

    public static <E> Resp<E> success(E body) {
        return new Resp("200", "", body);
    }

    public static <E> Resp<E> fail(String code, String message) {
        return new Resp(code, message, (Object) null);
    }
}
