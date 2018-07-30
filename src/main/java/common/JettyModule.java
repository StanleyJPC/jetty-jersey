package common;

import Dao.TestDao;
import Dao.impl.TestDaoImol;
import Service.TestService;
import Service.impl.TestServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.servlet.ServletScopes;

/**
 * @Description:
 * @Date: Created in 10:24 2018/3/26
 * Created by jpc
 */
public class JettyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TestDao.class).to(TestDaoImol.class).in(ServletScopes.REQUEST);
        bind(TestService.class).to(TestServiceImpl.class).in(ServletScopes.REQUEST);


    }
}
