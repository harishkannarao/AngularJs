package com.harishkannarao.angularjs.validation.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@Pattern.List({
        @Pattern(regexp = "^.+$", message = "{string.empty}")
})
@NotNull(message = "{string.null}")
@Constraint(validatedBy = {})
@Documented
@Target({ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullAndNonEmptyString {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD,
            ElementType.FIELD,
            ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR,
            ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        NotNullAndNonEmptyString[] value();
    }
}
