package Res;

import Service.TestService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by BenBen嚓 on 2018/4/3.
 */
@Path("test")
public class RestInterface {
    @Inject
    private TestService testService;

    @Path("videosource_info")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String  getTaskInfo(){
        String a = testService.intertest();
        String[] b = a.split(";");
        return "{\"total\":"+b[0]+",\"forward\":"+b[1]+",\"record\":100,\"trans\":200}";
    }



}
