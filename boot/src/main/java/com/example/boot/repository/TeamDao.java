package com.example.boot.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.boot.entities.Team;

/*
 * We don't actually NEED to add anything else to this interface, we could make use of the built
 * in methods Spring data provides, but due to our custom needs we will ad a few of our own methods
 */

public interface TeamDao extends JpaRepository<Team, Integer> {
    
    /*
     * as long as we follow proper naming conventions (findBy{field}) we can have Spring handle the boilerplate
     * code for getting data from our database
     */

    Optional<Team> findByTeamName(String name); // this is all we need for this method to work

    @Transactional
    @Modifying
    @Query(value = "insert into teams values (default, :teamName)", nativeQuery = true) // Spring sees :{String} as a placeholder
    void createTeam(@Param("teamName") String teamName); // @Param("teamName") tells Spring to replace the placeholder with the given parameter

    @Transactional
    @Modifying
    @Query(value = "update teams set team_name = :teamName where team_id = :teamId", nativeQuery = true)
    int updateTeam(@Param("teamName") String teamname, @Param("teamId") int id);

}
