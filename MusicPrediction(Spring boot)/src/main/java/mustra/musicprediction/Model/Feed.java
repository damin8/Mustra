package mustra.musicprediction.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Feed {
    private String rank;
    private String artistName;
    private String songName;
    private String comment;
}
