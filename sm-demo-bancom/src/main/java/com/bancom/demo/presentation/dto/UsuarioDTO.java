package com.bancom.demo.presentation.dto;

import java.util.List;

import com.bancom.demo.persistence.models.Post;
import com.bancom.demo.persistence.models.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class UsuarioDTO {
    private Long id;
    private String cellphone;
    private String name;
    private String lastName;
    private String password;
}
