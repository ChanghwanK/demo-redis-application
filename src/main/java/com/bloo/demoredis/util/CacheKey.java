package com.bloo.demoredis.util;

/**
 * @Created by Bloo
 * @Date: 2021/08/09
 */


public class CacheKey {

    public static final int ONE_MIN = 60;
    public static final int TEN_MIN = 60 * 10;

    public static final int DEFAULT_EXPIRE_SEC = ONE_MIN;
    public static final int POST_EXPIRE_SEC = TEN_MIN;
    public static final String POST = "post";
    public static final String POSTS = "posts";

}
