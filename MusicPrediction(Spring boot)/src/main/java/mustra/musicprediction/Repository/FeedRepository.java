package mustra.musicprediction.Repository;

import mustra.musicprediction.Model.Feed;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedRepository extends MongoRepository<Feed, String> {
    Feed findFeedBy_id(String _id);
}
