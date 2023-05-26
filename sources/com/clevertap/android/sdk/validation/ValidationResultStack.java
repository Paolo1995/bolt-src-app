package com.clevertap.android.sdk.validation;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class ValidationResultStack {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f11827b = new Object();

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<ValidationResult> f11828a = new ArrayList<>();

    public ValidationResult a() {
        ValidationResult validationResult;
        synchronized (f11827b) {
            validationResult = null;
            try {
                if (!this.f11828a.isEmpty()) {
                    validationResult = this.f11828a.remove(0);
                }
            } catch (Exception unused) {
            }
        }
        return validationResult;
    }

    public void b(ValidationResult validationResult) {
        synchronized (f11827b) {
            try {
                int size = this.f11828a.size();
                if (size > 50) {
                    ArrayList<ValidationResult> arrayList = new ArrayList<>();
                    for (int i8 = 10; i8 < size; i8++) {
                        arrayList.add(this.f11828a.get(i8));
                    }
                    arrayList.add(validationResult);
                    this.f11828a = arrayList;
                } else {
                    this.f11828a.add(validationResult);
                }
            } catch (Exception unused) {
            }
        }
    }
}
