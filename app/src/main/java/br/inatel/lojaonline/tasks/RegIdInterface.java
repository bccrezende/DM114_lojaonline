package br.inatel.lojaonline.tasks;

import java.io.IOException;

/**
 * Created by bccre on 02/07/2016.
 */
public interface RegIdInterface {
    void regIdFinished (String registrationID);
    void regIdFailed (String error);
}
