package com.t2b.api.persistence.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2b.api.persistence.entity.Membership;
import com.t2b.api.persistence.repository.MembershipRepository;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
    private MembershipRepository repo;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Membership save(@RequestBody Membership toBeCreated) {
        System.out.println(toBeCreated);
        return repo.save(toBeCreated);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Membership update(@RequestBody Membership toBeUpdated) {
        return repo.save(toBeUpdated);
    }

    @DeleteMapping(path = "/{membershipId}")
    public void delete(@PathVariable Long membershipId) {
        repo.deleteById(membershipId);
    }

    @GetMapping(path = "/{membershipId}")
    public Membership find(@PathVariable Long membershipId) {
        Optional<Membership> findById = repo.findById(membershipId);
        return findById.isPresent() ? findById.get() : null;
    }

    @GetMapping()
    public Page<Membership> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

}
