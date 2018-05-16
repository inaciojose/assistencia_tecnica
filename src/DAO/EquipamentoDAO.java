/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Equipamento;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author aluno
 */
public class EquipamentoDAO {

    private static Session sessao;

    public EquipamentoDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public void cadastrarEquipamento(Equipamento q) {
        try {
            sessao.beginTransaction();
            sessao.saveOrUpdate(q);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public Equipamento consultarEquipamentoPorId(int id) {
        Criteria criteria = sessao.createCriteria(Equipamento.class);
        criteria.add(Restrictions.eq("codigo", id));
        return (Equipamento) criteria.uniqueResult();

    }
    
    public List<Equipamento> listarTodosEquipamentos() {
        Criteria criteria = sessao.createCriteria(Equipamento.class);
        return criteria.list();
    }
}
