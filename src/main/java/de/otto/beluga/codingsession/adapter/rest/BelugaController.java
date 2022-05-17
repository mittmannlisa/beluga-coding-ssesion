package de.otto.beluga.codingsession.adapter.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beluga")
public class BelugaController {

  @GetMapping
  public String hello() {
    return "Hello Beluga!";
  }
}
