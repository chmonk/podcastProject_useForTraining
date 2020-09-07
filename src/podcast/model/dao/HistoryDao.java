package podcast.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import podcast.model.idao.IHistoryDao;
import podcast.model.javabean.HistoryBean;

//註冊dAO名稱  session.getbean時用
@Repository("HistoryDao")
public class HistoryDao implements IHistoryDao {

	// @Autowired 自動找尋適合的註冊實體
	// @Qualifier("sessionFactory") 強制找尋註冊為sessionFactory 塞到sessionFactory變數中
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public HistoryDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public HistoryBean insert(HistoryBean hBean) {
		Session session = sessionFactory.getCurrentSession();
		HistoryBean HistoryBean = session.get(HistoryBean.class, hBean.getHistoryId());

		if (HistoryBean == null) {
			session.save(hBean);
			return hBean;
		}

		return null;
	}

	@Override
	public HistoryBean select(int historyId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(HistoryBean.class, historyId);
	}

	@Override
	public boolean delete(int historyId) {
		Session session = sessionFactory.getCurrentSession();
		HistoryBean hBean = session.get(HistoryBean.class, historyId);
		if (hBean != null) {
			session.delete(hBean);
			return true;
		} else {
			return false;
		}
	}

	@Override
	// sql: "select from HistoryBean where memberId=:memberId"
	// hql: "from (這邊是對應bean的class名稱,不是tablename絕對要注意!!!!!!!!!!!!!!!!)HistoryBean
	// where memberId=:memberId"
	public List<HistoryBean> selectByMember(int memberId) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "from HistoryBean where memberId=:memberId";
		Query<HistoryBean> query = session.createQuery(hqlstr, HistoryBean.class);
		query.setParameter("memberId", memberId);

		return query.list();
	}

	@Override
	public List<HistoryBean> selectByPodcast(int podcastId) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = " from HistoryBean where podcastId=:podcastId";
		Query<HistoryBean> query = session.createQuery(hqlstr, HistoryBean.class);
		query.setParameter("podcastId", podcastId);

		return query.list();
	}

	@Override
	public List<HistoryBean> selectByPublisher(int publisherId) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = " from HistoryBean where publisherId=:publisherId";
		Query<HistoryBean> query = session.createQuery(hqlstr, HistoryBean.class);
		query.setParameter("publisherId", publisherId);

		return query.list();
	}

}