
package Practice;
import java.util.*;

public class coursesPOJO {
    private apiPOJO apiPOJO;
    private List<webAutomationPOJO> webAutomationPOJO;
    private   mobilePOJO mobilePOJO;

    public List<webAutomationPOJO> getWebAutomation() {
        return webAutomationPOJO;
    }

    public void setWebAutomation(List<webAutomationPOJO> webAutomation) {
        this.webAutomationPOJO = webAutomation;
    }

    public apiPOJO getApi() {
        return apiPOJO;
    }

    public void setApi(apiPOJO api) {
        this.apiPOJO = api;
    }

    public mobilePOJO getMobile() {
        return mobilePOJO;
    }

    public void setMobile(mobilePOJO mobile) {
        this.mobilePOJO = mobile;
    }
}
