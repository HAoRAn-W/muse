package one.whr.muse.repository;

import one.whr.muse.entity.met.MetArtwork;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetArtworkRepository extends MongoRepository<MetArtwork, Float> {
    List<MetArtwork> findAll();
}
