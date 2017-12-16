namespace java com.cag.thrift

enum RequestType {
    SAY_HELLO,
    QUERY_TIME,
}

struct Request {
    1: required RequestType type;
    2: required string name;
    3: optional i32 age;
}

exception RequestException {
    1: required i32 code;
    2: optional string reason;
}

service HelloService {
    string doAction(1: Request request) throws (1: RequestException requestException);
}