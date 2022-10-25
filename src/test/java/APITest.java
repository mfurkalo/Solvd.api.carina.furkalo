import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    public void testGetData() {
        GetDataMethod getDataMethod = new GetDataMethod();
        getDataMethod.setHeaders("measures=Population");
        getDataMethod.callAPIExpectSuccess();
    }

    @Test()
    public void testJokeapiEndpoints(){
        GetJokeMethods getJokeMethods = new GetJokeMethods();
        getJokeMethods.replaceUrlPlaceholder("end_point", "categories");
        getJokeMethods.callAPIExpectSuccess();
    }

    @Test
    public void testJokeapiAny(){
        GetJokeMethods getJokeMethods = new GetJokeMethods();
        getJokeMethods.replaceUrlPlaceholder("end_point", "joke/Any?lang=ru");
        getJokeMethods.setHeaders("lang=ru");
        getJokeMethods.callAPIExpectSuccess();
    }

    @Test
    public void testJokeapiPost(){
        PostJokeMethods postJokeMethods = new PostJokeMethods();
        postJokeMethods.replaceUrlPlaceholder( "end_point", "submit");
        postJokeMethods.callAPIExpectSuccess();
    }
}
