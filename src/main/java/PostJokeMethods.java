import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "https://v2.jokeapi.dev/${end_point}", methodType = HttpMethodType.POST)
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostJokeMethods extends AbstractApiMethodV2 {

    public PostJokeMethods(){
        super("api/jokeapi/_post/rq.json","api/jokeapi/_post/rs.json");
    }
}
