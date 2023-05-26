package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraState;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.Objects;

/* loaded from: classes.dex */
class CameraStateMachine {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CameraStateRegistry f2538a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final MutableLiveData<CameraState> f2539b;

    /* renamed from: androidx.camera.camera2.internal.CameraStateMachine$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2540a;

        static {
            int[] iArr = new int[CameraInternal.State.values().length];
            f2540a = iArr;
            try {
                iArr[CameraInternal.State.PENDING_OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2540a[CameraInternal.State.OPENING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2540a[CameraInternal.State.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2540a[CameraInternal.State.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2540a[CameraInternal.State.RELEASING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2540a[CameraInternal.State.CLOSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2540a[CameraInternal.State.RELEASED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraStateMachine(@NonNull CameraStateRegistry cameraStateRegistry) {
        this.f2538a = cameraStateRegistry;
        MutableLiveData<CameraState> mutableLiveData = new MutableLiveData<>();
        this.f2539b = mutableLiveData;
        mutableLiveData.m(CameraState.a(CameraState.Type.CLOSED));
    }

    private CameraState b() {
        if (this.f2538a.a()) {
            return CameraState.a(CameraState.Type.OPENING);
        }
        return CameraState.a(CameraState.Type.PENDING_OPEN);
    }

    @NonNull
    public LiveData<CameraState> a() {
        return this.f2539b;
    }

    public void c(@NonNull CameraInternal.State state, CameraState.StateError stateError) {
        CameraState b8;
        switch (AnonymousClass1.f2540a[state.ordinal()]) {
            case 1:
                b8 = b();
                break;
            case 2:
                b8 = CameraState.b(CameraState.Type.OPENING, stateError);
                break;
            case 3:
                b8 = CameraState.b(CameraState.Type.OPEN, stateError);
                break;
            case 4:
            case 5:
                b8 = CameraState.b(CameraState.Type.CLOSING, stateError);
                break;
            case 6:
            case 7:
                b8 = CameraState.b(CameraState.Type.CLOSED, stateError);
                break;
            default:
                throw new IllegalStateException("Unknown internal camera state: " + state);
        }
        Logger.a("CameraStateMachine", "New public camera state " + b8 + " from " + state + " and " + stateError);
        if (!Objects.equals(this.f2539b.f(), b8)) {
            Logger.a("CameraStateMachine", "Publishing new public camera state " + b8);
            this.f2539b.m(b8);
        }
    }
}
