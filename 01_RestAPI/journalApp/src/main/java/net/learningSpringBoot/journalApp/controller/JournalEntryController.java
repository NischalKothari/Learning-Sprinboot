package net.learningSpringBoot.journalApp.controller;

import net.learningSpringBoot.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEnteries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEnteries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEnteries.put(myEntry.getId(),myEntry);
        return true;
    }

    @GetMapping("/id/{myID}")
    public JournalEntry getJournalEntryById(@PathVariable Long myID){
        return journalEnteries.get(myID);
    }

    @DeleteMapping("id/{myID}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myID){
        return journalEnteries.remove(myID);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return journalEnteries.put(id, myEntry);
    }
}