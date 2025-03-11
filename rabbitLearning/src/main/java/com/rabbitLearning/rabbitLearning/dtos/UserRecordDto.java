package com.rabbitLearning.rabbitLearning.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(@NotBlank String nome,
                            @NotBlank @Email String email) {
}
