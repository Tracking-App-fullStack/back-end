package com.badreddine.tirgani.repository;


import com.badreddine.tirgani.dto.UserDto;
import com.badreddine.tirgani.entity.Branch;
import com.badreddine.tirgani.entity.Team;
import com.badreddine.tirgani.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
/**
 * Author: Badreddine TIRGANI
 */
@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {



    List<Team> findBySuperviseur(User superviseur);
    List<Team> findByChefEquipe(User chefEquipe);
    
    List<Team> findByDeletedFalse();

    Optional<Team> findByTeamName(String teamName);

    @Query(value ="SELECT * FROM team_members  WHERE members_id = :id;", nativeQuery = true)
    Optional<UserDto> findByTeamId(@Param("id") Long id);

    List<Team> getByBranch(Branch branch);
}
