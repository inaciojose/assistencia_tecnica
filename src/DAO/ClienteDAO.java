package DAO;

import Modelo.Cliente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class ClienteDAO {

    private static Session sessao;

    public ClienteDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public void cadastrarCliente(Cliente c) {
        try {
            sessao.beginTransaction();
            sessao.saveOrUpdate(c);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
    
    public Cliente consultarClientePorNome(String nome){
        Criteria criteria = sessao.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("nome", nome));
        return (Cliente) criteria.uniqueResult();
    
}
     public List<Cliente> listarTodosNomes() {
        Criteria criteria = sessao.createCriteria(Cliente.class);
        return criteria.list();
    }
}
