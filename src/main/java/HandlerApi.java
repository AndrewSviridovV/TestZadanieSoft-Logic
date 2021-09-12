import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class HandlerApi {
    private OkHttpClient client;
    private ObjectMapper mapper;

    public HandlerApi(OkHttpClient client) {
        this.client = client;
        this.mapper = new ObjectMapper();
    }

    public List<SpellResult> sendReuqest(String text) {

        List<SpellResult> result = null;

        RequestBody postBody = new FormBody.Builder()
                .add("text", text)
                .build();

        Request request = new Request.Builder()
                .header("accept", "application/json")
                .url("https://speller.yandex.net/services/spellservice.json/checkText")
                .post(postBody)
                .build();


        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseString = response.body().string();

            result = mapper.readValue(responseString, new TypeReference<List<SpellResult>>() {
            });

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
