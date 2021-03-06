/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.navigation.fragment.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

/**
 * Test Navigation Activity that adds the {@link NavHostFragment} in XML.
 *
 * <p>You must call {@link NavController#setGraph(int)}
 * to set the appropriate graph for your test.</p>
 */
public class ImmediateNavigationActivity extends BaseNavigationActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immediate_navigation_activity);
    }

    public static class NavigateOnResumeFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                @Nullable Bundle savedInstanceState) {
            return new FrameLayout(requireContext());
        }

        @Override
        public void onResume() {
            super.onResume();
            NavHostFragment.findNavController(this).navigate(R.id.deep_link_test);
        }
    }

}
