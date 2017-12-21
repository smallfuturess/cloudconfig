package Utils;/*
 *  Copyright (c) 2014-2017. 墨博云舟 All Rights Reserved.
 */

/**
 * Utils.CommonException :
 *
 * @author zhang.lei
 * @version 1.00
 * @since 2017/12/14 10:57
 */
public class CommonException extends  Exception{

    private int errorCode;
    private String errorMessage;
    private boolean showFlag;

    public CommonException(){
        super();
    }

    public CommonException(int errorCode, String errorMessage,boolean showFlag){
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.showFlag = showFlag;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isShowFlag() {
        return showFlag;
    }

    public void setShowFlag(boolean showFlag) {
        this.showFlag = showFlag;
    }
}
