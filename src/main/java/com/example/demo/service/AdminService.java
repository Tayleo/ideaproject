package com.example.demo.service;


import com.example.demo.result.Result;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface AdminService {
    Result login();

    Result getAllRole();
    Result addupdateRole(Map params);
    Result deleteRole(Map params);

    Result getPermission(Map params);
    Result deletePermission(Map params);
    Result addupdatePermission(Map params);

    Result relativeList( Map params);
    Result childrenList(Map params);
    Result agreeRelease( Map params);
    Result disagree( Map params);

    Result getLogs(Map params);

}
