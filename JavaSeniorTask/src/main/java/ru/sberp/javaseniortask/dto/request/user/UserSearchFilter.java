package ru.sberp.javaseniortask.dto.request.user;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchFilter {

  private LocalDate dateOfBirth;

  private String phone;

  private String name;

  private String email;
}
