package one.whr.muse.repository;

import one.whr.muse.entity.met.MetArtwork;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MetArtworkRepository extends MongoRepository<MetArtwork, Float> {
    List<MetArtwork> findAll();
}
