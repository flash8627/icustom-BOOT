package com.gwtjs.springsecurity.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gwtjs.springsecurity.model.SysUserVO;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, SysUserVO> implements UserDao {

	public SysUserVO findById(int id) {
		return getByKey(id);
	}

	public SysUserVO findBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		return (SysUserVO) crit.uniqueResult();
	}

	
}
