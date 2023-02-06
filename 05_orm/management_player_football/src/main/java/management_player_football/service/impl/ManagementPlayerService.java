package management_player_football.service.impl;

import management_player_football.model.Player;
import management_player_football.repository.IManagementPlayerRepository;
import management_player_football.service.IManagementPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementPlayerService implements IManagementPlayerService {
    @Autowired
    private IManagementPlayerRepository iManagementPlayerRepository;

    @Override
    public List<Player> findAll() {
        return iManagementPlayerRepository.findAll();
    }

    @Override
    public void save(Player player) {
        iManagementPlayerRepository.save(player);
    }

    @Override
    public Player findById(int id) {
        return iManagementPlayerRepository.findById(id);
    }

    @Override
    public void remove(Player player) {
        iManagementPlayerRepository.remove(player);
    }
}
