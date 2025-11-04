package model;

import lombok.Data;

import static org.apache.commons.lang3.RandomStringUtils.*;

@Data
public class EstimateRequest {
    private String name;
    private String email;
    private String description;

    public EstimateRequest(boolean isRandom) {
        if (isRandom) {
            name = secure().nextAlphanumeric(10);
            email = secure().nextAlphanumeric(5) + "@" + secure().nextAlphanumeric(5) + ".com";
            description = secure().nextAlphanumeric(100);
        }
    }
}
