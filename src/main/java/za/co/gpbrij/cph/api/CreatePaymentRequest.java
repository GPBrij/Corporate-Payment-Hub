package za.co.gpbrij.cph.api;
import jakarta.validation.constraints.*; import java.math.BigDecimal; import java.time.LocalDate;
public record CreatePaymentRequest(@NotBlank String customerId,@NotBlank String beneficiaryId,@NotNull @DecimalMin("0.01") BigDecimal amount,@NotBlank @Pattern(regexp="[A-Z]{3}") String currency,@NotBlank String clientReference,@NotNull @FutureOrPresent LocalDate valueDate) {}
