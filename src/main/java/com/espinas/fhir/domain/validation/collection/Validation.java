package com.espinas.fhir.domain.validation.collection;

import com.espinas.fhir.domain.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "validation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Validation extends BaseEntity {

    @Id
    private String id;

    private String organizationCode;

    private String data;

    private String result;

    private String status;

    public void setId(String id) {
        this.id = id;
    }

    @Builder
    public Validation(String organizationCode, String data, String result, String status) {
        this.organizationCode = organizationCode;
        this.data = data;
        this.result = result;
        this.status = status;
    }
}
