package nl.loxia.raildocs.raildocs;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.RequiresAuthentication;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

/**
 * Created by Tiemen on 10-6-2014.
 */
@Rest(rootUrl = "https://www.railcloud.nl/railcloud/infra", converters = {GsonHttpMessageConverter.class})
public interface IRailCloud {
    @Get("/namespaces")
    @RequiresAuthentication
    void getNamespaces();

    void setHttpBasicAuth(String username, String password);
}
