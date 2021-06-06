package BusinessLayer;

import org.junit.jupiter.api.Test;

class MapQuestManagerTest {

    @Test
    void http() {
        MapQuestManager.setinfor("test","wien", "Graz");
        MapQuestManager.sendHttp();
    }
}