package countingmars.web;

public class ApiResponse {
    private Head head;
    private Object body;

    public ApiResponse() {}

    private ApiResponse(Head head, Object body) {
        this.head = head;
        this.body = body;
    }

    public Head getHead() {
        return head;
    }

    public Object getBody() {
        return body;
    }

    public static ApiResponse ok(Object body) {
        return new ApiResponse(Head.ok, body);
    }

    public static class Head {
        public static Head ok = new Head(200, "OK");

        int code;
        String name;

        public Head() {}
        public Head(int code, String name) {
            this.code = code;
            this.name = name;
        }
        public int getCode() {
            return code;
        }
        public String getName() {
            return name;
        }
    }
}
