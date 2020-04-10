package com.alee.screenshot;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class ScreenShotIntentService extends IntentService {
    private static final String ACTION_SCREEN_SHOT = "com.alee.screenshot.action.SCREEN_SHOT";
    private static final String PARAMS_RESULT_CODE = "com.alee.screenshot.parmas.RESULT_CODE";
    private static final String PARAMS_RESULT_DATA = "com.alee.screenshot.parmas.RESULT_DATA";

    public ScreenShotIntentService() {
        super("ScreenShotIntentService");
    }

    public static void startActionScreenShot(Context context, String resultCode, Intent data) {
        Intent intent = new Intent(context, ScreenShotIntentService.class);
        intent.setAction(ACTION_SCREEN_SHOT);
        intent.putExtra(PARAMS_RESULT_CODE, resultCode);
        intent.putExtra(PARAMS_RESULT_DATA, data);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            throw new NullPointerException("null intent");
        }
        final String action = intent.getAction();
        if (ACTION_SCREEN_SHOT.equals(action)) {
            final String resultCode = intent.getStringExtra(PARAMS_RESULT_CODE);
            final Intent data = intent.getParcelableExtra(PARAMS_RESULT_DATA);
            handleActionScreenShot(resultCode, data);
        }
    }

    private void handleActionScreenShot(String resultCode, Intent data) {

    }

}
