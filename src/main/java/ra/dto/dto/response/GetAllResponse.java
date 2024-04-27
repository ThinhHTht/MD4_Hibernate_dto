package ra.dto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GetAllResponse {
    private int catalogId;
    private String catalogName;
    private Date created;
}
