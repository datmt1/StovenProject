package Dao;

import java.util.List;

/**
 * Abstract class defining a generic Data Access Object (DAO) structure for entities.
 * @param <EntityType> The type of entity managed by the DAO.
 * @param <KeyType> The type of the key used to uniquely identify entities
 */
abstract public class StovenProjectDao<EntityType, KeyType> {
    abstract public void insert(EntityType entity);
    abstract public void update(EntityType entity);
    abstract public void delete(KeyType id);
    abstract public EntityType selectById(KeyType id);
    abstract public List<EntityType> selectAll();
    abstract protected List<EntityType> selectBySql(String sql, Object...args);
}
