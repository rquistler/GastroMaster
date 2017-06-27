/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.presentation.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;

import de.hsb.gastromaster.R;

/**
 * The type Test activity.
 */
@VisibleForTesting
public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }
}
