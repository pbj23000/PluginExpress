package org.restexpress.plugin.xsecurity;

import org.restexpress.common.exception.ConfigurationException;

import java.util.Properties;

/**
 * Supports reading properties for the values set on the XFrameOptionsPlugin.
 * The properties file is expected to have values for the following:
 * <ul>
 *     <li>xsecurity.xframeoptions.allowFromOrigin - a serialized-origin used in the allow-from option</li>
 * </ul>
 * A sample configuration looks something like the following:
 * <p/>
 * xsecurity.xframeoptions.allowFromOrigin = http://example.com/<br/>
 * <p/>
 * All values are required or a ConfigurationException is thrown.
 *
 * @author pbj23000
 * @since November 14, 2014
 */
public class XFrameOptionsConfig {

    private static final String ALLOW_FROM_ORIGIN_PROPERTY = "xsecurity.xframeoptions.allowFromOrigin";
    private static final String DENY = "DENY";
    private static final String SAMEORIGIN = "SAMEORIGIN";
    private static final String ALLOW_FROM = "ALLOW-FROM";

    private String allowFromOrigin;

    public XFrameOptionsConfig(Properties p) {

        allowFromOrigin = p.getProperty(ALLOW_FROM_ORIGIN_PROPERTY);

        if (allowFromOrigin == null) {
            throw new ConfigurationException("Please define XFrameOptions Allow From Uri for property: " + ALLOW_FROM_ORIGIN_PROPERTY);
        }
    }

    public String getDeny() { return DENY; }

    public String getSameorigin() { return SAMEORIGIN; }

    public String getAllowFrom() { return ALLOW_FROM + " " + allowFromOrigin; }
}
