package management_player_football.repository.impl;

import management_player_football.model.Player;
import management_player_football.repository.ConnectionUtil;
import management_player_football.repository.IManagementPlayerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagementPlayerRepository implements IManagementPlayerRepository {
    @Override
    public List<Player> findAll() {
        Session session = null;
        List<Player> playerList;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            playerList = session.createQuery("from Player").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return playerList;
    }

    @Override
    public void save(Player player) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(player);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Player findById(int id) {
        Session session = null;
        Player player;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            player = (Player) session.createQuery("FROM Player where id = :id").setParameter("id", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return player;
    }

    @Override
    public void remove(Player player) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(player);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
