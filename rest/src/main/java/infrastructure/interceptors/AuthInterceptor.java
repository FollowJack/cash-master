package infrastructure.interceptors;

/**
 * Created by Deniel on 31.01.2015.

@Provider
@PreMatching
public class AuthInterceptor implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext context) throws IOException {

        String headerValue = context.getHeaderString("X-AUTH");

        if (headerValue == null || !headerValue.equals("sicher!")) {

            ResponseBuilder responseBuilder = Response.status(Status.EXPECTATION_FAILED);
            Response response = responseBuilder.build();

            context.abortWith(response);
        }
    }
}
*/