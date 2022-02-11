package hu.siposadam.servlet;

import hu.siposadam.api.CategoryService;
import hu.siposadam.api.ProductService;
import hu.siposadam.api.UnitService;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class MyApp extends Application {

    @Override
    public Set<Object> getSingletons() {
        Set<Object> set = new HashSet<>();
        set.add(new ProductService());
        set.add(new CategoryService());
        set.add(new UnitService());
        return set;
    }
}

//JERSEY
//@ApplicationPath("/api")
//public class MyApp extends ResourceConfig {
//    public MyApp() {
//        packages("hu.siposadam.api.CategoryService");
//    }
//}
