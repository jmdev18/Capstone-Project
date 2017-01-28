/*
 * MIT License
 *
 * Copyright (c) 2016 Kartik Sharma
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.crazyhitty.chdev.ks.predator.core.posts;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.crazyhitty.chdev.ks.predator.core.BasePresenter;
import com.crazyhitty.chdev.ks.predator.core.BaseView;
import com.crazyhitty.chdev.ks.predator.models.Post;

import java.util.HashMap;
import java.util.List;

/**
 * Author:      Kartik Sharma
 * Email Id:    cr42yh17m4n@gmail.com
 * Created:     1/2/2017 10:05 PM
 * Description: Unavailable
 */

public interface PostsContract {
    interface View extends BaseView<Presenter> {
        void initLoader();

        void restartLoader();

        void destroyLoader();

        void showPosts(List<Post> posts, HashMap<Integer, String> dateHashMap);

        void unableToGetPosts(boolean onLoadMore, boolean wasLoadingOfflinePosts, String errorMessage);
    }

    interface Presenter extends BasePresenter {

        Loader<Cursor> onCreateLoader(Context context);

        void onLoadFinished(Cursor data);

        void onLoaderReset();

        CursorLoader getCursorLoader(Context context);

        void getPosts(String token, String categoryName, boolean clearPrevious);

        void loadMorePosts(String token, String categoryName);

        void updateWidgets(Context context);
    }
}
