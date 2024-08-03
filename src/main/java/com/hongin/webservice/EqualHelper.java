package com.hongin.webservice;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EqualHelper implements Helper<Object> {
    @Override
    public Object apply(Object context, Options options) throws IOException {
        String arg1, arg2;
        if(null == context || null == options){
            throw new IllegalArgumentException("Parameter is empty");
        }

        arg1 = context.toString();
        arg2 = options.param(0).toString(); // options는 여러개 받을 수 있음.

        return arg1.equals(arg2);
    }
}
