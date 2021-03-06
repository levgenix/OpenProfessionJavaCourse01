/*
 * Created by Evgeny V. Lobach on 29.09.18 21:36
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 29.09.18 21:36
 */

package app.itstudio.fragment;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("app.itstudio.fragment", appContext.getPackageName());
    }
}
