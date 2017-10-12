package com.github.anastasiazhukova.jsonparser.Mocks;

import junit.framework.Assert;

import java.io.InputStream;

public class InputStreamMocks {

    public static InputStream inputStream(final String pSource) {
        final InputStream resourceAsStream = InputStreamMocks.class.getClassLoader().getResourceAsStream(pSource);
        Assert.assertNotNull("Resource not found", resourceAsStream);
        return resourceAsStream;
    }
}
