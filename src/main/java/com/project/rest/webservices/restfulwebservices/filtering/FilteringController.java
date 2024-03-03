package com.project.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        Somebean somebean = new Somebean("value1","value2","value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(somebean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomebeanFilter",filter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public List<Somebean> filteringList() {
        return Arrays.asList(new Somebean("value1","value2","value3"));
    }
}
