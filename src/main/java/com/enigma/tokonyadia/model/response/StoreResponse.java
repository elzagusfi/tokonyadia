package com.enigma.tokonyadia.model.response;

import jdk.jshell.Snippet;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class StoreResponse {
    private String id;
    private String storeName;
    private String address;
    private String noSiup;
    private String mobilePhone;

}