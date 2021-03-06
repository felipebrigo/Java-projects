package Dao;

import Data.Supplier;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDao{
    
    public void Salvar (Supplier supplier){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();    
        em.merge(supplier);
        em.getTransaction().commit();
        em.close();
    }
}
/*
public class GenericDao<T extends Supplier> implements Serializable {

    private static final EntityManager em = JPAUtil.getEntityManager();

    //CRUD Methods
    
    //Search for ID
    public T buscarPorId(Class<T> clazz, Integer id) {
        return em.find(clazz, id);
    }
    //Save Method
    public void Salvar(T t) {
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        
    em.close();
    }

    //Delete method searching item by ID
    public void remove(Class<T> clazz, Integer id) {
        T t = buscarPorId(clazz, id);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();

        }
    em.close();
    }

    //Search all items and show them in a list
    public List<T> buscarTodos(String findall) {
        Query query = em.createQuery(findall);
        return query.getResultList();
    }


    /*
public interface GenericDao <T,Type extends Serializable> {

    void beginTransaction();
    void commitTransaction();
    void save(T entity);
    void delete(T entity);
    List<T> listAll();
}

public interface SupplierDao extends GenericDao<Supplier,Integer>{
    
}
    
    
    private Class<T> persistedClass;
    
    protected GenericDao() {
    }
    
    protected GenericDao(Class<T> persistedClass) {
        this();
        this.em = JPAUtil.getEntityManager();
        this.persistedClass = persistedClass;
    }
    
    public void salvar(@Valid T entity) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(entity);
        em.flush();
        t.commit();
    }
    
    public T atualizar(@Valid T entity) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(entity);
        em.flush();
        t.commit();
        return entity;
    }
    
    public void remover(I id) {
        T entity = encontrar(id);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        T mergedEntity = em.merge(entity);
        em.remove(mergedEntity);
        em.flush();
        tx.commit();
    }
    
    public List<T> getList() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        return em.createQuery(query).getResultList();
    }
    
    public T encontrar(I id) {
        return em.find(persistedClass, id);
    }

Save persistence method - Connection to Database
    public void Save (PurchaseContract pc){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();    
        em.merge(pc);
        em.getTransaction().commit();
        em.close();
    }
}*/
