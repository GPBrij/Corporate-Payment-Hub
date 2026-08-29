package za.co.gpbrij.cph.api; import jakarta.validation.constraints.NotBlank;
public record DecisionRequest(@NotBlank String actor, @NotBlank String decision, String comments) {}
