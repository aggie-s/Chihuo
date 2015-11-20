package com.laioffer.laiofferproject;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class YelpApi {

    private static final String API_HOST = "api.yelp.com";
    private static final String SEARCH_PATH = "/v2/search";
    
    private static final String CONSUMER_KEY = "S5Rh-oJF7YbuZQQP6zSDtw";
    private static final String CONSUMER_SECRET = "5i5ogI92Nfxsa0k67RrY9Of2dVE";
    private static final String TOKEN = "8zgLLtCSlvc1OzLPY9y12E_vZqN3oEHb";
    private static final String TOKEN_SECRET = "ZnWA9otwttqJ9TeEz6rO8dCXV2k";

    private OAuthService service;
    private Token accessToken;

    public YelpApi() {
        this.service = new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(CONSUMER_KEY).apiSecret(CONSUMER_SECRET).build();
        this.accessToken = new Token(TOKEN, TOKEN_SECRET);
    }

    public String searchForBusinessesByLocation(String term, String location, int searchLimit) {
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://" + API_HOST + SEARCH_PATH);
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("location", location);
        request.addQuerystringParameter("limit", String.valueOf(searchLimit));
        this.service.signRequest(this.accessToken, request);
        Response response = request.send();
        return response.getBody();
    }
}
