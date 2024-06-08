package com.example.Vacina.Utilizador;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
@RequestMapping(path = "")
public class UtilizadorController {

    public UtilizadorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final RestTemplate restTemplate;

    @PostMapping("/stock_centro")
    public void Registar_Stock_Centro(@RequestBody String message) {
        String cent = null;
        try {
            JSONParser parser = new JSONParser(message);
            Map<String, Object> jsonMap = (Map<String, Object>) parser.parse();
            String centro = (String) jsonMap.get("centro");
            String ceno = String.format("{\"nome\": \"%s\",\"localidade\": \"%s\"}", centro, jsonMap.get("localidade"));
            String url = "lb://centrovac/centro_vac";
            restTemplate.postForObject(url, ceno, String.class);
            url = String.format("lb://centrovac/centro_vac/nome?nome=%s", centro);
            cent = restTemplate.getForObject(url, String.class);
            String cen = String.format("{\"centro\": \"%s\",\"vacina\": \"%s\",\"quantidade\": \"%s\"}", cent, jsonMap.get("vacina"), jsonMap.get("quantidade"));
            url = "lb://stock/stock";
            restTemplate.postForObject(url, cen, String.class);
        } catch (Exception e) {
//            String url = String.format("lb://centrovac/centro_vac?id=%s", cent);
//            restTemplate.delete(url,String.class);
            e.printStackTrace();
        }
    }
}
