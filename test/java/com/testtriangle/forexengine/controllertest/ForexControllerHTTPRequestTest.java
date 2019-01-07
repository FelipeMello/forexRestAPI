package com.testtriangle.forexengine.controllertest;

import net.minidev.json.JSONObject;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.FileReader;
import java.net.URI;

import static net.minidev.json.JSONValue.parse;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ForexControllerHTTPRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    public TestRestTemplate getRestTemplate() {
        return restTemplate;
    }

    /**
     * this test test the getAll method from the controller
     * @see com.testtriangle.forexengine.controller.ForexController
     * @throws Exception
     */
    @Test
    public void testGetData() throws Exception {
        String data = restTemplate.getForObject("http://localhost:" + port + "/forex",
                String.class);

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/forex",
                String.class)).contains(data);
    }

    @Test
    public void testInsertData()throws Exception{
        String path = "C:\\Users\\felip\\Documents\\testTriangle\\mongo-db\\forexengine\\src\\test\\java\\com\\testtriangle\\forexengine\\controllertest\\myJSON.json";
        JSONObject obj = (JSONObject) parse(new FileReader(path));

        final String baseUrl = "http://localhost:"+port+"/forex/";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = restTemplate.postForEntity(uri,obj, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());


    }
    @Test
    public void testUpdateData()throws Exception{
        String path = "C:\\Users\\felip\\Documents\\testTriangle\\mongo-db\\forexengine\\src\\test\\java\\com\\testtriangle\\forexengine\\controllertest\\myJSON.json";
        JSONObject obj = (JSONObject) parse(new FileReader(path));

        final String baseUrl = "http://localhost:"+port+"/forex/";
        URI uri = new URI(baseUrl);

        //Posting new data
        ResponseEntity<String> result = restTemplate.postForEntity(uri,obj, String.class);
        Assert.assertEquals(200, result.getStatusCodeValue());

        //find by name

    }



}
