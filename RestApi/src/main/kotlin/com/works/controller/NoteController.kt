package com.works.controller

import com.works.entity.Note
import com.works.service.NoteService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/note")
class NoteController(
    private val noteService: NoteService
) {

    @PostMapping("save")
    fun save(@RequestBody note: Note) = noteService.save(
        note
    )

    @GetMapping("list")
    fun list() = noteService.list()

}