package dev.treemecki.test.java.functional;

import dev.treemecki.java.functional.vavr.DevWorkerValidation;
import dev.treemecki.java.functional.vavr.data.Worker;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import io.vavr.control.Validation.Invalid;
import io.vavr.control.Validation.Valid;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dev.treemecki.java.functional.vavr.data.WorkerProfession.*;

public class VavrTests {

    @Test
    public void devWorkerValidationTest() {
        final DevWorkerValidation validation = new DevWorkerValidation();
        final Validation<Seq<String>, Worker> adamValidation = validation.validate("Adam", "Novak", JAVA_DEVELOPER);
        final Validation<Seq<String>, Worker> andrewValidation = validation.validate("Andrew", "Jackson1", KOTLIN_DEVELOPER);
        final Validation<Seq<String>, Worker> patrickValidation = validation.validate("Patrick", "Kovalsky", SOFTWARE_TESTER);
        Assertions.assertAll(
                "vavr",
                () -> Assert.assertTrue(adamValidation instanceof Valid),
                () -> Assert.assertTrue(patrickValidation instanceof Invalid),
                () -> Assert.assertTrue(andrewValidation instanceof Invalid)
        );
    }

}
