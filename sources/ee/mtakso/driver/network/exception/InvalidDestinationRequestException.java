package ee.mtakso.driver.network.exception;

import ee.mtakso.driver.network.response.DestinationValidationError;
import ee.mtakso.driver.network.response.ErrorData;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvalidDestinationRequestException.kt */
/* loaded from: classes3.dex */
public final class InvalidDestinationRequestException extends ApiException {

    /* renamed from: j  reason: collision with root package name */
    private final List<DestinationValidationError> f22935j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidDestinationRequestException(int i8, ErrorData errorData, String apiMessage, String endpoint, List<DestinationValidationError> validationErrors) {
        super(i8, errorData, apiMessage, endpoint);
        Intrinsics.f(apiMessage, "apiMessage");
        Intrinsics.f(endpoint, "endpoint");
        Intrinsics.f(validationErrors, "validationErrors");
        this.f22935j = validationErrors;
    }

    @Override // ee.mtakso.driver.network.exception.ApiException
    public String e() {
        String c8;
        ErrorData d8 = d();
        if (d8 == null || (c8 = d8.c()) == null) {
            DestinationValidationError destinationValidationError = (DestinationValidationError) CollectionsKt___CollectionsKt.Y(this.f22935j);
            if (destinationValidationError != null) {
                return destinationValidationError.b();
            }
            return null;
        }
        return c8;
    }

    public final List<DestinationValidationError> g() {
        return this.f22935j;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        List<DestinationValidationError> list = this.f22935j;
        return message + ". Validation: " + list;
    }
}
