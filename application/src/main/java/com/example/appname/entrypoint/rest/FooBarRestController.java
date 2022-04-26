package com.example.appname.entrypoint.rest;

import com.example.appname.model.FooBar;
import com.example.appname.usecase.SaveFooBar;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Slf4j
@RestController
@RequestMapping("/v1/foobar")
@AllArgsConstructor
public class FooBarRestController {

    private SaveFooBar saveFooBar;

    @PostMapping("/add")
    private void save(@RequestBody FooBarRequest fooBarRequest) {
        FooBar fooBar = fooBarRequest.toDomain();
        log.info("Received fooBar to save {} {}",
                kv("foo", fooBar.getFoo()),
                kv("bar", fooBar.getBar())
        );
        this.saveFooBar.execute(fooBar);
    }

}
