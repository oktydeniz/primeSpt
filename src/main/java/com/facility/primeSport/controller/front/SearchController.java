package com.facility.primeSport.controller.front;

import com.facility.primeSport.dto.common.SearchItemRequest;
import com.facility.primeSport.dto.fitness.WorkoutResponse;
import com.facility.primeSport.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/search")
public class SearchController {


    private final SearchService service;

    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping("/workout")
    @ResponseBody
    public List<WorkoutResponse> searchForWorkoutName(@RequestParam("query") String query){
        return service.searchForWorkoutName(query);
    }
}
