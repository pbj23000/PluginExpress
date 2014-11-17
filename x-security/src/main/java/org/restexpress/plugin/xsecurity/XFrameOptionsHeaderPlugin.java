package org.restexpress.plugin.xsecurity;

import org.jboss.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;
import org.restexpress.common.util.StringUtils;
import org.restexpress.domain.metadata.RouteMetadata;
import org.restexpress.pipeline.Postprocessor;
import org.restexpress.plugin.AbstractPlugin;
import org.restexpress.route.RouteBuilder;
import org.restexpress.util.Callback;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cjm on 11/14/14.
 */
public class XFrameOptionsHeaderPlugin extends AbstractPlugin {

    private static final String X_FRAME_OPTIONS_HEADER = "X-Frame-Options";

    private String option;
    private String allowFromOrigin;

    public XFrameOptionsHeaderPlugin(String... origins ) {
        super();
        this.allowFromOrigin = StringUtils.join(" ", (Object[]) origins);
    }

    public XFrameOptionsHeaderPlugin option(String option) {
        if (isRegistered()) throw new UnsupportedOperationException("XFrameOptionsHeaderPlugin.option(String) must be called before register()");

        this.option = option;
        return this;
    }

    @Override
    public XFrameOptionsHeaderPlugin register(RestExpress server) {
        if (isRegistered()) return this;

        super.register(server);
        XFrameOptionsHeaderPostprocessor proc = new XFrameOptionsHeaderPostprocessor(allowFromOrigin);
        server.addFinallyProcessor(proc);

        return this;
    }

    @Override
    public void bind(RestExpress server) {
        // this method intentionally left blank
    }

   private class XFrameOptionsHeaderPostprocessor implements Postprocessor {
private static final String X_FRAME_OPTIONS_HEADER = "X-Frame-Options";

       private String allowFromOrigin = null;

       public XFrameOptionsHeaderPostprocessor(String allowFromOrigin) {

       }

   }
}
