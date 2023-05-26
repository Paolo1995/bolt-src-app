package ee.mtakso.driver.platform.google.autofill;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GmsSmsRetriever.kt */
@Singleton
/* loaded from: classes3.dex */
public final class GmsSmsRetriever extends ConfirmationCodeRetriever {

    /* renamed from: b  reason: collision with root package name */
    private final Context f23289b;

    @Inject
    public GmsSmsRetriever(Context context) {
        Intrinsics.f(context, "context");
        this.f23289b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GmsSmsRetriever this$0, final CompletableEmitter emitter) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(emitter, "emitter");
        SmsRetrieverClient client = SmsRetriever.getClient(this$0.f23289b);
        Intrinsics.e(client, "getClient(context)");
        Task<Void> startSmsRetriever = client.startSmsRetriever();
        Intrinsics.e(startSmsRetriever, "client.startSmsRetriever()");
        final Function1<Void, Unit> function1 = new Function1<Void, Unit>() { // from class: ee.mtakso.driver.platform.google.autofill.GmsSmsRetriever$startRetriever$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Void r12) {
                Kalev.k("Sms retriever started");
                CompletableEmitter.this.onComplete();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
                b(r12);
                return Unit.f50853a;
            }
        };
        startSmsRetriever.addOnSuccessListener(new OnSuccessListener() { // from class: ee.mtakso.driver.platform.google.autofill.b
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GmsSmsRetriever.m(Function1.this, obj);
            }
        });
        startSmsRetriever.addOnFailureListener(new OnFailureListener() { // from class: ee.mtakso.driver.platform.google.autofill.c
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GmsSmsRetriever.n(CompletableEmitter.this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(CompletableEmitter emitter, Exception it) {
        Intrinsics.f(emitter, "$emitter");
        Intrinsics.f(it, "it");
        Kalev.e(it, "Sms retriever failed to start");
        emitter.onError(it);
    }

    @Override // ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever
    public void c(Intent intent) {
        Object obj;
        Status status;
        Intrinsics.f(intent, "intent");
        if (!Intrinsics.a(intent.getAction(), SmsRetriever.SMS_RETRIEVED_ACTION)) {
            return;
        }
        Bundle extras = intent.getExtras();
        String str = null;
        if (extras != null) {
            obj = extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
        } else {
            obj = null;
        }
        if (obj instanceof Status) {
            status = (Status) obj;
        } else {
            status = null;
        }
        if (status == null) {
            Kalev.e(new NullPointerException("SMS action status is null"), "SMS action status is null");
            return;
        }
        int statusCode = status.getStatusCode();
        if (statusCode != 0) {
            if (statusCode != 15) {
                Kalev.e(new IllegalArgumentException("Unknown code: " + status.getStatusCode()), "Unknown code: " + status.getStatusCode());
                return;
            }
            Kalev.d("SMS retriever timeout");
            return;
        }
        Object obj2 = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
        if (obj2 instanceof String) {
            str = (String) obj2;
        }
        if (str != null) {
            d(str);
            return;
        }
        Kalev.e(new NullPointerException("SMS message is null: " + extras), "SMS message is null");
    }

    @Override // ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever
    protected Completable h() {
        Completable i8 = Completable.i(new CompletableOnSubscribe() { // from class: ee.mtakso.driver.platform.google.autofill.a
            @Override // io.reactivex.CompletableOnSubscribe
            public final void a(CompletableEmitter completableEmitter) {
                GmsSmsRetriever.l(GmsSmsRetriever.this, completableEmitter);
            }
        });
        Intrinsics.e(i8, "create { emitter ->\n    …)\n            }\n        }");
        return i8;
    }
}
