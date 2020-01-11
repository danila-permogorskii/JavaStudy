package Repository;

import Model.Soldier;

import java.util.List;

public interface SoldierRepository {
    Soldier getSoldierById(Integer id);
    List<Soldier> getAll();
    Soldier addSoldier(Soldier soldier);
    void deleteSoldier(Soldier soldier);
}
