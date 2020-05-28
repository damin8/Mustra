package mustra.musicprediction.Module;

import mustra.musicprediction.Model.SequenceID;
import mustra.musicprediction.Repository.SequenceIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sequence {

    @Autowired
    private SequenceIDRepository sequenceIDRepository;

    public int makeSequence(String collectionName){
        if (sequenceIDRepository.countBy_id(collectionName) == 0) {
            SequenceID sequenceID = new SequenceID(collectionName, 0);
            sequenceIDRepository.save(sequenceID);
        }
        SequenceID sequenceID = sequenceIDRepository.findBy_id(collectionName);
        int seqNum = sequenceID.getSeqNum() + 1;
        sequenceID.setSeqNum(seqNum);
        sequenceIDRepository.save(sequenceID);
        return seqNum;
    }
}
