package DAO;

import Modelo.Funcionario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class FuncionarioDAO {
    
    private static Session sessao;
    
    public FuncionarioDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }
    
    public Funcionario Logar(String login, String senha) {
        Criteria criteria = sessao.createCriteria(Funcionario.class);
        criteria.add(Restrictions.eq("login", login));
        criteria.add(Restrictions.eq("senha", senha));
        return (Funcionario) criteria.uniqueResult();
    } 
    
    public void cadastrarFuncionario(Funcionario f) {
        try {
            sessao.beginTransaction();
            sessao.saveOrUpdate(f);
            sessao.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
    
    public Funcionario consultarFuncionarioPorId(int id){
      Criteria criteria = sessao.createCriteria(Funcionario.class);
      criteria.add(Restrictions.eq("codigo", id));
      return (Funcionario) criteria.uniqueResult();
    }
    
    public void editarFuncionario(Funcionario ef){
           try {
            sessao.beginTransaction();
            sessao.update(ef);
            sessao.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        
    }
}
