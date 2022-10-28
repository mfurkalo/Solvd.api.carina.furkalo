import api.GetDataMethod;
import api.GetJokeMethods;
import api.PostJokeMethods;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    public void testGetDataPositive() {
        GetDataMethod getDataMethod = new GetDataMethod();
        getDataMethod.replaceUrlPlaceholder("parameters", "measures=Population");
        getDataMethod.callAPIExpectSuccess();
        getDataMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getDataMethod.validateResponseAgainstSchema("api.datausa._get/rs_NationalYears.schema");
    }

    @Test()
    public void testGetDataNegative() {
        GetDataMethod getDataMethod = new GetDataMethod();
        getDataMethod.replaceUrlPlaceholder("parameters", "year=latest");
        var rs = getDataMethod.callAPI().asString();
        Assert.assertTrue(rs.contains("error"), "error word should be present in the response");
    }

    @Test()
    public void testJokeapiCategoriesPositive() {
        GetJokeMethods getJokeMethods = new GetJokeMethods();
        getJokeMethods.replaceUrlPlaceholder("end_point", "categories");
        var rs = getJokeMethods.callAPIExpectSuccess().asString();
        Assert.assertTrue(rs.contains("\"error\": false,"), "'\"error\": false,' should be present in the response");
        getJokeMethods.validateResponseAgainstSchema("api.jokeapi._get/rs_Categories.schema");
    }

    @Test()
    public void testJokeapiEndpointsPositive() {
        GetJokeMethods getJokeMethods = new GetJokeMethods();
        getJokeMethods.replaceUrlPlaceholder("end_point", "endpoints");
        getJokeMethods.callAPIExpectSuccess();
        getJokeMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getJokeMethods.validateResponseAgainstSchema("api.jokeapi._get/rs_Endpoints.schema");
    }

    @Test
    public void testJokeapiPostPositive() {
        PostJokeMethods postJokeMethods = new PostJokeMethods();
        postJokeMethods.replaceUrlPlaceholder("end_point", "submit");
        postJokeMethods.callAPIExpectSuccess();
        postJokeMethods.validateResponse();
    }

    @Test
    public void testJokeapiPostNegative() {
        PostJokeMethods postJokeMethods = new PostJokeMethods();
        postJokeMethods.replaceUrlPlaceholder("end_point", "submit");
        postJokeMethods.addUrlParameter("param", "first");
        postJokeMethods.callAPI();
        postJokeMethods.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
    }

    @Test()
    public void testJokeapiLanguagesPositive() {
        GetJokeMethods getJokeMethods = new GetJokeMethods();
        getJokeMethods.replaceUrlPlaceholder("end_point", "languages");
        var rs = getJokeMethods.callAPIExpectSuccess().asString();
        Assert.assertTrue(rs.contains("\"defaultLanguage\": \"en\""), "English should be default");
        getJokeMethods.validateResponseAgainstSchema("api.jokeapi._get/rs_Languages.schema");
    }

    @Test()
    public void testJokeapiFormatsPositive() {
        GetJokeMethods getJokeMethods = new GetJokeMethods();
        getJokeMethods.replaceUrlPlaceholder("end_point", "formats");
        var rs = getJokeMethods.callAPIExpectSuccess().asString();
        Assert.assertTrue(rs.contains("\"error\": false,"), "'\"error\": false,' should be present in the response");
        getJokeMethods.validateResponseAgainstSchema("api.jokeapi._get/rs_Formats.schema");
    }

    @Test
    public void testJokeapiAnyPositive() {
        GetJokeMethods getJokeMethods = new GetJokeMethods();
        getJokeMethods.replaceUrlPlaceholder("end_point", "joke/Any");
        var rs = getJokeMethods.callAPIExpectSuccess().asString();
        Assert.assertTrue(rs.contains("\"error\": false,"), "'\"error\": false,' should be present in the response");
        getJokeMethods.validateResponseAgainstSchema("api.jokeapi._get/rs_Joke.schema");
    }

    @Test()
    public void testJokeapiAnyAmountPositive() {
        var testAmount = 3;
        GetJokeMethods getJokeMethods = new GetJokeMethods();
        getJokeMethods.replaceUrlPlaceholder("end_point", "joke/Any");
        getJokeMethods.addUrlParameter("amount", Integer.toString(testAmount));
        var rs = getJokeMethods.callAPIExpectSuccess().asString();
        Assert.assertTrue(rs.contains("\"error\": false,"), "'\"error\": false,' should be present in the response");
        Assert.assertTrue(rs.contains("\"amount\": " + testAmount + ","), "'\"error\": amount 3,' should be present in the response");
        getJokeMethods.validateResponseAgainstSchema("api.jokeapi._get/rs_Joke3.schema");
    }

    @Test()
    public void testJokeapiAnyContainsPositive() {
        var search = "dog";
        GetJokeMethods getJokeMethods = new GetJokeMethods();
        getJokeMethods.replaceUrlPlaceholder("end_point", "joke/Any");
        getJokeMethods.addUrlParameter("contains", search);
        var rs = getJokeMethods.callAPIExpectSuccess().asString();
        Assert.assertTrue(rs.contains("\"error\": false,"), "'\"error\": false,' should be present in the response");
        Assert.assertTrue(rs.contains(search), search + " should be present in the response");
        getJokeMethods.validateResponseAgainstSchema("api.jokeapi._get/rs_Joke.schema");
    }
}
