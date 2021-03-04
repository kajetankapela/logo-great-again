package com.logogreatagain.repository;

import com.logogreatagain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("select player, sum(points) as player_scores from Scores group by player order by player_scores")
    List<Player> findBestOfAllTime();

    @Query("select player, "
            + "sum(points) as player_scores from Scores where Scores.year = ?1"
            + "group by player order by player_scores")
    List<Player> findBestOfYear(int currentYear);

    @Query("select player, "
            + "sum(points) as player_scores from Scores where Scores.year = ?1 and Scores.month = ?2 and Scores.day = ?1"
            + "group by player order by player_scores")
    List<Player> findBestOfWeek(int deadlineYear, int deadlineMonth, int deadlineDay);

    @Query("select player, "
            + "sum(points) as player_scores from Scores where Scores.year = ?1 and Scores.month = ?2 and Scores.day = ?1"
            + "group by player order by player_scores")
    List<Player> findBestOfDay(int currentYear, int currentMonth, int currentDay);

    Player findByName(String name);
}
