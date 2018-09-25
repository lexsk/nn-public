package com.sk.dao;

import com.sk.entity.CityEntity;
import com.sk.entity.CountryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CountryEntity> getAll() {
        return entityManager.createQuery("from CountryEntity c order by c.id desc", CountryEntity.class).getResultList();
    }

    public CountryEntity getById(int id) {
        return entityManager.find(CountryEntity.class, id);
    }

    public CountryEntity create(CountryEntity countryEntity) {
        for (CityEntity cityEntity : countryEntity.getCities()) {
            cityEntity.setCountryEntity(countryEntity);
        }
        entityManager.persist(countryEntity);
        return countryEntity;
    }

    public CountryEntity update(int id, CountryEntity countryEntity) {
        CountryEntity original = entityManager.find(CountryEntity.class, id);
        if (original != null) {
            original.setName(countryEntity.getName());
            for (CityEntity cityEntity : original.getCities()) {
                entityManager.remove(cityEntity);
            }
            original.getCities().clear();
            for (CityEntity cityEntity : countryEntity.getCities()) {
                cityEntity.setCountryEntity(original);
                original.getCities().add(cityEntity);
                entityManager.persist(cityEntity);
            }
            entityManager.merge(original);
        }
        return original;
    }

    public void delete(int id) {
        CountryEntity countryEntity = entityManager.find(CountryEntity.class, id);
        if (countryEntity != null) {
            entityManager.remove(countryEntity);
        }
    }
}
