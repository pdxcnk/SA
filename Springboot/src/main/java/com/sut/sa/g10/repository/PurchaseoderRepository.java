package com.sut.sa.g10.repository;

import com.sut.sa.g10.entity.Purchaseoder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public
interface PurchaseoderRepository extends JpaRepository<Purchaseoder,Long> {
}