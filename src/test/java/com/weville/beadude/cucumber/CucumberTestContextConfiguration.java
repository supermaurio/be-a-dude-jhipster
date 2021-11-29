package com.weville.beadude.cucumber;

import com.weville.beadude.BeaHipsterApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = BeaHipsterApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
