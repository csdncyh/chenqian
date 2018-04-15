package com.chenqian.service;

import com.chenqian.entity.CiBaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 页面服务
 */

@Service
public interface PageService {
    List<CiBaInfo> getCiBaInfo() throws IOException;
}
