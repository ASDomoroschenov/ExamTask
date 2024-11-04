package ru.sberp.javaseniortask.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "email_data")
public class EmailData {

  @Id
  @Column(name = "id", nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_data_seq")
  @SequenceGenerator(name = "email_data_seq", sequenceName = "email_data_seq", allocationSize = 1)
  private Long id;

  @JoinColumn(name = "user_id")
  @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.REMOVE)
  private User user;

  @Column(name = "email", nullable = false)
  private String email;
}
