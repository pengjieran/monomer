
package com.examplecn.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 统一响应结果
 * @author: Aaron
 * @date: 2019/9/29 11:08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Result<T> {

    private String code;

    private String message;

    private List<T> result = new ArrayList<>();

    public static Result succeed(Object t) {

        Result result = new Result("200", "成功");
        result.add(t);
        return result;
    }

    public static Result error(String code, String message) {

        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public Result() {}

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result add(T t) {
        result.add(t);
        return this;
    }
}
