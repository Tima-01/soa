package org.security.soa.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks") // Добавляем имя таблицы
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Название обязательно")
    @Size(max = 100, message = "Название не должно превышать 100 символов")
    private String name;

    @Column(length = 1000)
    @Size(max = 1000, message = "Описание не должно превышать 1000 символов")
    private String description;
    @FutureOrPresent(message = "Дата должна быть сегодня или в будущем")
    private LocalDate dueDate;

    private Boolean completed; // Измените boolean на Boolean
}