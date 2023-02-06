package management_player_football.service;

import management_player_football.model.Player;

import java.util.List;

public interface IManagementPlayerService {
    List<Player> findAll();

    void save(Player player);

    Player findById(int id);

    void remove(Player player);
}
