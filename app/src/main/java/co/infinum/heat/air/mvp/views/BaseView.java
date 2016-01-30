package co.infinum.heat.air.mvp.views;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by hEAT- on 30.1.2016..
 */
public interface BaseView {

    void showProgress();

    void hideProgress();

    void showError(String message);

    void showDialog(String title, String message, MaterialDialog.SingleButtonCallback positiveCallback,
                    MaterialDialog.SingleButtonCallback negativeCallback, String positiveButtonText, String negativeButtonText);
}
