package androidx.emoji.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.emoji.R$styleable;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public class EditTextAttributeHelper {

    /* renamed from: a  reason: collision with root package name */
    private int f6388a;

    public EditTextAttributeHelper(@NonNull View view, AttributeSet attributeSet, int i8, int i9) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.f6296b, i8, i9);
            this.f6388a = obtainStyledAttributes.getInteger(R$styleable.f6297c, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            obtainStyledAttributes.recycle();
        }
    }

    public int a() {
        return this.f6388a;
    }
}
