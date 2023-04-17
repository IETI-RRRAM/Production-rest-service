package edu.eci.agronomo.production.repository;

import edu.eci.agronomo.production.model.production.Production;
import edu.eci.agronomo.production.model.production.ProductionDto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ProductionRepositoryImpl implements ProductionRepository {

    @Autowired
    private final MongoTemplate mongoTemplate;

    public ProductionRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public ArrayList<Production> findAll() {
        return (ArrayList<Production>) mongoTemplate.findAll(Production.class);
    }

    @Override
    public Optional<Production> findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return Optional.ofNullable(mongoTemplate.findOne(query, Production.class));
    }

    @Override
    public Optional<Production> findByIdAnimal(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("idAnimal").is(id));
        return Optional.ofNullable(mongoTemplate.findOne(query, Production.class));
    }


    @Override
    public Production save(ProductionDto productionDto) {
        return mongoTemplate.save(new Production(String.valueOf(ObjectId.get()), productionDto));
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Production.class);
    }

    @Override
    public Production update(String id, ProductionDto productionDto) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update()
                .set("idAnimal", productionDto.getIdAnimal())
                .set("productions", productionDto.getProductions())
                .set("totalProduction", productionDto.getTotalProduction());
        mongoTemplate.updateFirst(query, update, Production.class);
        return findById(id).orElse(null);
    }
}
