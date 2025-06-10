package com.albertodumonttdev.pmanager;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // Apontando que é um controller para o Spring
public class ExampleController {

    @GetMapping("/ok") // Apontando quando esse método vai ser acionado
    public ResponseEntity<String> sayOk() {
        return ResponseEntity.ok("Ok");
    }

    @PostMapping("/echo")
    // @RequestBody Extraindo corpo do protocolo
    public ResponseEntity<String> echo(@RequestBody String value) {
        StringBuilder sb = new StringBuilder(value);
        return ResponseEntity.ok(sb.reverse().toString());
    }
}
