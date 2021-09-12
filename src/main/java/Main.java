import okhttp3.OkHttpClient;

public class Main {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        HandlerApi handlerApi = new HandlerApi(client);
        handlerApi.sendReuqest("как дела у тебя");
    }


}
