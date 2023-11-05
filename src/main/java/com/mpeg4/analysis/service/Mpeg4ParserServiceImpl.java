package com.mpeg4.analysis.service;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class Mpeg4ParserServiceImpl implements Mpeg4ParserService{
    @Override
    public void streamUrl(String url) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            byte[] byteArray = IOUtils.toByteArray(inputStream);
            System.out.println(byteArray.toString());
            parseMPEG4Boxes(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseMPEG4Boxes(byte[] byteArray) {
    }
}
