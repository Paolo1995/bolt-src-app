package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
final class AppCompatTextClassifierHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private TextView f1915a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f1916b;

    /* loaded from: classes.dex */
    private static final class Api26Impl {
        private Api26Impl() {
        }

        @NonNull
        static TextClassifier a(@NonNull TextView textView) {
            Object systemService;
            systemService = textView.getContext().getSystemService(TextClassificationManager.class);
            TextClassificationManager textClassificationManager = (TextClassificationManager) systemService;
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatTextClassifierHelper(@NonNull TextView textView) {
        this.f1915a = (TextView) Preconditions.g(textView);
    }

    @NonNull
    public TextClassifier a() {
        TextClassifier textClassifier = this.f1916b;
        if (textClassifier == null) {
            return Api26Impl.a(this.f1915a);
        }
        return textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f1916b = textClassifier;
    }
}
