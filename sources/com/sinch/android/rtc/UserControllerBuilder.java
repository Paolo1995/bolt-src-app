package com.sinch.android.rtc;

import android.content.Context;
import androidx.annotation.NonNull;
import com.sinch.android.rtc.internal.CallbackHandler;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface UserControllerBuilder {
    UserControllerBuilder applicationKey(@NonNull String str);

    UserController build() throws IOException;

    UserControllerBuilder callbackHandler(CallbackHandler callbackHandler);

    UserControllerBuilder context(@NonNull Context context);

    UserControllerBuilder environmentHost(@NonNull String str);

    UserControllerBuilder pushConfiguration(PushConfiguration pushConfiguration);

    UserControllerBuilder userId(@NonNull String str);
}
