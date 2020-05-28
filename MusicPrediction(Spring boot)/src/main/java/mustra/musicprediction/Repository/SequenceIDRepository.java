package mustra.musicprediction.Repository;

import mustra.musicprediction.Model.SequenceID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceIDRepository extends MongoRepository<SequenceID, String> {
    SequenceID findBy_id(String _id);
    int countBy_id(String _id);
}
