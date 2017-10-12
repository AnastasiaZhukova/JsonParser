package com.github.anastasiazhukova.jsonparser.HttpClient;

import java.io.InputStream;

public interface IHttpClient {

    InputStream request(String pURL) throws Exception;
}
