package Repository;

import Model.Soldier;

import javax.persistence.EntityManager;
import java.util.List;

public class SoldierRepositoryImpl implements SoldierRepository {
    private EntityManager em;

    public SoldierRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Soldier getSoldierById(Integer id) {
        return em.find(Soldier.class,id);
    }

    @Override
    public List<Soldier> getAll() {
        return em.createQuery("from Soldier").getResultList();
    }

    @Override
    public Soldier addSoldier(Soldier soldier) {
        em.getTransaction().begin();
        em.persist(soldier);
        em.getTransaction().commit();
        return soldier;
    }

    @Override
    public void deleteSoldier(Soldier soldier) {
        em.getTransaction().begin();
        em.remove(soldier.getId());
        em.getTransaction().commit();
    }
}
