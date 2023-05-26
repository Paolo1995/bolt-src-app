package ee.mtakso.driver.platform.google.store_integrity;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityServiceException;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import ee.mtakso.driver.platform.google.store_integrity.GoogleIntegrityCheck;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityCheck;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleIntegrityCheck.kt */
/* loaded from: classes3.dex */
public final class GoogleIntegrityCheck implements StoreIntegrityCheck {

    /* renamed from: a  reason: collision with root package name */
    private final IntegrityManager f23339a;

    @Inject
    public GoogleIntegrityCheck(Context applicationContext) {
        Intrinsics.f(applicationContext, "applicationContext");
        IntegrityManager a8 = IntegrityManagerFactory.a(applicationContext);
        Intrinsics.e(a8, "create(applicationContext)");
        this.f23339a = a8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GoogleIntegrityCheck this$0, IntegrityTokenRequest integrityTokenRequest, String str, SingleEmitter emitter) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(emitter, "emitter");
        Task<IntegrityTokenResponse> a8 = this$0.f23339a.a(integrityTokenRequest);
        Intrinsics.e(a8, "integrityManager\n       …en(integrityTokenRequest)");
        this$0.f(a8, str, emitter);
    }

    private final void f(Task<IntegrityTokenResponse> task, final String str, final SingleEmitter<StoreIntegrityVerificationResult> singleEmitter) {
        final Function1<IntegrityTokenResponse, Unit> function1 = new Function1<IntegrityTokenResponse, Unit>() { // from class: ee.mtakso.driver.platform.google.store_integrity.GoogleIntegrityCheck$doIntegrityRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(IntegrityTokenResponse integrityTokenResponse) {
                singleEmitter.onSuccess(new StoreIntegrityVerificationResult.Success(str, integrityTokenResponse.a()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntegrityTokenResponse integrityTokenResponse) {
                b(integrityTokenResponse);
                return Unit.f50853a;
            }
        };
        task.addOnSuccessListener(new OnSuccessListener() { // from class: c2.b
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GoogleIntegrityCheck.g(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: c2.c
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GoogleIntegrityCheck.h(SingleEmitter.this, str, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(SingleEmitter emitter, String str, Exception exception) {
        IntegrityServiceException integrityServiceException;
        Integer num;
        StoreIntegrityVerificationResult.ErrorType errorType;
        String valueOf;
        Intrinsics.f(emitter, "$emitter");
        Intrinsics.f(exception, "exception");
        Kalev.e(exception, "Google Integrity check exception");
        String str2 = null;
        if (exception instanceof IntegrityServiceException) {
            integrityServiceException = (IntegrityServiceException) exception;
        } else {
            integrityServiceException = null;
        }
        if (integrityServiceException != null) {
            num = Integer.valueOf(integrityServiceException.a());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == -6) {
            errorType = StoreIntegrityVerificationResult.ErrorType.PLAY_SERVICE_UPDATE_REQUIRED;
        } else if (num != null && num.intValue() == -15) {
            errorType = StoreIntegrityVerificationResult.ErrorType.PLAY_SERVICE_UPDATE_REQUIRED;
        } else if (num != null && num.intValue() == -2) {
            errorType = StoreIntegrityVerificationResult.ErrorType.PLAY_STORE_UPDATE_REQUIRED;
        } else if (num != null && num.intValue() == -14) {
            errorType = StoreIntegrityVerificationResult.ErrorType.PLAY_STORE_UPDATE_REQUIRED;
        } else if (num != null && num.intValue() == -4) {
            errorType = StoreIntegrityVerificationResult.ErrorType.PLAY_STORE_UPDATE_REQUIRED;
        } else if (num != null && num.intValue() == -9) {
            errorType = StoreIntegrityVerificationResult.ErrorType.PLAY_STORE_UPDATE_REQUIRED;
        } else if (num != null && num.intValue() == -1) {
            errorType = StoreIntegrityVerificationResult.ErrorType.PLAY_STORE_UPDATE_REQUIRED;
        } else {
            errorType = StoreIntegrityVerificationResult.ErrorType.RETRY_OR_BACKEND_HANDLING_REQUIRED;
        }
        if (integrityServiceException == null || (valueOf = integrityServiceException.getMessage()) == null) {
            Throwable cause = exception.getCause();
            if (cause != null) {
                str2 = cause.getMessage();
            }
            valueOf = String.valueOf(str2);
        }
        emitter.onError(new StoreIntegrityVerificationResult.Error(valueOf, str, errorType));
    }

    @Override // ee.mtakso.driver.platform.store_integrity.StoreIntegrityCheck
    public Single<StoreIntegrityVerificationResult> a(String nonce, final String str) {
        Intrinsics.f(nonce, "nonce");
        final IntegrityTokenRequest a8 = IntegrityTokenRequest.a().b(nonce).a();
        Single<StoreIntegrityVerificationResult> f8 = Single.f(new SingleOnSubscribe() { // from class: c2.a
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                GoogleIntegrityCheck.e(GoogleIntegrityCheck.this, a8, str, singleEmitter);
            }
        });
        Intrinsics.e(f8, "create { emitter ->\n    …nCode, emitter)\n        }");
        return f8;
    }
}
