package infrastructure.interceptors;

/**
 * Created by Deniel on 31.01.2015.

@Provider
@PreMatching
public class CorsInterceptor implements ContainerResponseFilter{


    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {

        response.getHeaders().add("Access-Control-Allow-Origin","*");
        response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    }
}
*/