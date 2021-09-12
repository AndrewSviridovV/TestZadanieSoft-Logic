import okhttp3.OkHttpClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class RequestTest {

    private HandlerApi handler;
    String testStr;
    String[] words;

    @Before
    public void prepareForTest() {
        OkHttpClient client = new OkHttpClient();
        handler = new HandlerApi(client);
        testStr = "как у вас дела";
        words = testStr.split("\\s+");
    }

    @Test
    public void testRequestWithoutErrors() {
        List<SpellResult> result = handler.sendReuqest(testStr);
        Assert.assertNotNull("result is null", result);
        Assert.assertEquals("Правильный текст", 0, result.size());

    }

    @Test
    public void testRequestWithOneErrors() {
        List<SpellResult> result = handler.sendReuqest(testStr);
        Assert.assertNotNull("result is null", result);
        Assert.assertEquals("текст с одним неверным словом", 1, result.size());

    }

    @Test
    public void testRequestWithOnlyErrors() {
        List<SpellResult> result = handler.sendReuqest(testStr);
        Assert.assertNotNull("result is null", result);
        Assert.assertEquals("Все слова в тексте неверны", words.length, result.size());
    }

}
