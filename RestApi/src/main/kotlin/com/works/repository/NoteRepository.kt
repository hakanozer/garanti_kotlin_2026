package com.works.repository

import com.works.entity.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository : JpaRepository<Note, Long> {
}