package com.example.weaponsshop2.repositories;

import com.example.weaponsshop2.models.Gun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GunsRepository extends JpaRepository<Gun, Integer> {

}
