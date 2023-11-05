package com.mpeg4.analysis.controller;

import com.mpeg4.analysis.service.Mpeg4ParserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.URISyntaxException;

@RestController
public class Mpeg4ParserController {

    private Mpeg4ParserService mpeg4ParserService;

    public Mpeg4ParserController(Mpeg4ParserService mpeg4ParserService){
        this.mpeg4ParserService = mpeg4ParserService;
    }

    @GetMapping("/file")
    public void analyzeFile(@RequestParam String url) throws URISyntaxException {
        mpeg4ParserService.streamUrl(url);
    }
}
