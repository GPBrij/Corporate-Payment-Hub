package za.co.gpbrij.cph.api;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.time.Instant; import java.util.*;
@RestControllerAdvice public class ApiExceptionHandler {
 @ExceptionHandler(NotFoundException.class) ResponseEntity<?> missing(NotFoundException e){return ResponseEntity.status(404).body(Map.of("timestamp",Instant.now(),"error",e.getMessage()));}
 @ExceptionHandler({IllegalStateException.class,IllegalArgumentException.class}) ResponseEntity<?> bad(RuntimeException e){return ResponseEntity.badRequest().body(Map.of("timestamp",Instant.now(),"error",e.getMessage()));}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<?> validation(MethodArgumentNotValidException e){var errors=e.getBindingResult().getFieldErrors().stream().collect(java.util.stream.Collectors.toMap(x->x.getField(),x->Objects.requireNonNullElse(x.getDefaultMessage(),"invalid"),(a,b)->a)); return ResponseEntity.badRequest().body(Map.of("timestamp",Instant.now(),"errors",errors));}
}
