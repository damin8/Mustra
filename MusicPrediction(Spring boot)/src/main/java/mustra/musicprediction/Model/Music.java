package mustra.musicprediction.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Music {
    private String artistName;
    private String songName;
    private String fanNum;
    private String video;
}
