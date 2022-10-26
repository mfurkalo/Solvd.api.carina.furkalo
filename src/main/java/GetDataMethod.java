import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;


@Endpoint(url = "https://datausa.io/api/data?${parameters}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api.datausa._get/rs_NationalYears.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetDataMethod extends AbstractApiMethodV2 {

    public GetDataMethod(){
    }
}
