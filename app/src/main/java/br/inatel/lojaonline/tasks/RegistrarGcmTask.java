package br.inatel.lojaonline.tasks;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;

import br.inatel.lojaonline.gcm.GCMRegisterEvents;
import br.inatel.lojaonline.util.WSUtil;
import br.inatel.lojaonline.webservice.WebServiceClient;
import br.inatel.lojaonline.webservice.WebServiceResponse;

/**
 * Created by bccre on 02/07/2016.
 */
public class RegistrarGcmTask {

    private static final String REG_ID = "/api/users";
    private RegIdInterface regIdInterface;
    private String regId;
    private Context context;
    private String baseAddress;

    public RegistrarGcmTask(Context context, RegIdInterface regIdInterface){
        this.regIdInterface = regIdInterface;
        this.context = context;
        baseAddress = WSUtil.getHostAddress(context);
    }

    public void registrarRegId(final String regId) {
        new AsyncTask<Integer, Void, WebServiceResponse>() {

            @Override
            protected WebServiceResponse doInBackground(Integer... id) {
                return WebServiceClient.put(context,
                        baseAddress + REG_ID+"/update_gcm_reg_id/"+"{"+regId+"}");
            }
            @Override
            protected void onPostExecute(
                    WebServiceResponse webServiceResponse) {
                if (webServiceResponse.getResponseCode() == 200) {
                    regIdInterface.regIdFinished("REGISTRADO!");
                } else {
                    regIdInterface.regIdFailed("ERRO");
                }
            }
        }.execute();
    }
}
