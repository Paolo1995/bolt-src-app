package android.security.keystore;

import android.annotation.NonNull;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public final /* synthetic */ class KeyGenParameterSpec implements AlgorithmParameterSpec {

    /* loaded from: classes.dex */
    public final /* synthetic */ class Builder {
        static {
            throw new NoClassDefFoundError();
        }

        public /* synthetic */ Builder(@NonNull String str, int i8) {
        }

        @NonNull
        public native /* synthetic */ KeyGenParameterSpec build();

        @NonNull
        public native /* synthetic */ Builder setBlockModes(String... strArr);

        @NonNull
        public native /* synthetic */ Builder setCertificateNotAfter(@NonNull Date date);

        @NonNull
        public native /* synthetic */ Builder setCertificateNotBefore(@NonNull Date date);

        @NonNull
        public native /* synthetic */ Builder setCertificateSerialNumber(@NonNull BigInteger bigInteger);

        @NonNull
        public native /* synthetic */ Builder setCertificateSubject(@NonNull X500Principal x500Principal);

        @NonNull
        public native /* synthetic */ Builder setEncryptionPaddings(String... strArr);

        @NonNull
        public native /* synthetic */ Builder setKeySize(int i8);
    }

    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public native /* synthetic */ String[] getBlockModes();

    @NonNull
    public native /* synthetic */ String[] getEncryptionPaddings();

    public native /* synthetic */ int getKeySize();

    @NonNull
    public native /* synthetic */ String getKeystoreAlias();

    public native /* synthetic */ int getPurposes();

    public native /* synthetic */ int getUserAuthenticationValidityDurationSeconds();

    public native /* synthetic */ boolean isUserAuthenticationRequired();
}
