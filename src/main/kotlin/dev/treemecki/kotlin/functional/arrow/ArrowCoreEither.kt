package dev.treemecki.kotlin.functional.arrow

import arrow.core.Either
import arrow.core.flatMap
import dev.treemecki.kotlin.functional.arrow.Problem.EmptyEmailAddressProblem
import dev.treemecki.kotlin.functional.arrow.Problem.NameUnavailableProblem

sealed class Problem {
    data class EmptyEmailAddressProblem(val person: Person) : Problem()
    data class NameUnavailableProblem(val person: Person) : Problem()
    data class InformationSizeProblem(val person: Person, val size: Int) : Problem()
}

data class EmailData(val headData: EmailHeadData, val information: Information)
data class EmailHeadData(val person: Person, val title: String)
data class Person(val name: String, val emailAddress: String)
inline class Information(val value: String)

fun writeEmailInformation(person: Person, information: Information): Either<Problem, EmailData> =
    selectRecipient(person)
        .flatMap { prepareTitle(it) }
        .flatMap { prepareInformation(it, information) }

fun selectRecipient(person: Person): Either<Problem, Person> =
    if (person.emailAddress.isEmpty()) Either.left(EmptyEmailAddressProblem(person)) else Either.right(person)

fun prepareTitle(person: Person): Either<Problem, EmailHeadData> =
    if (person.name.trim().isEmpty()) {
        Either.left(NameUnavailableProblem(person))
    } else {
        Either.right(
            EmailHeadData(
                person,
                "Information to ${person.name}"
            )
        )
    }

fun prepareInformation(headData: EmailHeadData, information: Information): Either<Problem, EmailData> =
    if (information.value.length !in 1..100) {
        val left = Either.left(
            Problem.InformationSizeProblem(
                headData.person,
                information.value.length
            )
        )
        left
    } else {
        Either.right(EmailData(headData, information))
    }
