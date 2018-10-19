package enumofme;

/**
 * @Auther: licklulu
 * @Description:
 * @Date: 2018/10/19 10:37
 */
public enum ErrorCodeOption {
    ADDCLASSROOM(1000, "Adding classroom failed"),
    DELETECLASSROOM(1001, "Deleting classroom failed");
    ErrorCodeOption(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    private Integer code;
   private String message;

    private Integer getCode() {
        return code;
    }

    private void setCode(Integer code) {
        this.code = code;
    }

    private String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        System.out.println(ErrorCodeOption.ADDCLASSROOM.code);
        System.out.println(ErrorCodeOption.ADDCLASSROOM.message);
    }
}
