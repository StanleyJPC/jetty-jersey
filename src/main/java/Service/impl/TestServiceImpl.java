package Service.impl;

import Dao.TestDao;
import Service.TestService;

import javax.inject.Inject;

/**
 * Created by BenBen嚓 on 2018/4/3.
 */
public class TestServiceImpl implements TestService{
    @Inject
    private TestDao testDao;
    @Override
    public String intertest() {
        return testDao.intertest();
    }



}
