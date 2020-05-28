package mustra.musicprediction.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Music {
    private String algorithm;
    private String artistFindCount;
    private String artistSongFindCount;
    private String artistSongNewsCount;
    private int fanNum;
    private boolean video;
}
