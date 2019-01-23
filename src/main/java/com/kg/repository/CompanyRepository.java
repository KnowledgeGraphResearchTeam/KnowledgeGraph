package com.kg.repository;

import com.kg.model.Company;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.List;

public interface CompanyRepository extends CrudRepository<Company,Long>{
    @Query(value="from Company ")
    List<Company> findAll();
    @Query(value="from Company where id:=Id")
    Company findById(@Param("Id")Long companyId);

}

public interface CompanyGraphRepository extends  Neo4jRepository<Company,Long>{

}
