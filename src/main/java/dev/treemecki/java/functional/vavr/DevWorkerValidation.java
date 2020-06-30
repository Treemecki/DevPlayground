package dev.treemecki.java.functional.vavr;

import dev.treemecki.java.functional.vavr.data.Worker;
import dev.treemecki.java.functional.vavr.data.WorkerProfession;
import io.vavr.collection.CharSeq;
import io.vavr.collection.Seq;
import io.vavr.control.Option;
import io.vavr.control.Validation;

import java.util.Arrays;

public final class DevWorkerValidation {

    private static final String VALID_NAME_CHARS = "[a-zA-Z ]";

    public Validation<Seq<String>, Worker> validate(final String firstName, final String lastName, final WorkerProfession profession) {
        final Validation<String, String> firstNameValidation = validateName(firstName, "first name");
        final Validation<String, String> lastNameValidation = validateName(lastName, "last name");
        final Validation<String, WorkerProfession> validationValidation = validateProfession(profession);
        return Validation.combine(firstNameValidation, lastNameValidation, validationValidation).ap(Worker::new);
    }

    private Validation<String, String> validateName(final String name, final String nameInLog) {
        return CharSeq.of(Option.of(name).getOrElse(""))
                .replaceAll(VALID_NAME_CHARS, "")
                .transform(seq -> determineNameValidation(seq, name, nameInLog));
    }

    private Validation<String, String> determineNameValidation(final CharSeq nameCharSeq, final String name, final String nameInLog) {
        return nameCharSeq.isEmpty() ? Validation.valid(name) : buildInvalidNameResult(nameCharSeq, nameInLog);
    }

    private Validation<String, String> buildInvalidNameResult(final CharSeq nameCharSeq, final String nameInLog) {
        return Validation.invalid("Value of " + nameInLog + " contains invalid characters: '" + nameCharSeq.distinct().sorted() + "'");
    }

    private Validation<String, WorkerProfession> validateProfession(final WorkerProfession profession) {
        return isSoftwareDeveloper(profession) ? Validation.valid(profession) : Validation.invalid("Profession is invalid: " + profession);
    }

    private boolean isSoftwareDeveloper(final WorkerProfession profession) {
        return Arrays.asList(
                WorkerProfession.JAVA_DEVELOPER,
                WorkerProfession.KOTLIN_DEVELOPER
        ).contains(profession);
    }

}
