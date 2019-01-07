package com.testtriangle.forexengine.controller;

import com.testtriangle.forexengine.data.repository.ForexRepository;
import com.testtriangle.forexengine.domain.Forex;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("forex")
public class ForexController {


    private ForexRepository forexRepository;


    public ForexController(ForexRepository forexRepository) {

        this.forexRepository = forexRepository;
    }


    /**GET REQUEST
     * @getAll display all forex to test http://localhost:8080/forex/
     */
    @GetMapping
    public List<Forex> getAll()
    {
        return this.forexRepository.findAll();

    }

    /**
     *
     * @param id
     * @return forex by id
     */
    @GetMapping("/{id}")
    public Optional<Forex> getById(@PathVariable("id") String id){
        return this.forexRepository.findById(id);
    }

    /**PUT REQUEST
     * @insert create a new forex
     */
    @PutMapping
    public void insert(@RequestBody Forex forex) {
        this.forexRepository.insert(forex);

    }

    /**
     * POST REQUEST
     * http://localhost:8080/forex/
     * Has to send the JSON in the body
     * @update update a forex
     */
    @PostMapping
    public void update(@RequestBody Forex forex) {
        this.forexRepository.save(forex);

    }

    /**
     * DELETE REQUEST
     * @delete by id
     * http://localhost:8080/forex/id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){

        this.forexRepository.deleteById(id);
    }



}
