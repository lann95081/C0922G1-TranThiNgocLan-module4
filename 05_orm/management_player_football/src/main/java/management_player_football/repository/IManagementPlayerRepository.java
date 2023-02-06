package management_player_football.repository;

import management_player_football.model.Player;

import java.util.List;

public interface IManagementPlayerRepository {
    List<Player> findAll();

    void save(Player player);

    Player findById(int id);

    void remove(Player player);
}
