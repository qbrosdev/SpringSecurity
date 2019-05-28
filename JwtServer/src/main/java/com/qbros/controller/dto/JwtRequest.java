package com.qbros.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtRequest {
    private String userName;
    private long id;
    private String role;
}
