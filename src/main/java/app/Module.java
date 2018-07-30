package app;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @Description:
 * @Date: Created in 10:16 2018/3/26
 * Created by jpc
 */
public class Module {
    private static Module module;
    private Injector injector;

    public static Module getModule(){
        synchronized (Module.class){
            if (module == null){
                module = new Module();
            }
        }
        return module;
    }

    public Module build(AbstractModule... modules){
        if (injector !=null){
            injector = null;
        }
        injector = Guice.createInjector(modules);
        return this;
    }

    public Injector getInjector() {
        return injector;
    }

    public <T> T getInstance(Class<T> clazz){
        return injector.getInstance(clazz);
    }
}
