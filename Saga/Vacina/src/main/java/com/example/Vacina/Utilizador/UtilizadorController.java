package com.example.Vacina.Utilizador;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(path = "central")
public class UtilizadorController {

    public UtilizadorController() {}

    @PostMapping("/stock_centro")
    public void Registar_Stock_Centro (@RequestBody String message ){
        String cent = null;
        try {
            JSONParser parser = new JSONParser(message);
            Map<String, Object> jsonMap = (Map<String, Object>) parser.parse();
            String centro = (String) jsonMap.get("centro");
            String ceno = String.format("{\"nome\": \"%s\",\"localidade\": \"%s\"}", centro,jsonMap.get("localidade"));
            POST(ceno,"centro_vac","8080");
            cent = GET(centro,"centro_vac/nome","nome","8080");
            String cen = String.format("{\"centro\": \"%s\",\"quantidade\": \"%s\",\"vacina\": \"%s\"}", cent,jsonMap.get("quantidade"),jsonMap.get("vacina"));
            POST(cen,"stock","8081");
        }catch (Exception e) {
            DELETE(cent,"centro_vac","8080");
            e.printStackTrace();
        }
    }

    @GetMapping("/utilizador_centro")
    public String GetUtilizador_by_centro(@RequestParam String utilizador,@RequestParam String localidade){
        String ret = null;
        try{
            String marcacoes = GET(utilizador,"marcacao/utilizador","utilizador","8080");
            System.out.println("Putas");
            JSONParser parser = new JSONParser(marcacoes);
            Object parsedObject = parser.parse();
            String centros = GET(localidade,"centro_vac/localidade","localidade","8080");
            System.out.println(centros);
            JSONParser parser1 = new JSONParser(centros);
            Object parsedObject1 = parser1.parse();
            if (parsedObject instanceof List) {
                List<Map<String, Object>> jsonMap = (List<Map<String, Object>>) parsedObject;
                if (parsedObject1 instanceof List) {
                    List<Map<String, Object>> jsonMap1 = (List<Map<String, Object>>) parsedObject1;
                    for (Map<String, Object> marcacao : jsonMap) {
                        String centro = (String) marcacao.get("centro");
                        for (Map<String, Object> cent : jsonMap1) {
                            String centr = (String) cent.get("centro");
                            if (centro.equals(centr)) {
                                ret = ret + (String.format(marcacao.toString()));
                            }
                        }
                    }
                } else if (parsedObject1 instanceof Map) {
                    Map<String, Object> singleMap1 = (Map<String, Object>) parsedObject1;
                    for (Map<String, Object> marcacao : jsonMap) {
                        String centro = (String) marcacao.get("centro");
                        String centr = (String) singleMap1.get("centro");
                        if (centro.equals(centr)) {
                            ret = ret + (String.format(marcacao.toString()));
                        }
                    }
                }
            } else if (parsedObject instanceof Map) {
                Map<String, Object> jsonMap = (Map<String, Object>) parsedObject;
                if (parsedObject1 instanceof List) {
                    List<Map<String, Object>> jsonMap1 = (List<Map<String, Object>>) parsedObject1;
                        String centro = (String) jsonMap.get("centro");
                        for (Map<String, Object> cent : jsonMap1) {
                            String centr = (String) cent.get("centro");
                            if (centro.equals(centr)) {
                                ret = ret + (String.format(jsonMap.toString()));
                            }
                        }
                } else if (parsedObject1 instanceof Map) {
                    Map<String, Object> singleMap1 = (Map<String, Object>) parsedObject1;
                    String centro = (String) jsonMap.get("centro");
                    String centr = (String) singleMap1.get("centro");
                    if (centro.equals(centr)) {
                        ret = ret + (String.format(jsonMap.toString()));
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(ret);
        return ret;
    }

    public void DELETE(String id,String path,String port ){
        try {
            String url = String.format("http://localhost:%s/%s",port,path);
            url = url + "?id=" + id;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(id);
                wr.flush();
            }
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("Response: " + response.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void POST(String message,String path,String port){
        try {
            String url = String.format("http://localhost:%s/%s",port,path);
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(message);
                wr.flush();
            }
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("Response: " + response.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String GET(String id,String path,String obj,String port) throws IOException {
        StringBuffer responseStr =null;
        String baseUrl = String.format("http://localhost:%s/%s",port,path);
        String urlName = baseUrl + String.format("?%s=%s",obj , id);
        URL urlForGetReq =  new URL(urlName);
        HttpURLConnection connection = (HttpURLConnection) urlForGetReq.openConnection();
        connection.setRequestMethod("GET");
        int codeResponse = connection.getResponseCode();
        if (codeResponse == HttpURLConnection.HTTP_OK) {
            InputStreamReader isrObj = new InputStreamReader(connection.getInputStream());
            BufferedReader bf = new BufferedReader(isrObj);
            responseStr = new StringBuffer();
            String read;
            while ((read = bf.readLine()) != null) {
                responseStr.append(read);
            }
            bf.close();
            connection.disconnect();
        } else {
            System.out.println("GET Request did not work");
        }
        return responseStr.toString();
    }
}
