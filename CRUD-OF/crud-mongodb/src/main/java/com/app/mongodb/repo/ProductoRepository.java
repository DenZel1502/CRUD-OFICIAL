package com.app.mongodb.repo;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.app.mongodb.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {

}
