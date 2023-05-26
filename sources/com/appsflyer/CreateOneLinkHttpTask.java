package com.appsflyer;

import com.appsflyer.internal.AFc1fSDK;
import java.util.concurrent.ExecutorService;

@Deprecated
/* loaded from: classes.dex */
public final class CreateOneLinkHttpTask {
    public final AFc1fSDK AFInAppEventParameterName;
    public final ExecutorService valueOf;

    @Deprecated
    /* loaded from: classes.dex */
    public interface ResponseListener {
        void onResponse(String str);

        void onResponseError(String str);
    }

    public CreateOneLinkHttpTask() {
    }

    public CreateOneLinkHttpTask(AFc1fSDK aFc1fSDK, ExecutorService executorService) {
        this.AFInAppEventParameterName = aFc1fSDK;
        this.valueOf = executorService;
    }
}
