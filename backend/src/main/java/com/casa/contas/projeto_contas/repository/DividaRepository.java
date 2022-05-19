package com.casa.contas.projeto_contas.repository;

import com.casa.contas.projeto_contas.model.Divida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DividaRepository extends JpaRepository<Divida, Integer> {
    @Query("SELECT d FROM Divida d WHERE d.devedor = id")
    List<Map<String, Object>> findDividasDevedor(@Param("id") Integer id);
}
