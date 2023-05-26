package ee.mtakso.driver.network.exception;

import ee.mtakso.driver.network.response.ErrorData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvalidRequestException.kt */
/* loaded from: classes3.dex */
public final class InvalidRequestException extends ApiException {

    /* renamed from: j  reason: collision with root package name */
    private final List<Object> f22936j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidRequestException(int i8, ErrorData errorData, String apiMessage, String endpoint, List<Object> validationErrors) {
        super(i8, errorData, apiMessage, endpoint);
        Intrinsics.f(apiMessage, "apiMessage");
        Intrinsics.f(endpoint, "endpoint");
        Intrinsics.f(validationErrors, "validationErrors");
        this.f22936j = validationErrors;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        List<Object> list = this.f22936j;
        return message + ". Validation: " + list;
    }
}
