package com.gerenciador.email.view;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class EmailDTO {
    @Email
    @NotNull
    private String destino;
    @NotNull
    @Email
    private String remetente;
    @NotNull
    @Size(min = 3, max = 100)
    private String assunto;
    private String corpoEmail;
    private LocalDateTime dataRecebimento;
}
