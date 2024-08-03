package com.hongin.webservice;

import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.TagType;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HandlebarsHelpers {

    public CharSequence eq(Object param, Options options) throws IOException {
        String param1 = param.toString();
        String param2 = options.param(0).toString();
        boolean isEquals = param1.equals(param2);

        if (options.tagType == TagType.SECTION) {
            return isEquals ? options.fn() : options.inverse();
        }

        return "";
    }
}
