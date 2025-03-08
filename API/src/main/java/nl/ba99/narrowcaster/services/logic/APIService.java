package nl.ba99.narrowcaster.services.logic;

import java.util.List;

public interface APIService<DtoObject> {
    List<DtoObject> getList();
    DtoObject get(long id);
    long create(DtoObject dto);
    void update(DtoObject dto, long id);
    void delete(long id);
    long create(DtoObject dto, Long userId, String username);
    void update(DtoObject dto, long id, Long userId, String username);
    void delete(long id, Long userId, String username);
}
