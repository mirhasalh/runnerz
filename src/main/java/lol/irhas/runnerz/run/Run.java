package lol.irhas.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run(
        @Id
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime endedOn,
        @Positive
        Integer miles,
        Location location,
        @Version
        Integer version
) {
    public Run {
        if (!endedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("endedOn must be after startedOn");
        }
    }
}