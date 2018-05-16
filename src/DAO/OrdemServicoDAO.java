/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.OS;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author aluno
 */
public class OrdemServicoDAO {

    private static Session sessao;

    public OrdemServicoDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public void cadastrarOS(OS o) {
        try {
            sessao.beginTransaction();
            sessao.saveOrUpdate(o);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public OS consultarOrdemDeServico(int id) {
        Criteria criteria = sessao.createCriteria(OS.class);
        criteria.add(Restrictions.eq("codigo", id));
        return (OS) criteria.uniqueResult();
    }
}
