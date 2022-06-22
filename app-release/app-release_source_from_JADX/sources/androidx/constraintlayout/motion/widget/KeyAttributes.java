package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.C0174R;
import java.util.HashMap;
import java.util.HashSet;

public class KeyAttributes extends Key {
    private static final boolean DEBUG = false;
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttributes";
    /* access modifiers changed from: private */
    public float mAlpha = Float.NaN;
    /* access modifiers changed from: private */
    public int mCurveFit = -1;
    /* access modifiers changed from: private */
    public float mElevation = Float.NaN;
    /* access modifiers changed from: private */
    public float mPivotX = Float.NaN;
    /* access modifiers changed from: private */
    public float mPivotY = Float.NaN;
    /* access modifiers changed from: private */
    public float mProgress = Float.NaN;
    /* access modifiers changed from: private */
    public float mRotation = Float.NaN;
    /* access modifiers changed from: private */
    public float mRotationX = Float.NaN;
    /* access modifiers changed from: private */
    public float mRotationY = Float.NaN;
    /* access modifiers changed from: private */
    public float mScaleX = Float.NaN;
    /* access modifiers changed from: private */
    public float mScaleY = Float.NaN;
    /* access modifiers changed from: private */
    public String mTransitionEasing;
    /* access modifiers changed from: private */
    public float mTransitionPathRotate = Float.NaN;
    /* access modifiers changed from: private */
    public float mTranslationX = Float.NaN;
    /* access modifiers changed from: private */
    public float mTranslationY = Float.NaN;
    /* access modifiers changed from: private */
    public float mTranslationZ = Float.NaN;
    private boolean mVisibility = false;

    public KeyAttributes() {
        this.mType = 1;
        this.mCustomConstraints = new HashMap();
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, C0174R.styleable.KeyAttribute));
    }

    /* access modifiers changed from: package-private */
    public int getCurveFit() {
        return this.mCurveFit;
    }

    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mPivotX)) {
            hashSet.add(Key.PIVOT_X);
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashSet.add(Key.PIVOT_Y);
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add("progress");
        }
        if (this.mCustomConstraints.size() > 0) {
            for (String str : this.mCustomConstraints.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.mCurveFit != -1) {
            if (!Float.isNaN(this.mAlpha)) {
                hashMap.put("alpha", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mElevation)) {
                hashMap.put("elevation", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotation)) {
                hashMap.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotationX)) {
                hashMap.put("rotationX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotationY)) {
                hashMap.put("rotationY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mPivotX)) {
                hashMap.put(Key.PIVOT_X, Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mPivotY)) {
                hashMap.put(Key.PIVOT_Y, Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationX)) {
                hashMap.put("translationX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationY)) {
                hashMap.put("translationY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationZ)) {
                hashMap.put("translationZ", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTransitionPathRotate)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mScaleX)) {
                hashMap.put("scaleX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mScaleY)) {
                hashMap.put("scaleY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mProgress)) {
                hashMap.put("progress", Integer.valueOf(this.mCurveFit));
            }
            if (this.mCustomConstraints.size() > 0) {
                for (String str : this.mCustomConstraints.keySet()) {
                    hashMap.put("CUSTOM," + str, Integer.valueOf(this.mCurveFit));
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        if (r1.equals("transitionPathRotate") != false) goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r7) {
        /*
            r6 = this;
            java.util.Set r0 = r7.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01cf
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r7.get(r1)
            androidx.constraintlayout.core.motion.utils.SplineSet r2 = (androidx.constraintlayout.core.motion.utils.SplineSet) r2
            if (r2 != 0) goto L_0x001d
            goto L_0x0008
        L_0x001d:
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r1.startsWith(r3)
            r4 = 7
            if (r3 == 0) goto L_0x003c
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap r3 = r6.mCustomConstraints
            java.lang.Object r1 = r3.get(r1)
            androidx.constraintlayout.widget.ConstraintAttribute r1 = (androidx.constraintlayout.widget.ConstraintAttribute) r1
            if (r1 == 0) goto L_0x0008
            androidx.constraintlayout.motion.utils.ViewSpline$CustomSet r2 = (androidx.constraintlayout.motion.utils.ViewSpline.CustomSet) r2
            int r3 = r6.mFramePosition
            r2.setPoint((int) r3, (androidx.constraintlayout.widget.ConstraintAttribute) r1)
            goto L_0x0008
        L_0x003c:
            r3 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00d1;
                case -1249320805: goto L_0x00c7;
                case -1225497657: goto L_0x00bc;
                case -1225497656: goto L_0x00b1;
                case -1225497655: goto L_0x00a6;
                case -1001078227: goto L_0x009b;
                case -908189618: goto L_0x0090;
                case -908189617: goto L_0x0085;
                case -760884510: goto L_0x007b;
                case -760884509: goto L_0x0071;
                case -40300674: goto L_0x0066;
                case -4379043: goto L_0x005b;
                case 37232917: goto L_0x0051;
                case 92909918: goto L_0x0046;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x00db
        L_0x0046:
            java.lang.String r4 = "alpha"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 0
            goto L_0x00dc
        L_0x0051:
            java.lang.String r5 = "transitionPathRotate"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00db
            goto L_0x00dc
        L_0x005b:
            java.lang.String r4 = "elevation"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 1
            goto L_0x00dc
        L_0x0066:
            java.lang.String r4 = "rotation"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 2
            goto L_0x00dc
        L_0x0071:
            java.lang.String r4 = "transformPivotY"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 6
            goto L_0x00dc
        L_0x007b:
            java.lang.String r4 = "transformPivotX"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 5
            goto L_0x00dc
        L_0x0085:
            java.lang.String r4 = "scaleY"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 9
            goto L_0x00dc
        L_0x0090:
            java.lang.String r4 = "scaleX"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 8
            goto L_0x00dc
        L_0x009b:
            java.lang.String r4 = "progress"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 13
            goto L_0x00dc
        L_0x00a6:
            java.lang.String r4 = "translationZ"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 12
            goto L_0x00dc
        L_0x00b1:
            java.lang.String r4 = "translationY"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 11
            goto L_0x00dc
        L_0x00bc:
            java.lang.String r4 = "translationX"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 10
            goto L_0x00dc
        L_0x00c7:
            java.lang.String r4 = "rotationY"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 4
            goto L_0x00dc
        L_0x00d1:
            java.lang.String r4 = "rotationX"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00db
            r4 = 3
            goto L_0x00dc
        L_0x00db:
            r4 = -1
        L_0x00dc:
            switch(r4) {
                case 0: goto L_0x01be;
                case 1: goto L_0x01ad;
                case 2: goto L_0x019c;
                case 3: goto L_0x018b;
                case 4: goto L_0x017a;
                case 5: goto L_0x0169;
                case 6: goto L_0x0158;
                case 7: goto L_0x0147;
                case 8: goto L_0x0136;
                case 9: goto L_0x0125;
                case 10: goto L_0x0114;
                case 11: goto L_0x0103;
                case 12: goto L_0x00f2;
                case 13: goto L_0x00e1;
                default: goto L_0x00df;
            }
        L_0x00df:
            goto L_0x0008
        L_0x00e1:
            float r1 = r6.mProgress
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mProgress
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x00f2:
            float r1 = r6.mTranslationZ
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mTranslationZ
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0103:
            float r1 = r6.mTranslationY
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mTranslationY
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0114:
            float r1 = r6.mTranslationX
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mTranslationX
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0125:
            float r1 = r6.mScaleY
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mScaleY
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0136:
            float r1 = r6.mScaleX
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mScaleX
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0147:
            float r1 = r6.mTransitionPathRotate
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mTransitionPathRotate
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0158:
            float r1 = r6.mRotationY
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mPivotY
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0169:
            float r1 = r6.mRotationX
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mPivotX
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x017a:
            float r1 = r6.mRotationY
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mRotationY
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x018b:
            float r1 = r6.mRotationX
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mRotationX
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x019c:
            float r1 = r6.mRotation
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mRotation
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x01ad:
            float r1 = r6.mElevation
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mElevation
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x01be:
            float r1 = r6.mAlpha
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.mFramePosition
            float r3 = r6.mAlpha
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x01cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyAttributes.addValues(java.util.HashMap):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setValue(java.lang.String r2, java.lang.Object r3) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1913008125: goto L_0x00b9;
                case -1812823328: goto L_0x00ae;
                case -1249320806: goto L_0x00a4;
                case -1249320805: goto L_0x009a;
                case -1225497657: goto L_0x008f;
                case -1225497656: goto L_0x0084;
                case -1225497655: goto L_0x0079;
                case -908189618: goto L_0x006e;
                case -908189617: goto L_0x0063;
                case -760884510: goto L_0x0059;
                case -760884509: goto L_0x004d;
                case -40300674: goto L_0x0042;
                case -4379043: goto L_0x0037;
                case 37232917: goto L_0x002b;
                case 92909918: goto L_0x0020;
                case 579057826: goto L_0x0015;
                case 1941332754: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x00c3
        L_0x0009:
            java.lang.String r0 = "visibility"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 12
            goto L_0x00c4
        L_0x0015:
            java.lang.String r0 = "curveFit"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 1
            goto L_0x00c4
        L_0x0020:
            java.lang.String r0 = "alpha"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 0
            goto L_0x00c4
        L_0x002b:
            java.lang.String r0 = "transitionPathRotate"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 13
            goto L_0x00c4
        L_0x0037:
            java.lang.String r0 = "elevation"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 2
            goto L_0x00c4
        L_0x0042:
            java.lang.String r0 = "rotation"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 4
            goto L_0x00c4
        L_0x004d:
            java.lang.String r0 = "transformPivotY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 8
            goto L_0x00c4
        L_0x0059:
            java.lang.String r0 = "transformPivotX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 7
            goto L_0x00c4
        L_0x0063:
            java.lang.String r0 = "scaleY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 10
            goto L_0x00c4
        L_0x006e:
            java.lang.String r0 = "scaleX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 9
            goto L_0x00c4
        L_0x0079:
            java.lang.String r0 = "translationZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 16
            goto L_0x00c4
        L_0x0084:
            java.lang.String r0 = "translationY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 15
            goto L_0x00c4
        L_0x008f:
            java.lang.String r0 = "translationX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 14
            goto L_0x00c4
        L_0x009a:
            java.lang.String r0 = "rotationY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 6
            goto L_0x00c4
        L_0x00a4:
            java.lang.String r0 = "rotationX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 5
            goto L_0x00c4
        L_0x00ae:
            java.lang.String r0 = "transitionEasing"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 11
            goto L_0x00c4
        L_0x00b9:
            java.lang.String r0 = "motionProgress"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 3
            goto L_0x00c4
        L_0x00c3:
            r2 = -1
        L_0x00c4:
            switch(r2) {
                case 0: goto L_0x013b;
                case 1: goto L_0x0134;
                case 2: goto L_0x012d;
                case 3: goto L_0x0126;
                case 4: goto L_0x011f;
                case 5: goto L_0x0118;
                case 6: goto L_0x0111;
                case 7: goto L_0x010a;
                case 8: goto L_0x0103;
                case 9: goto L_0x00fc;
                case 10: goto L_0x00f5;
                case 11: goto L_0x00ee;
                case 12: goto L_0x00e7;
                case 13: goto L_0x00e0;
                case 14: goto L_0x00d9;
                case 15: goto L_0x00d1;
                case 16: goto L_0x00c9;
                default: goto L_0x00c7;
            }
        L_0x00c7:
            goto L_0x0141
        L_0x00c9:
            float r2 = r1.toFloat(r3)
            r1.mTranslationZ = r2
            goto L_0x0141
        L_0x00d1:
            float r2 = r1.toFloat(r3)
            r1.mTranslationY = r2
            goto L_0x0141
        L_0x00d9:
            float r2 = r1.toFloat(r3)
            r1.mTranslationX = r2
            goto L_0x0141
        L_0x00e0:
            float r2 = r1.toFloat(r3)
            r1.mTransitionPathRotate = r2
            goto L_0x0141
        L_0x00e7:
            boolean r2 = r1.toBoolean(r3)
            r1.mVisibility = r2
            goto L_0x0141
        L_0x00ee:
            java.lang.String r2 = r3.toString()
            r1.mTransitionEasing = r2
            goto L_0x0141
        L_0x00f5:
            float r2 = r1.toFloat(r3)
            r1.mScaleY = r2
            goto L_0x0141
        L_0x00fc:
            float r2 = r1.toFloat(r3)
            r1.mScaleX = r2
            goto L_0x0141
        L_0x0103:
            float r2 = r1.toFloat(r3)
            r1.mPivotY = r2
            goto L_0x0141
        L_0x010a:
            float r2 = r1.toFloat(r3)
            r1.mPivotX = r2
            goto L_0x0141
        L_0x0111:
            float r2 = r1.toFloat(r3)
            r1.mRotationY = r2
            goto L_0x0141
        L_0x0118:
            float r2 = r1.toFloat(r3)
            r1.mRotationX = r2
            goto L_0x0141
        L_0x011f:
            float r2 = r1.toFloat(r3)
            r1.mRotation = r2
            goto L_0x0141
        L_0x0126:
            float r2 = r1.toFloat(r3)
            r1.mProgress = r2
            goto L_0x0141
        L_0x012d:
            float r2 = r1.toFloat(r3)
            r1.mElevation = r2
            goto L_0x0141
        L_0x0134:
            int r2 = r1.toInt(r3)
            r1.mCurveFit = r2
            goto L_0x0141
        L_0x013b:
            float r2 = r1.toFloat(r3)
            r1.mAlpha = r2
        L_0x0141:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyAttributes.setValue(java.lang.String, java.lang.Object):void");
    }

    private static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(C0174R.styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(C0174R.styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(C0174R.styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(C0174R.styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(C0174R.styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(C0174R.styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(C0174R.styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(C0174R.styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(C0174R.styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(C0174R.styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(C0174R.styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(C0174R.styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(C0174R.styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(C0174R.styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(C0174R.styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(C0174R.styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(C0174R.styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(C0174R.styleable.KeyAttribute_motionProgress, 18);
        }

        public static void read(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        float unused = keyAttributes.mAlpha = typedArray.getFloat(index, keyAttributes.mAlpha);
                        break;
                    case 2:
                        float unused2 = keyAttributes.mElevation = typedArray.getDimension(index, keyAttributes.mElevation);
                        break;
                    case 4:
                        float unused3 = keyAttributes.mRotation = typedArray.getFloat(index, keyAttributes.mRotation);
                        break;
                    case 5:
                        float unused4 = keyAttributes.mRotationX = typedArray.getFloat(index, keyAttributes.mRotationX);
                        break;
                    case 6:
                        float unused5 = keyAttributes.mRotationY = typedArray.getFloat(index, keyAttributes.mRotationY);
                        break;
                    case 7:
                        float unused6 = keyAttributes.mScaleX = typedArray.getFloat(index, keyAttributes.mScaleX);
                        break;
                    case 8:
                        float unused7 = keyAttributes.mTransitionPathRotate = typedArray.getFloat(index, keyAttributes.mTransitionPathRotate);
                        break;
                    case 9:
                        String unused8 = keyAttributes.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyAttributes.mTargetId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                                break;
                            } else {
                                keyAttributes.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            keyAttributes.mTargetId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                            if (keyAttributes.mTargetId != -1) {
                                break;
                            } else {
                                keyAttributes.mTargetString = typedArray.getString(index);
                                break;
                            }
                        }
                    case 12:
                        keyAttributes.mFramePosition = typedArray.getInt(index, keyAttributes.mFramePosition);
                        break;
                    case 13:
                        int unused9 = keyAttributes.mCurveFit = typedArray.getInteger(index, keyAttributes.mCurveFit);
                        break;
                    case 14:
                        float unused10 = keyAttributes.mScaleY = typedArray.getFloat(index, keyAttributes.mScaleY);
                        break;
                    case 15:
                        float unused11 = keyAttributes.mTranslationX = typedArray.getDimension(index, keyAttributes.mTranslationX);
                        break;
                    case 16:
                        float unused12 = keyAttributes.mTranslationY = typedArray.getDimension(index, keyAttributes.mTranslationY);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused13 = keyAttributes.mTranslationZ = typedArray.getDimension(index, keyAttributes.mTranslationZ);
                            break;
                        }
                    case 18:
                        float unused14 = keyAttributes.mProgress = typedArray.getFloat(index, keyAttributes.mProgress);
                        break;
                    case 19:
                        float unused15 = keyAttributes.mPivotX = typedArray.getDimension(index, keyAttributes.mPivotX);
                        break;
                    case 20:
                        float unused16 = keyAttributes.mPivotY = typedArray.getDimension(index, keyAttributes.mPivotY);
                        break;
                    default:
                        Log.e(KeyAttributes.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                }
            }
        }
    }

    public Key copy(Key key) {
        super.copy(key);
        KeyAttributes keyAttributes = (KeyAttributes) key;
        this.mCurveFit = keyAttributes.mCurveFit;
        this.mVisibility = keyAttributes.mVisibility;
        this.mAlpha = keyAttributes.mAlpha;
        this.mElevation = keyAttributes.mElevation;
        this.mRotation = keyAttributes.mRotation;
        this.mRotationX = keyAttributes.mRotationX;
        this.mRotationY = keyAttributes.mRotationY;
        this.mPivotX = keyAttributes.mPivotX;
        this.mPivotY = keyAttributes.mPivotY;
        this.mTransitionPathRotate = keyAttributes.mTransitionPathRotate;
        this.mScaleX = keyAttributes.mScaleX;
        this.mScaleY = keyAttributes.mScaleY;
        this.mTranslationX = keyAttributes.mTranslationX;
        this.mTranslationY = keyAttributes.mTranslationY;
        this.mTranslationZ = keyAttributes.mTranslationZ;
        this.mProgress = keyAttributes.mProgress;
        return this;
    }

    public Key clone() {
        return new KeyAttributes().copy(this);
    }
}
