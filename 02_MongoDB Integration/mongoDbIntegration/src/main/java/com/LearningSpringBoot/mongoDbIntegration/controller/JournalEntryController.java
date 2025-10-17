package com.LearningSpringBoot.mongoDbIntegration.controller;

import com.LearningSpringBoot.mongoDbIntegration.entity.JournalEntry;
import com.LearningSpringBoot.mongoDbIntegration.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry((myEntry));
        return true;
    }

    @GetMapping("/id/{myID}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myID){
        return journalEntryService.findById(myID).orElse(null);
    }

    @DeleteMapping("id/{myID}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myID){
        journalEntryService.deleteById(myID);
        return true;
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry){
        JournalEntry oldEntry = journalEntryService.findById(id).orElse(null);
        if(oldEntry != null){
            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : oldEntry.getContent());
        }
        journalEntryService.saveEntry(oldEntry);
        return oldEntry;
    }
}
