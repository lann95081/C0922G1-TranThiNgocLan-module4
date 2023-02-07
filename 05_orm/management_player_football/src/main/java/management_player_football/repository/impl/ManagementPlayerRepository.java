package management_player_football.repository.impl;

import management_player_football.model.Player;
import management_player_football.repository.ConnectionUtil;
import management_player_football.repository.IManagementPlayerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ManagementPlayerRepository implements IManagementPlayerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Player> findAll() {
        List<Player> playerList = null;
        playerList = entityManager.createQuery("select p from Player as p").getResultList();
        return playerList;
    }

    @Override
    @Transactional
    public void save(Player player) {
        entityManager.persist(player);
    }

    @Override
    public Player findById(int id) {
        return entityManager.find(Player.class, id);
    }

    @Override
    public void remove(int id) {
        entityManager.remove(entityManager.find(Player.class, id));
    }
}
