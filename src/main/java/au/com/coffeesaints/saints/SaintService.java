package au.com.coffeesaints.saints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaintService {
    @Autowired
    private SaintDao saintDao;

    public List<SaintEntity> findAll() {
        return saintDao.findAll();
    }

    public List<SaintEntity> findAllInCoffeeGroupAndInSaintIds(Integer coffeeGroupId, List<Integer> saintIds) {
        return saintDao.findAllInCoffeeGroupAndInSaintIds(coffeeGroupId, saintIds);
    }

    public List<SaintEntity> findAllInCoffeeGroup(Integer congregationId) {
        return saintDao.findAllInCoffeeGroup(congregationId);
    }

    public SaintEntity lash(Integer saintId) throws Exception {
        SaintEntity saint = saintDao.get(saintId);
        saint.incrementCoffeeOffset(1);
        return saintDao.update(saint);
    }

    public SaintEntity add(SaintEntity saintEntity) {
        return saintDao.add(saintEntity);
    }

    public List<SaintEntity> update(List<SaintEntity> saints) throws Exception {
        return saintDao.update(saints);
    }
}
