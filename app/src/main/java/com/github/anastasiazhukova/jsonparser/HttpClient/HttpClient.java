package com.github.anastasiazhukova.jsonparser.HttpClient;

import java.io.InputStream;

public class HttpClient implements IHttpClient {

    @Override
    public InputStream request(String pURL) throws Exception {
        throw  new IllegalStateException("HttpClient is not implemented");
    }
}
