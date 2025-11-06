package tserkovnikov.com.cleanplanetapp.util;

public class LoginInfo {
    private static String loginUserPosition;
    private static Long loginUserId;

    public static Long getLoginUserId() {
        return loginUserId;
    }

    public static void setLoginUserId(Long loginUserId) {
        LoginInfo.loginUserId = loginUserId;
    }

    public static String getLoginUserPosition() {
        return loginUserPosition;
    }

    public static void setLoginUserPosition(String loginUserPosition) {
        LoginInfo.loginUserPosition = loginUserPosition;
    }
}
