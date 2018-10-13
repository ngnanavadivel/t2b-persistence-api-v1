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

import com.t2b.api.persistence.entity.Member;
import com.t2b.api.persistence.repository.MemberRepository;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository repo;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Member save(@RequestBody Member toBeCreated) {
        System.out.println(toBeCreated);
        return repo.save(toBeCreated);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Member update(@RequestBody Member toBeUpdated) {
        return repo.save(toBeUpdated);
    }

    @DeleteMapping(path = "/{memberId}")
    public void delete(@PathVariable Long memberId) {
        repo.deleteById(memberId);
    }

    @GetMapping(path = "/{memberId}")
    public Member find(@PathVariable Long memberId) {
        Optional<Member> findById = repo.findById(memberId);
        return findById.isPresent() ? findById.get() : null;
    }

    
    @GetMapping()
    public Page<Member> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

}
