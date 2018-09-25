package com.sk;

import com.sk.dao.CountryDao;
import com.sk.entity.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class GeoController {

    @Autowired
    private CountryDao countryDao;

    @GetMapping("/countries")
    public List<CountryEntity> getAllCountries() {
        return countryDao.getAll();
    }

    @GetMapping("/countries/{countryId}")
    public CountryEntity getCountryById(@PathVariable("countryId") int id) {
        return countryDao.getById(id);
    }

    @PostMapping("/countries")
    @ResponseStatus(HttpStatus.CREATED)
    public CountryEntity createCountry(@RequestBody CountryEntity countryEntity) {
        return countryDao.create(countryEntity);
    }

    @PutMapping("/countries/{countryId}")
    public CountryEntity updateCountry(@PathVariable("countryId") int id, @RequestBody CountryEntity countryEntity) {
        return countryDao.update(id, countryEntity);
    }

    @DeleteMapping("/countries/{countryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountry(@PathVariable("countryId") int id) {
        countryDao.delete(id);
    }
}
