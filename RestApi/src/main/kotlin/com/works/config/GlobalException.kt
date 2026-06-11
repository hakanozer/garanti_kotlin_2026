package com.works.config

import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun methodArgumentNotValid(ex: MethodArgumentNotValidException) : List<Map<String, String?>> {
        return parseError(ex.bindingResult.fieldErrors)
    }

    @ExceptionHandler(IllegalStateException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun illegalState(ex: IllegalStateException) : Map<String, String?> {
        return mapOf("message" to ex.message)
    }

    fun parseError(erros: List<FieldError> ) : List<Map<String, String?>> {
        val list = mutableListOf<Map<String, String?>>()
        erros.forEach {
            val map = mapOf(
                "field" to it.field,
                "message" to it.defaultMessage,
                "rejectedValue" to it.rejectedValue?.toString()
            )
            list.add(map)
        }
        return list
    }
}