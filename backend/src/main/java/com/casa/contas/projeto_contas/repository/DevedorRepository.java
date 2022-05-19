package com.casa.contas.projeto_contas.repository;

import com.casa.contas.projeto_contas.model.Devedor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface DevedorRepository extends JpaRepository<Devedor, Integer> {


  /**  @Query("SELECT d FROM Devedor d WHERE d.devedor_id = :devedor_id")
    List<Devedor> findByDevedorId(@Param("devedor_id") Integer devedor_id); **/

    @Query("SELECT u.id as id, u.nome as nome, u.valor_total as valor_total, u.apelido as apelido," +
           " d as dividas FROM Devedor u LEFT JOIN u.dividas d")
    List<Map<String, Object>> findAllUsuariosview();

  @Query("SELECT d FROM Devedor d WHERE d.id = :id")
  List<Map<String, Object>> findDividasDevedor(@Param("id") Integer id);

}
