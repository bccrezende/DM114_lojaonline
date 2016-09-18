package br.inatel.lojaonline.gcm;

/**
 * Created by bccre on 25/06/2016.
 */
import java.io.IOException;

public interface GCMRegisterEvents {
    void gcmRegisterFinished (String registrationID);
    void gcmRegisterFailed (IOException ex);
    void gcmUnregisterFinished ();
    void gcmUnregisterFailed (IOException ex);
}
