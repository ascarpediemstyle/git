package actions;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

public class BasicAuth extends Action.Simple {

    private static final String AUTHORIZATION = "authorization";
    private static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    private static final String REALM = "Basic realm=\"Enter your login ID and password, please.\"";

    public Result call(Http.Context ctx) throws Throwable {
        String authHeader = ctx.request().getHeader(AUTHORIZATION);
        if (authHeader == null) {
            ctx.response().setHeader(WWW_AUTHENTICATE, REALM);
            return unauthorized();
        }

        String auth = authHeader.substring(6);
        byte[] decodedAuth = new sun.misc.BASE64Decoder().decodeBuffer(auth);
        String[] credString = new String(decodedAuth, "UTF-8").split(":");

        if (credString == null || credString.length != 2) {
            return unauthorized();
        }

        String username = credString[0];
        String password = credString[1];

        if ( username.equals("userid") && password.equals("password") ) {
            return delegate.call(ctx);
        } else {
            return unauthorized();
        }
    }
}
