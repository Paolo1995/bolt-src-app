package ee.mtakso.driver.network.client.audio_recording.support;

import android.net.Uri;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import ee.mtakso.driver.network.client.audio_recording.support.TripAudioSupportClient;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.Set;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: TripAudioSupportClient.kt */
/* loaded from: classes3.dex */
public final class TripAudioSupportClient {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f21386a;

    @Inject
    public TripAudioSupportClient(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        this.f21386a = okHttpClient;
    }

    private final Single<String> b(final String str) {
        Single<String> f8 = Single.f(new SingleOnSubscribe() { // from class: v1.a
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                TripAudioSupportClient.c(str, this, singleEmitter);
            }
        });
        Intrinsics.e(f8, "create { emitter ->\n    …)\n            }\n        }");
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String supportUrl, TripAudioSupportClient this$0, SingleEmitter emitter) {
        Intrinsics.f(supportUrl, "$supportUrl");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(emitter, "emitter");
        Response execute = FirebasePerfOkHttpClient.execute(this$0.f21386a.newCall(new Request.Builder().url(supportUrl).build()));
        if (execute.isSuccessful()) {
            emitter.onSuccess(execute.request().url().toString());
        }
    }

    public final Single<String> d(String url) {
        Intrinsics.f(url, "url");
        Uri parse = Uri.parse(url);
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        Intrinsics.e(queryParameterNames, "uri.queryParameterNames");
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : queryParameterNames) {
            if (!Intrinsics.a((String) obj, "language")) {
                arrayList.add(obj);
            }
        }
        for (String str : arrayList) {
            buildUpon.appendQueryParameter(str, parse.getQueryParameter(str));
        }
        String uri = buildUpon.build().toString();
        Intrinsics.e(uri, "uriWithoutLanguage.toString()");
        return b(uri);
    }
}
