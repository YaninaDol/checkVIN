package com.example.accessingdatarest.Repositories;

import com.example.accessingdatarest.Model.Package;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PackageRepository extends CrudRepository<Package, Integer> {

}