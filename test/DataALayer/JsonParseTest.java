package DataALayer;

import APP.Config;
import org.junit.jupiter.api.Test;

class JsonParseTest {



    @Test
    void getjson() {
        Config config=JsonParse.getConfig(JsonParse.readConfig());
        System.out.println(config.url);
        System.out.println(config.MapUrl);
        System.out.println(config.MapSize);
    }

    @Test
    void config() {
        System.out.println(JsonParse.config());
    }


}