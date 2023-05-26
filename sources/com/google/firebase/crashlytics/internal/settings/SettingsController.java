package com.google.firebase.crashlytics.internal.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SettingsController implements SettingsProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16173a;

    /* renamed from: b  reason: collision with root package name */
    private final SettingsRequest f16174b;

    /* renamed from: c  reason: collision with root package name */
    private final SettingsJsonParser f16175c;

    /* renamed from: d  reason: collision with root package name */
    private final CurrentTimeProvider f16176d;

    /* renamed from: e  reason: collision with root package name */
    private final CachedSettingsIo f16177e;

    /* renamed from: f  reason: collision with root package name */
    private final SettingsSpiCall f16178f;

    /* renamed from: g  reason: collision with root package name */
    private final DataCollectionArbiter f16179g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicReference<Settings> f16180h;

    /* renamed from: i  reason: collision with root package name */
    private final AtomicReference<TaskCompletionSource<Settings>> f16181i;

    SettingsController(Context context, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference<Settings> atomicReference = new AtomicReference<>();
        this.f16180h = atomicReference;
        this.f16181i = new AtomicReference<>(new TaskCompletionSource());
        this.f16173a = context;
        this.f16174b = settingsRequest;
        this.f16176d = currentTimeProvider;
        this.f16175c = settingsJsonParser;
        this.f16177e = cachedSettingsIo;
        this.f16178f = settingsSpiCall;
        this.f16179g = dataCollectionArbiter;
        atomicReference.set(DefaultSettingsJsonTransform.b(currentTimeProvider));
    }

    public static SettingsController l(Context context, String str, IdManager idManager, HttpRequestFactory httpRequestFactory, String str2, String str3, FileStore fileStore, DataCollectionArbiter dataCollectionArbiter) {
        String g8 = idManager.g();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        return new SettingsController(context, new SettingsRequest(str, idManager.h(), idManager.i(), idManager.j(), idManager, CommonUtils.h(CommonUtils.n(context), str, str3, str2), str3, str2, DeliveryMechanism.a(g8).c()), systemCurrentTimeProvider, new SettingsJsonParser(systemCurrentTimeProvider), new CachedSettingsIo(fileStore), new DefaultSettingsSpiCall(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), httpRequestFactory), dataCollectionArbiter);
    }

    private Settings m(SettingsCacheBehavior settingsCacheBehavior) {
        Settings settings = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject b8 = this.f16177e.b();
                if (b8 != null) {
                    Settings b9 = this.f16175c.b(b8);
                    if (b9 != null) {
                        q(b8, "Loaded cached settings: ");
                        long a8 = this.f16176d.a();
                        if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) && b9.a(a8)) {
                            Logger.f().i("Cached settings have expired.");
                        }
                        try {
                            Logger.f().i("Returning cached settings.");
                            settings = b9;
                        } catch (Exception e8) {
                            e = e8;
                            settings = b9;
                            Logger.f().e("Failed to get cached settings", e);
                            return settings;
                        }
                    } else {
                        Logger.f().e("Failed to parse cached settings data.", null);
                    }
                } else {
                    Logger.f().b("No cached settings data found.");
                }
            }
        } catch (Exception e9) {
            e = e9;
        }
        return settings;
    }

    private String n() {
        return CommonUtils.r(this.f16173a).getString("existing_instance_identifier", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONObject jSONObject, String str) throws JSONException {
        Logger f8 = Logger.f();
        f8.b(str + jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public boolean r(String str) {
        SharedPreferences.Editor edit = CommonUtils.r(this.f16173a).edit();
        edit.putString("existing_instance_identifier", str);
        edit.apply();
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsProvider
    public Task<Settings> a() {
        return this.f16181i.get().getTask();
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsProvider
    public Settings b() {
        return this.f16180h.get();
    }

    boolean k() {
        return !n().equals(this.f16174b.f16189f);
    }

    public Task<Void> o(SettingsCacheBehavior settingsCacheBehavior, Executor executor) {
        Settings m8;
        if (!k() && (m8 = m(settingsCacheBehavior)) != null) {
            this.f16180h.set(m8);
            this.f16181i.get().trySetResult(m8);
            return Tasks.forResult(null);
        }
        Settings m9 = m(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (m9 != null) {
            this.f16180h.set(m9);
            this.f16181i.get().trySetResult(m9);
        }
        return this.f16179g.j(executor).onSuccessTask(executor, new SuccessContinuation<Void, Void>() { // from class: com.google.firebase.crashlytics.internal.settings.SettingsController.1
            @Override // com.google.android.gms.tasks.SuccessContinuation
            @NonNull
            /* renamed from: a */
            public Task<Void> then(Void r52) throws Exception {
                JSONObject a8 = SettingsController.this.f16178f.a(SettingsController.this.f16174b, true);
                if (a8 != null) {
                    Settings b8 = SettingsController.this.f16175c.b(a8);
                    SettingsController.this.f16177e.c(b8.f16159c, a8);
                    SettingsController.this.q(a8, "Loaded settings: ");
                    SettingsController settingsController = SettingsController.this;
                    settingsController.r(settingsController.f16174b.f16189f);
                    SettingsController.this.f16180h.set(b8);
                    ((TaskCompletionSource) SettingsController.this.f16181i.get()).trySetResult(b8);
                }
                return Tasks.forResult(null);
            }
        });
    }

    public Task<Void> p(Executor executor) {
        return o(SettingsCacheBehavior.USE_CACHE, executor);
    }
}
