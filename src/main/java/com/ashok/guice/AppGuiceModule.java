package com.ashok.guice;

import com.ashok.AppConfig;
import com.ashok.dao.UserDAO;
import com.ashok.exception.AppExceptionMapper;
import com.ashok.exception.ConstraintViolationExceptionMapper;
import com.ashok.filter.AppFilter;
import com.ashok.resources.CounterResource;
import com.ashok.resources.UserResource;
import com.ashok.service.UserService;
import com.ashok.service.UserServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class AppGuiceModule extends DropwizardAwareModule<AppConfig> {


    @Override
    protected void configure() {

        //DAO registration
        registerDAO(environment(), configuration());


        //Exception mappers
        bind(AppExceptionMapper.class).in(Singleton.class);
        bind(ConstraintViolationExceptionMapper.class).in(Singleton.class);

        //Resources
        bind(UserResource.class).in(Singleton.class);
        bind(CounterResource.class).in(Singleton.class);

        //Service
        bind(UserService.class).to(UserServiceImpl.class).in(Singleton.class);

        //Filters
        environment().jersey().register(AppFilter.class);


    }

    private void registerDAO(Environment environment, AppConfig configuration) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDatabase(), "mysql");
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        bind(UserDAO.class).toInstance(userDAO);
    }


}
