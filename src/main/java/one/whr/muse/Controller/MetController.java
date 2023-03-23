package one.whr.muse.Controller;

import lombok.extern.slf4j.Slf4j;
import one.whr.muse.entity.met.MetArtwork;
import one.whr.muse.repository.MetArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://muse.whr.one", maxAge = 3600)
public class MetController {
    @Autowired
    MetArtworkRepository metArtworkRepository;

    private final String metObjectURL = "https://collectionapi.metmuseum.org/public/collection/v1/objects/{id}";

    private Random rand = new Random();

    private RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/met")
    public MetArtwork getMetArtwork() {
//        if (metArtworkRepository.count() != 0) {
//            return metArtworkRepository.findAll().get(0);
//        }
        MetArtwork artwork;
        do {
            artwork = queryMetArtwork();
        } while (artwork.getPrimaryImage() == null || artwork.getPrimaryImage().length() == 0);

        metArtworkRepository.save(artwork);
        return artwork;
    }

    private MetArtwork queryMetArtwork() {
        ResponseEntity<MetArtwork> response = null;
        boolean is404;
        do {
            is404 = false;
            int id = rand.nextInt(860872) + 1;
            log.info("the object ID is " + id);
            try {
                response = restTemplate.getForEntity(metObjectURL, MetArtwork.class, id);
            } catch (HttpClientErrorException e) {
                is404 = true;
            }

        } while (is404 || response.getStatusCodeValue() != 200);
        return response.getBody();
    }
}
