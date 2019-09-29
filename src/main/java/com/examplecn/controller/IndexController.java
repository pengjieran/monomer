package com.examplecn.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/index", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IndexController {

}