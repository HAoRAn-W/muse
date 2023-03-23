package one.whr.muse;

import one.whr.muse.entity.met.MetArtwork;
import one.whr.muse.repository.MetArtworkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MuseApplicationTests {
    @Autowired
    MetArtworkRepository metArtworkRepository;

    @Test
    void contextLoads() {
    }


}
