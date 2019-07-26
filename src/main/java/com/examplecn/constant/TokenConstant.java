package com.examplecn.constant;

import java.util.concurrent.TimeUnit;

public class TokenConstant {

    public static final String TOKEN_HEADER = "Authorization";

    public static final String TOKEN_HASH = "token_hash";

    public static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    public static final Long TOKEN_EXPIRE_TIME = 1 * 24 * 60 * 60 * 1000L;//多长时间后该token过期，以毫秒为单位

    public static final String PAYLOAD_ACCOUNT_ID = "accountId";

    public static final String PAYLOAD_CREDENTIAL_ID = "credentialId";

    public static final String PAYLOAD_EXPIRE_NAME = "exp";

    public static final String TOKEN_PREFIX = "Bearer";
}
