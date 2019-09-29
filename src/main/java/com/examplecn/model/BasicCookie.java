
package com.examplecn.model;

import io.netty.handler.codec.http.cookie.DefaultCookie;

/**
 * @Description: (这里用一句话描述这个类的作用)
 * @author: Aaron
 * @date: 2019/9/29 14:54
 */
public class BasicCookie extends DefaultCookie {

    /**
     * Creates a new cookie with the specified name and value.
     *
     * @param name
     * @param value
     */
    public BasicCookie(String name, String value) {
        super(name, value);
    }
}
