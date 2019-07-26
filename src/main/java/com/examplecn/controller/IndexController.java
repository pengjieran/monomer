package com.examplecn.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api/v1/index", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(tags = "首页")
public class IndexController {

}