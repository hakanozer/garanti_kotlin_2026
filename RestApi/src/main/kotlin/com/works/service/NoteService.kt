package com.works.service

import com.works.entity.Note
import com.works.repository.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteService (
    private val noteRepository: NoteRepository
) {

    // save
    fun save(note: Note) = noteRepository.save(note)

    // list
    fun list() = noteRepository.findAll()

}